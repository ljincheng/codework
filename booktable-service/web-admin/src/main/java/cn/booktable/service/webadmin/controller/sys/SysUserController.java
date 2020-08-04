package cn.booktable.service.webadmin.controller.sys;

import cn.booktable.core.constant.SystemConst;
import cn.booktable.core.page.PageDo;
import cn.booktable.core.view.JsonView;
import cn.booktable.exception.BusinessException;
import cn.booktable.modules.entity.sys.SysActionLogDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserEntity;
import cn.booktable.modules.service.sys.ParamService;
import cn.booktable.modules.service.sys.SysActionLogService;
import cn.booktable.modules.service.sys.SysUserService;
import cn.booktable.service.webadmin.controller.base.ActionLogConst;
import cn.booktable.service.webadmin.controller.base.BaseController;
import cn.booktable.service.webadmin.controller.base.PermissionCode;
import cn.booktable.service.webadmin.controller.platform.LoginController;
import cn.booktable.util.AssertUtils;
import cn.booktable.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ljc
 */
@Controller
@RequestMapping("/system/")
public class SysUserController extends BaseController {
    private static Logger logger= LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private ParamService paramService;
    @Autowired
    private SysActionLogService sysActionLogService;


    @RequestMapping(value="/queryUserList",method=RequestMethod.GET)
    public ModelAndView queryUserList_methodGet()
    {
        ModelAndView view=new ModelAndView("system/queryUserList");
        return view;
    }

    @RequestMapping(value="/queryUserList",method=RequestMethod.POST)
    public ModelAndView queryUserList_methodPost(HttpServletRequest request,String startDate,String endDate, Long pageIndex,Integer pageSize)
    {
        ModelAndView view=new ModelAndView("system/queryUserList_table");
        try{
            checkPermission(PermissionCode.system_user_list);
            Map<String, Object> selectItem=new HashMap<>();
            selectItem.put("userName", request.getParameter("userName"));
            selectItem.put("realName", request.getParameter("realName"));
            selectItem.put("telphone", request.getParameter("telphone"));
            setDateBetweemToMap(selectItem,startDate,endDate);
            pageIndex=pageIndex==null?1L:pageIndex;
            pageSize=pageSize==null?20:pageSize;

            PageDo<SysUserDo> result= sysUserService.querySysUserListPage(pageIndex, pageSize, selectItem);
            view.addObject("pagedata",result);
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("查询用户数据分页异常", e);
        }
        return view;
    }

    @RequestMapping(value="/addUser",method=RequestMethod.GET)
    public ModelAndView addUser_methodGet(Integer id)
    {
        ModelAndView view=new ModelAndView("system/editUser");

        try{
            SysUserDo sysUser = sysUserService.findSysUserById(id);
            view.addObject("sysUser", sysUser);
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("根据用户ID获取用户异常", e);
        }

        return view;
    }

    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public JsonView<String> addUser(HttpServletRequest request, SysUserDo user,String password2)
    {
        if(null != user.getId()){//修改用户
            return editUser(user,password2);
        }

        JsonView<String> view=new JsonView<String>();
        SysActionLogDo actionLogDo=getUserActionLog(request,ActionLogConst.model_system_sysuser,"新增系统账号",SysActionLogDo.LEVEL_IMPORTANT);
        try{
            checkPermission(PermissionCode.system_user_add);
            AssertUtils.isNotBlank(user.getUserName(), "用户名不能为空");
            AssertUtils.isNotBlank(user.getTelphone(), "手机号不能为空");
            AssertUtils.isNotBlank(user.getPassword(), "用户密码不能为空");
            SysUserDo dbUser=sysUserService.findSysUserByUserName(user.getUserName());
            if(dbUser!=null)
            {
                throw new BusinessException("用户名已存在");
            }
            if(!Pattern.compile(SystemConst.REGEX_TELEPHONE).matcher(user.getTelphone()).matches()){
                throw new BusinessException("手机号格式不正确");
            }
            if(!Pattern.compile(SystemConst.REGEX_PWD).matcher(user.getPassword()).matches()){
                throw new BusinessException("密码不少于8位,必须包括大写、小写和数字");
            }
            if(!user.getPassword().equals(password2))
            {
                throw new BusinessException("两次密码不一致");
            }

            if(user.getLocked()==null)
            {
                user.setLocked(1);//未锁定
            }
            String psw= DigestUtils.md5Hex(password2+ LoginController.PASS_KEY);
            user.setPassword(psw);
            user.setPlatformId(currentPlatformId());

            SysUserDo currentUser=currentUser();
            AssertUtils.notNull(currentUser,"请先登录");
            actionLogDo.setContent("操作账号："+currentUser.getUserName()+",创建账号："+user.getUserName());

            sysUserService.insertSysUser(user);
            view.setCode(view.CODE_SUCCESS);
            view.setMsg("操作成功");
        }catch(BusinessException e)
        {
            setPromptException(view, e);
            actionLogDo.setContent("新建账号失败："+e.getMessage());
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("添加用户异常", e);
            actionLogDo.setContent("新建账号失败："+e.getMessage());
        }finally {
            sysActionLogService.insertSysActionLog(actionLogDo);
        }
        return view;
    }

