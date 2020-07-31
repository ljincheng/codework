package cn.booktable.core.shiro;

import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import cn.booktable.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie认证
 * @author ljc
 */
public class Oauth2Cookie extends SimpleCookie {



    public Oauth2Cookie(){super();}
    public Oauth2Cookie(String name)
    {
        super(name);
    }
    public Oauth2Cookie(Cookie cookie)
    {
        super(cookie);
    }
    @Override
    public String readValue(HttpServletRequest request, HttpServletResponse ignored) {
            String tokenKey=getName();
            String value = request.getHeader(tokenKey);
            if (StringUtils.isBlank(value)) {
                return super.readValue(request, ignored);
            }
            return value;

    }



}
