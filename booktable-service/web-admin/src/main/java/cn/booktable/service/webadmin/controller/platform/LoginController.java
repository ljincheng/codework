package cn.booktable.service.webadmin.controller.platform;

import cn.booktable.cryptojs.CryptoJSUtil;
import cn.booktable.util.StringUtils;
import cn.booktable.util.VerifyCodeUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ljc
 */
@Controller
@EnableAutoConfiguration
public class LoginController {
    private static Logger logger= LoggerFactory.getLogger(LoginController.class);

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

            String psw= DigestUtils.md5Hex(password+ "OWSd0&sd(fQl1%Uma8OL");
            UsernamePasswordToken token = new UsernamePasswordToken(username, psw);
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.isAuthenticated()) {
                model = new ModelAndView("redirect:hello");
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
                    model = new ModelAndView("redirect:hello");
                    return model;
                }
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return model;
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
