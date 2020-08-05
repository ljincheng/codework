package cn.booktable.service.webadmin.controller.platform;

import cn.booktable.core.constant.SystemConst;
import cn.booktable.cryptojs.CryptoJSUtil;
import cn.booktable.exception.BusinessException;
import cn.booktable.modules.entity.sys.AtlantisHtmlMenu;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SystemDo;
import cn.booktable.modules.service.sys.AtlantisHtmlMenuHandler;
import cn.booktable.modules.service.sys.MenuListHandler;
import cn.booktable.modules.service.sys.SysPermissionService;
import cn.booktable.modules.service.sys.SysUserService;
import cn.booktable.service.webadmin.config.AdminSysConfig;
import cn.booktable.service.webadmin.controller.base.BaseController;
import cn.booktable.util.AssertUtils;
import cn.booktable.util.StringUtils;
import cn.booktable.util.VerifyCodeUtils;
import com.sun.management.OperatingSystemMXBean;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author ljc
 */
@Controller
@EnableAutoConfiguration
public class LoginController extends BaseController {
    private static Logger logger= LoggerFactory.getLogger(LoginController.class);
    private static final String VIEWNAME_MAIN="platform/main";

    @Autowired
    private AdminSysConfig adminSysConfig;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysUserService sysUserService;

