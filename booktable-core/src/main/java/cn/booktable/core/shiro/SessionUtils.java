package cn.booktable.core.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Session工具类
 * @author ljc
 */

public class SessionUtils {

    private static Logger log=LoggerFactory.getLogger(SessionUtils.class);

    /**
     * 根据userName查找用户是否已登录
     * @param sysUser
     * @return
     */
    public static <T extends SysUserPrimaryPrincipal> Session getSessionByUserName(T sysUser){

        try {
            DefaultWebSessionManager sessionManager= getSessionManager();
            Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
            for(Session session:sessions){
                if(session!=null) {
                    PrincipalCollection principalCollection = (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);

                    if (null != principalCollection) {

                        T sysUserDo = (T) principalCollection.getPrimaryPrincipal();
                        if (null != sysUserDo && sysUser.getUserName().equals(sysUserDo.getUserName())) {
                            return session;
                        }
                    }
                }
            }

        } catch (Exception e) {
            log.error("获取用户信息报错！",e);
        }

        return null;

    }

    /**
     * 根据userName查找所有已登录用户
     * @param sysUser
     * @return
     */
    public static  <T extends SysUserPrimaryPrincipal> List<Session> getSessionListByUserName(T sysUser){
        List<Session> list = new ArrayList<Session>();
        try {
            DefaultWebSessionManager sessionManager= getSessionManager();
            Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
            for(Session session:sessions){
                if(session!=null) {
                    PrincipalCollection principalCollection = (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                    if (null != principalCollection) {

                        T sysUserDo = (T) principalCollection.getPrimaryPrincipal();
                        if (null != sysUserDo && sysUser.getUserName().equals(sysUserDo.getUserName())) {
                            list.add(session);
                        }
                    }
                }
            }

        } catch (Exception e) {
            log.error("获取用户信息报错！",e);
        }

        return list;

    }

    /**
     * 获取SessionManager
     * @return
     */
    public static DefaultWebSessionManager getSessionManager(){

        try {
            DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
            DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
            return sessionManager;
        } catch (Exception e) {
            log.error("获取sessionManager报错！",e);
        }

        return null;

    }
}