    /**
     * 修改用户
     * @author: sungymf
     * @date: 2017年7月27日 下午5:53:36
     * @param user
     * @param password2
     * @return
     */
    public JsonView<String> editUser(SysUserDo user,String password2)
    {
        JsonView<String> view=new JsonView<String>();
        try{
            checkPermission(PermissionCode.system_user_edit);
            AssertUtils.isNotBlank(user.getTelphone(), "手机号不能为空");
            if(!Pattern.compile(SystemConst.REGEX_TELEPHONE).matcher(user.getTelphone()).matches()){
                throw new BusinessException("手机号格式不正确");
            }
            if(user.getLocked()==null)
            {
                user.setLocked(1);//未锁定
            }
//			SysUserDo newUser = new SysUserDo();
//			newUser.setId(user.getId());
//			newUser.setRealName(user.getRealName());
//			newUser.setTelphone(user.getTelphone());
//			newUser.setLocked(user.getLocked());
            SysUserDo dbUser=sysUserService.findSysUserById(user.getId());
            dbUser.setRealName(user.getRealName());
            dbUser.setTelphone(user.getTelphone());
            dbUser.setLocked(user.getLocked());
            dbUser.setMotto(user.getMotto());
            sysUserService.updateSysUserById(dbUser);
            view.setCode(view.CODE_SUCCESS);
            view.setMsg("操作成功");
        }catch(BusinessException e)
        {
            setPromptException(view, e);
        }catch (Exception ex) {
            setPromptException(view, ex);
            logger.error("修改用户异常", ex);
        }
        return view;
    }

    @RequestMapping(value="/modifyUserRoles",method=RequestMethod.POST)
    public JsonView<String> modifyUserRoles(HttpServletRequest request, String roleListStr,Integer userId)
    {
        JsonView<String> view=new JsonView<String>();
        SysActionLogDo actionLogDo=getUserActionLog(request,ActionLogConst.model_system_sysuser,"修改用户角色",SysActionLogDo.LEVEL_IMPORTANT);
        try{
            checkPermission(PermissionCode.system_user_role_setting);
            AssertUtils.notNull(userId, "请先选择用户");
            String[] roles=null;
            if(StringUtils.isNotBlank(roleListStr))
            {
                roles=roleListStr.split(",");
            }
            SysUserDo user= sysUserService.findSysUserById(userId);
            AssertUtils.notNull(user,"无效参数");
            actionLogDo.setContent("修改账号:"+user.getUserName()+"的角色："+roleListStr);
            sysUserService.modifyUserRoles(roles, userId);
            view.setCode(view.CODE_SUCCESS);
            view.setMsg("操作成功");
        }catch (BusinessException e) {
            setPromptException(view, e);
            actionLogDo.setContent("修改账号角色失败："+e.getMessage());
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("修改用户角色异常",e);
            actionLogDo.setContent("修改账号角色失败："+e.getMessage());
        }finally {
            sysActionLogService.insertSysActionLog(actionLogDo);
        }
        return view;
    }

