package cn.booktable.service.webadmin.controller.base;

import cn.booktable.core.constant.SystemConst;
import cn.booktable.modules.entity.sys.SysUserDo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public class BaseController {

    /**
     * 判断是否是系统超级用户。
     * @return
     */
    protected Boolean isSuperSysUser()
    {
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null)
        {
            return  subject.hasRole(SystemConst.SYSTEM_SUPERROLE);
        }
        return false;
    }

    protected SysUserDo currentUser()
    {
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null && subject.getPrincipal()!=null )
        {
            return (SysUserDo) subject.getPrincipal();
        }
        return null;

    }
}
