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

    private boolean readFromHeader=false;

    public Oauth2Cookie(){super();}
    public Oauth2Cookie(String name)
    {
        super(name);
    }
    public Oauth2Cookie(String name,boolean fromHeader)
    {
        super(name);
        this.readFromHeader=fromHeader;
    }
    public Oauth2Cookie(Cookie cookie)
    {
        super(cookie);
    }
    @Override
    public String readValue(HttpServletRequest request, HttpServletResponse ignored) {
        String tokenKey=getName();
        if(readFromHeader) {
            String value = request.getHeader(tokenKey);
            if (StringUtils.isBlank(value)) {
                return null;
            }
            return value;
        }else {
            return super.readValue(request, ignored);
        }
    }

    public boolean isReadFromHeader() {
        return readFromHeader;
    }

    public void setReadFromHeader(boolean readFromHeader) {
        this.readFromHeader = readFromHeader;
    }
}