    @RequestMapping(value="/queryRoleUserList",method=RequestMethod.GET)
    public ModelAndView queryRoleUserList_methodGet(HttpServletRequest request,String roleId)
    {
        ModelAndView view=new ModelAndView("system/queryRoleUserList");
        try{
            view.addObject("roleId", roleId);
        }catch (Exception e) {
            logger.error("获取角色用户集异常",e);
        }
        return view;
    }

    @RequestMapping(value="/queryRoleUserList",method=RequestMethod.POST)
    public ModelAndView queryRoleUserList_methodPost(HttpServletRequest request,String startDate,String endDate, Long pageIndex,Integer pageSize)
    {
        ModelAndView view=new ModelAndView("system/queryRoleUserList_table");
        try{
            checkPermission(PermissionCode.system_role_permission_edit);
            String roleId=request.getParameter("roleId");
            Map<String, Object> selectItem=new HashMap<String, Object>();
            selectItem.put("userName", request.getParameter("userName"));
            selectItem.put("realName", request.getParameter("realName"));
            setDateBetweemToMap(selectItem,startDate,endDate);
            pageIndex=pageIndex==null?1L:pageIndex;
            pageSize=pageSize==null?20:pageSize;
            PageDo<SysUserDo> result= sysUserService.queryUserByRoleIdListPage(roleId, pageIndex, pageSize, selectItem);
            view.addObject("pagedata",result);
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("查询用户数据分页异常", e);
        }
        return view;
    }

    @RequestMapping(value="/modifyUserLock",method=RequestMethod.POST)
    public JsonView<String> modifyUserLock(HttpServletRequest request, String roleListStr, Integer userId, Boolean isLock)
    {
        JsonView<String> view=new JsonView<String>();
        SysActionLogDo actionLogDo=getUserActionLog(request,ActionLogConst.model_system_sysuser,"修改用户锁定状态",SysActionLogDo.LEVEL_IMPORTANT);
        try{
            checkPermission(PermissionCode.system_user_lock);
            AssertUtils.notNull(userId, "请先选择用户");
            AssertUtils.notNull(isLock, "请选择锁定状态");
            SysUserDo user=sysUserService.findSysUserById(userId);
            AssertUtils.notNull(user,"无效请求参数");
            actionLogDo.setContent("修改账号:"+user.getUserName() + "的锁状态为："+(isLock==true?"锁定":"解锁"));
            Integer dbResult=sysUserService.updateUserLockStatus(userId, isLock);
            AssertUtils.isTrue(dbResult!=null && dbResult.intValue()>0,"保存用户锁定状态失败");
            view.setCode(view.CODE_SUCCESS);
            view.setMsg("操作成功");
        }catch (BusinessException e) {
            setPromptException(view, e);
            actionLogDo.setContent("修改账号锁状态失败："+e.getMessage());
        }catch (Exception ex) {
            setPromptException(view, ex);
            logger.error("修改用户锁定状态异常",ex);
            actionLogDo.setContent("修改账号锁状态失败："+ex.getMessage());
        }finally {
            sysActionLogService.insertSysActionLog(actionLogDo);
        }
        return view;
    }