    private void osInfo(ModelAndView modelAndView)
    {
        modelAndView.addObject("osName", "测试系统");
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtils.generateTextCode(VerifyCodeUtils.TYPE_NUM_ONLY, 4, null);
        //将验证码放到HttpSession里面
//		request.getSession().setAttribute("verifyCode", verifyCode);
        SecurityUtils.getSubject().getSession().setAttribute("verifyCode", verifyCode);
        logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtils.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String sayit) {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("platform/login");
        osInfo(retVal);
        return retVal;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login_post(HttpServletRequest request, String username, String password) {
        ModelAndView model = new ModelAndView();
        model.setViewName("platform/login");
        try{
            osInfo(model);
            //获取用户请求表单中输入的验证码
            String submitCode = WebUtils.getCleanParam(request, "verifyCode");
            String verifyCode = (String)SecurityUtils.getSubject().getSession().getAttribute("verifyCode");
            logger.info("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
            if (StringUtils.isEmpty(submitCode) || StringUtils.isEmpty(verifyCode) || !verifyCode.equals(submitCode.toLowerCase())){
                request.setAttribute("message_login", "验证码不正确");
                return model;
            }
            try{

                if(StringUtils.isEmpty(verifyCode))
                {
                    request.setAttribute("message_login", "请输入验证码");
                    return model;
                }
                String key="___".concat(verifyCode).concat("___");
                username= CryptoJSUtil.decrypt(username,key);
                password= CryptoJSUtil.decrypt(password,key);
            }catch (Exception ex)
            {
                request.setAttribute("message_login", "账号或码不正确");
                return model;
            }

            String psw= DigestUtils.md5Hex(password+ adminSysConfig.getPasswordKey());
            UsernamePasswordToken token = new UsernamePasswordToken(username, psw);
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.isAuthenticated()) {
                model = new ModelAndView("redirect:"+VIEWNAME_MAIN);
                return model;
            }
            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                SavedRequest savedRequest= WebUtils.getSavedRequest(request);
                if(null!=savedRequest){
                    System.out.println("注意登录之前的路径是"+savedRequest.getRequestUrl());
                    String viewName= "redirect:" + savedRequest.getRequestUrl().substring(1);
                    return new ModelAndView(viewName);
                }else {
                    model = new ModelAndView("redirect:"+VIEWNAME_MAIN);
                    return model;
                }
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return model;
    }

    @RequestMapping("/platform/logout")
    public String logout(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "login";
    }

    @RequestMapping(value="/resetPassword.do", method=RequestMethod.GET)
    public ModelAndView resetPasswordPage()
    {
        ModelAndView model = new ModelAndView("platform/resetPassword");
        return model;
    }

    @RequestMapping(value="/resetPassword.do", method=RequestMethod.POST)
    public ModelAndView resetPassword(String oldPassword,String password,String password2)
    {
        ModelAndView model = new ModelAndView("platform/resetPassword");
        try{
            AssertUtils.isNotBlank(password, "新密码不能为空");
            AssertUtils.isNotBlank(oldPassword,"原密码不能为空");
            if(!password.equals(password2))
            {
                throw new BusinessException("密码不一致");
            }
            SysUserDo currentUser=currentUser();
            if(currentUser==null)
            {
                throw new BusinessException("请先登录");
            }
            currentUser=sysUserService.findSysUserById(currentUser.getId());
            if(currentUser!=null)
            {
                String psw=DigestUtils.md5Hex(oldPassword+ adminSysConfig.getPasswordKey());
                if(currentUser.getPassword().equals(psw))
                {
                    String newPsw=DigestUtils.md5Hex(password+adminSysConfig.getPasswordKey());
                    sysUserService.resetPassword(currentUser.getId(), newPsw, new Date());
                    setPromptMessage(model, "修改密码成功");
                }else{
                    throw new BusinessException("原密码不正确");
                }
            }else{
                throw new BusinessException("请先登录");
            }
        }catch (BusinessException e) {
            setPromptException(model, e);
        }catch (Exception ex) {
            logger.error("修改密码异常", ex);
            setPromptException(model, ex);
        }
        return model;
    }

    @GetMapping("platform/main")
    public ModelAndView platform_main(HttpServletRequest request,
                              HttpServletResponse response,Integer pid,String lang) {
        ModelAndView model = new ModelAndView("platform/main");

        try {


            platformMenuHtmlData(model,pid==null? SystemConst.PLATFORM_DEFAULT:pid);

           OperatingSystemMXBean osmx = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
         SystemDo dto = new SystemDo();
        dto.setSysTime(System.currentTimeMillis());
        dto.setOsName(System.getProperty("os.name"));
        dto.setOsArch(System.getProperty("os.arch"));
        dto.setOsVersion(System.getProperty("os.version"));
        dto.setUserLanguage(System.getProperty("user.language"));
        dto.setUserDir(System.getProperty("user.dir"));
        dto.setTotalPhysical(osmx.getTotalPhysicalMemorySize()/1024/1024);
        dto.setFreePhysical(osmx.getFreePhysicalMemorySize()/1024/1024);
        dto.setMemoryRate(BigDecimal.valueOf((1-osmx.getFreePhysicalMemorySize()*1.0/osmx.getTotalPhysicalMemorySize())*100).setScale(2, RoundingMode.HALF_UP));
        dto.setProcessors(osmx.getAvailableProcessors());
        dto.setJvmName(System.getProperty("java.vm.name"));
        dto.setJavaVersion(System.getProperty("java.version"));
        dto.setJavaHome(System.getProperty("java.home"));
        dto.setJavaTotalMemory(Runtime.getRuntime().totalMemory()/1024/1024);
        dto.setJavaFreeMemory(Runtime.getRuntime().freeMemory()/1024/1024);
        dto.setJavaMaxMemory(Runtime.getRuntime().maxMemory()/1024/1024);
        dto.setUserName(System.getProperty("user.name"));
        dto.setSystemCpuLoad(BigDecimal.valueOf(osmx.getSystemCpuLoad()*100).setScale(2, RoundingMode.HALF_UP));
        dto.setUserTimezone(System.getProperty("user.timezone"));

        model.addObject("sysInfo",dto);

            // 获取个人通知消息


        } catch (Exception e) {
          e.printStackTrace();
        }
        return model;
    }

    public String platformMenuHtmlData(ModelAndView model ,Integer platformId) {
        String result=null;
        String indexHref=null;
        try {
            StringBuilder sb = new StringBuilder();
            SysUserDo userDo=this.currentUser();
            model.addObject("user",userDo);
            List<AtlantisHtmlMenu> list = null;
            if (this.isSuperSysUser()) {
                MenuListHandler<AtlantisHtmlMenu> handler=new  AtlantisHtmlMenuHandler();
                list = sysPermissionService.findAllPlatformMenuList(handler,platformId);
            }else{
                Integer userId=userDo.getId();
                list =  sysPermissionService.findPlatformMenuList(new AtlantisHtmlMenuHandler(),  userId,platformId);
            }


            if (list != null) {
                logger.debug("获取总数据记录数有：" + list.size());
                for (AtlantisHtmlMenu item :list) {
                    if (item != null) {
                        sb.append(item.toHtml());

                        if(indexHref==null)
                        {
                            if(item.getChildren()!=null && item.getChildren().size()>0) {
                                List<AtlantisHtmlMenu> childs=item.getChildren();
                                for(AtlantisHtmlMenu menu:childs) {
                                    if(StringUtils.isNotBlank( menu.getHref())) {
                                        indexHref = menu.getHref();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            result = sb.toString();
            logger.debug("菜单数据：" + result);

        } catch (Exception e) {
            logger.error("获取html菜单数据异常", e);
        }
            model.addObject("menuHtml", result);
        if(StringUtils.isBlank(indexHref))
        {
            indexHref="about:blank";
        }
        model.addObject("firstMenuHref", indexHref);
        return result;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(String sayit) {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("platform/hello");
        retVal.addObject("mymessage", "21---");
        return retVal;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public ModelAndView hello2(String sayit) {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("platform/hello");
        retVal.addObject("mymessage", "hello2 WOW~~~");
        return retVal;
    }
}
