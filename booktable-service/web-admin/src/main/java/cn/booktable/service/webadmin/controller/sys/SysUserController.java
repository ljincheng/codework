package cn.booktable.service.webadmin.controller.sys;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysUserEntity;
import cn.booktable.modules.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ljc
 */
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/sys/sysUserEntityList")
    public ModelAndView sysUserList_methodGet(Model model){
        ModelAndView view=new ModelAndView("sys/sysUserEntityList");
        try{
            List<SysUserEntity> userEntityList= sysUserService.querySysUserList(null);
            view.addObject("sysUserList",userEntityList);
            System.out.println("num="+userEntityList.size());
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return view;
    }

    @GetMapping("/sys/sysUserEntityListPage")
    public ModelAndView sysUserListPage_methodGet(){
        ModelAndView view=new ModelAndView("sys/sysUserEntityList");
        try{
            PageDo<SysUserEntity> userEntityListPage= sysUserService.querySysUserListPage(1L,20,null);
            List<SysUserEntity> userEntityList=userEntityListPage.getPage();
            view.addObject("sysUserList",userEntityList);
            System.out.println("num="+userEntityList.size());
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return view;
    }


}
