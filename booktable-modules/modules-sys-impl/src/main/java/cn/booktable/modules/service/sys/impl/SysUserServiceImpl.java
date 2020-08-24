package cn.booktable.modules.service.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.booktable.toolkit.IdWorker;
import cn.booktable.util.StringUtils;
import cn.booktable.modules.entity.sys.SysUserRoleDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.SysPermissionComponent;
import cn.booktable.modules.component.sys.SysRoleComponent;
import cn.booktable.modules.component.sys.SysUserComponent;
import cn.booktable.modules.component.sys.SysUserRoleComponent;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysRoleDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.service.sys.SysRoleService;
import cn.booktable.modules.service.sys.SysUserService;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.AssertUtils;

/**
 * 系统用户.
 * @author ljc
 * @version  v1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl  implements SysUserService{

    @Autowired
    private SysUserComponent sysUserComponent;
    @Autowired
    private SysPermissionComponent sysPermissionComponent;
    @Autowired
    private SysRoleComponent sysRoleComponent;
    @Autowired
    private SysUserRoleComponent sysUserRoleComponent;


    /**
     * 添加系统用户.
     * @param sysUser
     * @return
     */
    public int insertSysUser(SysUserDo sysUser)
    {
        return sysUserComponent.insertSysUser(sysUser);
    }

    @Override
    public int registerSysUser(SysUserDo sysUser,String[] roleIds)
    {
        int dbRes=insertSysUser(sysUser);
        if(dbRes>0)
        {
            SysUserDo dbUser=findSysUserByUserName(sysUser.getUserName());
            dbRes=modifyUserRoles(roleIds, dbUser.getId());
            AssertUtils.isTrue(dbRes>0,"添加角色失败");
        }
        return dbRes;
    }

    /**
     * 获取系统用户数据列表.
     * @param selectItem
     * @return
     */
    public List<SysUserDo> querySysUserList(Map<String,Object> selectItem)
    {
        return sysUserComponent.querySysUserList(selectItem);
    }

    /**
     * 获取系统用户数据集
     * @param pageIndex
     * 起始页
     * @param pageSize
     * 每页记录数
     * @param selectItem
     * 过滤条件
     * @return
     */
    public PageDo<SysUserDo> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
    {
        return sysUserComponent.querySysUserListPage(pageIndex,pageSize,selectItem);
    }

    /**
     * 根据Id修改系统用户.
     * @param sysUser
     * @return
     */
    public int updateSysUserById(SysUserDo sysUser)
    {
        return sysUserComponent.updateSysUserById(sysUser);
    }

    @Override
    public Integer updateUserLockStatus(Integer id,Boolean isLock)
    {
        return sysUserComponent.updateLockStatus(id, isLock);
    }


    /**
     * 根据Id删除系统用户.
     * @param id
     * @return
     */
    public int deleteSysUserById(Integer id)
    {
        return sysUserComponent.deleteSysUserById(id);
    }

    /**
     * 根据Id获取系统用户.
     * @param id
     * @return
     */
    public SysUserDo findSysUserById(Integer id)
    {
        return sysUserComponent.findSysUserById(id);
    }

    @Override
    public SysUserDo findSysUserByUserName(String userName) {
        return sysUserComponent.findSysUserByUserName(userName);
    }

    @Override
    public List<SysPermissionDo> getMenuListByUserId(Integer userId) {

        return sysPermissionComponent.getMenuListByUserId(userId);
    }

    @Override
    public List<SysPermissionDo> getPermissionCodeListByUserId(Integer userId) {
        return sysPermissionComponent.getCodeListByUserId(userId);
    }

    @Override
    public List<String> getPermissionCodeStrListByUserId(Integer userId) {
        return sysPermissionComponent.getCodeStrListByUserId(userId);
    }

    @Override
    public List<String> getRoleStrListByUserId(Integer userid) {
        return sysRoleComponent.getRoleStrListByUserId(userid);
    }

    @Override
    public int resetPassword(Integer userId, String password, Date modifyPwdTime) {
        SysUserDo user=new SysUserDo();
        user.setId(userId);
        user.setPassword(password);
        user.setModifyPwdTime(modifyPwdTime);
        return sysUserComponent.resetPassword(user);
    }

    @Override
    public int modifyUserRoles(String[] roles, Integer userId) {
        return sysUserComponent.modifyUserRoles(roles, userId);
    }

    @Override
    public PageDo<SysUserDo> queryUserByRoleIdListPage(String roleId, Long pageIndex, Integer pageSize,
                                                       Map<String, Object> selectItem) {
        return sysUserRoleComponent.queryByRoleIdListPage(roleId, pageIndex, pageSize, selectItem);
    }

    @Override
    public PageDo<SysUserDo> queryUserNoInRoleIdListPage(String[] roleIdList, Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {
        return sysUserRoleComponent.queryUserNoInRoleIdListPage(roleIdList,pageIndex,pageSize,selectItem);
    }

    @Override
    public Integer addUserRoleId(Integer userId, String roleId) {
        Map<String,Object> selectItem=new HashMap<String, Object>();
        selectItem.put("roleId",roleId);
        selectItem.put("userId",userId);
        List<SysUserRoleDo> userRoleList= sysUserRoleComponent.querySysUserRoleList(selectItem);
        if(userRoleList!=null && userRoleList.size()>0) {
            return userRoleList.size();
        }
        SysRoleDo sysRoleDo= sysRoleComponent.findSysRoleById(roleId);
        AssertUtils.notNull(sysRoleDo,"角色不存在");

        AssertUtils.isTrue(sysRoleDo != null, "角色不存在");
        SysUserRoleDo userRole = new SysUserRoleDo();
        userRole.setId(IdWorker.getIdStr());
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return sysUserRoleComponent.insertSysUserRole(userRole);
    }




    @Override
    public Integer updateLoginExcessiveAttemptsByUserId(SysUserDo sysUser) {
        return sysUserComponent.updateLoginExcessiveAttemptsByUserId(sysUser);
    }

    public Integer updateUserPhoto(SysUserDo sysUser){
        return sysUserComponent.updateUserPhoto(sysUser);
    }

    @Override
    public Integer updateUserWallPhoto(SysUserDo sysUserDo) {
        return sysUserComponent.updateUserWallPhoto(sysUserDo);
    }

    @Override
    public Integer recoverUserStatusById(Integer userId) {
        return sysUserComponent.recoverUserStatusById(userId);
    }
}
