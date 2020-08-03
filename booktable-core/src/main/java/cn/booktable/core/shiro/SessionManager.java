package cn.booktable.core.shiro;

import cn.booktable.core.redis.RedisManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class SessionManager extends DefaultWebSessionManager {

    private String cookieName="token";

    public SessionManager(long timeout,String cookieName, RedisManager redisManager)
    {
        super();
        if(cookieName!=null) {
            this.cookieName = cookieName;
        }
        RedisSessionDAO sessionDAO=new RedisSessionDAO(redisManager);
        sessionDAO.setTimeout(timeout);

        setGlobalSessionTimeout(timeout);
        setSessionValidationInterval(timeout);
        setSessionDAO(sessionDAO);

        setSessionValidationSchedulerEnabled(true);
        setSessionIdUrlRewritingEnabled(false);
        Oauth2Cookie cookie=new Oauth2Cookie(cookieName);
        cookie.setHttpOnly(true);
        setSessionIdCookie(cookie);
    }




    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
        Cookie cookie= this.getSessionIdCookie();
        if(cookie!=null)
        {
            cookie.setName(cookieName);
        }
    }
}
