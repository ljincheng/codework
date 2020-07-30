package cn.booktable.service.webadmin.controller.platform;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljc
 */
@Controller
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String sayit) {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("platform/login");
        retVal.addObject("mymessage", sayit);
        return retVal;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login_post(HttpServletRequest request, String username, String passwd) {
        ModelAndView model = new ModelAndView();
        model.setViewName("platform/login");
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
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