    @RequestMapping(value="/deleteUser",method=RequestMethod.POST)
    public JsonView<String> deleteUser(HttpServletRequest request, String roleListStr,Integer userId)
    {
        JsonView<String> view=new JsonView<String>();
        SysActionLogDo actionLogDo=getUserActionLog(request,ActionLogConst.model_system_sysuser,"注销账号",SysActionLogDo.LEVEL_IMPORTANT);
        try{
            checkPermission(PermissionCode.system_user_delete);
            AssertUtils.notNull(userId, "请先选择用户");

            SysUserDo user=sysUserService.findSysUserById(userId);
            AssertUtils.notNull(user,"无效参数");
            actionLogDo.setContent("注销账号:"+user.getUserName()+"("+user.getRealName()+")");

            Integer dbResult=sysUserService.deleteSysUserById(userId);
            AssertUtils.isTrue(dbResult!=null && dbResult.intValue()>0,"注销用户失败");
            view.setCode(view.CODE_SUCCESS);
            view.setMsg("操作成功");
        }catch (BusinessException e) {
            setPromptException(view, e);
            actionLogDo.setContent("注销账号失败："+e.getMessage());
        }catch (Exception e) {
            setPromptException(view, e);
            logger.error("注销用户失败异常",e);
            actionLogDo.setContent("注销账号失败："+e.getMessage());
        }finally {
            sysActionLogService.insertSysActionLog(actionLogDo);
        }
        return view;
    }

    /**
     *
     * releaseLoan:(这里用一句话描述这个方法的作用). <br>
     *
     * @author anxymf
     * Date:2017年4月26日下午3:32:10 <br>
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping(value = "/resetPassword")
    public JsonView<String> resetPassword(HttpServletRequest request, Integer userId,@RequestParam(defaultValue="")String password){
        JsonView<String> view = new JsonView<String>();

        SysActionLogDo actionLogDo=getUserActionLog(request, ActionLogConst.model_system_sysuser,"重置密码",SysActionLogDo.LEVEL_IMPORTANT);
        try {
            checkPermission(PermissionCode.system_user_password_reset);
            if(StringUtils.isBlank(password)){
                password = paramService.queryValueByCode("DEFAULT_PASSWORD");
                password = StringUtils.isNotBlank(password)?password:"Aa123456";
            }
            SysUserDo user=sysUserService.findSysUserById(userId);
            AssertUtils.notNull(user,"无效请求参数");
            actionLogDo.setContent("重置账号："+user.getUserName()+"("+user.getRealName()+")的密码");
            String newPsw=DigestUtils.md5Hex(password.trim()+ LoginController.PASS_KEY);
            if(sysUserService.resetPassword(userId, newPsw,null) == 1){//管理员重置密码不需要修改用户的modifyPwdTime
                view.setCode(JsonView.CODE_SUCCESS);
                view.setMsg("重置密码成功");
            }else{
                view.setCode(JsonView.CODE_SUCCESS);
                view.setMsg("重置密码失败");
            }
        } catch (BusinessException e) {
            setPromptException(view, e);
            actionLogDo.setContent("重置密码失败："+e.getMessage());
        } catch (Exception e) {
            logger.error("重置密码提交异常", e);
            setPromptMessage(view, JsonView.CODE_FAILE, "重置密码提交异常");
            actionLogDo.setContent("重置密码失败："+e.getMessage());
        }finally {
            sysActionLogService.insertSysActionLog(actionLogDo);
        }
        return view;
    }


    /**
     * 当前平台ID
     * @return
     */
    protected int currentPlatformId()
    {
        SysUserDo sysUser=currentUser();
        if(sysUser==null || sysUser.getPlatformId()==null)
        {
            return SystemConst.PLATFORM_DEFAULT;
        }else {
            return sysUser.getPlatformId().intValue();
        }
    }

    /**
     * 获取活动日志
     * @param request
     * @param model
     * @param detail
     * @param level
     * @return
     */
    protected SysActionLogDo getUserActionLog(HttpServletRequest request,String model,String detail,String level)
    {
        SysActionLogDo actionLogDo=new SysActionLogDo();
        actionLogDo.setMode(model);
        actionLogDo.setContent(JSON.toJSONString(request.getParameterMap()));
        actionLogDo.setActionUrl(request.getRequestURI());
        actionLogDo.setUserId(currentUser().getId());
        actionLogDo.setDetail(detail);
        actionLogDo.setLevel(level);
        return actionLogDo;
    }
}
