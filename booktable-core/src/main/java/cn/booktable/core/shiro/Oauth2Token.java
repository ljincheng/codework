package cn.booktable.core.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ljc
 */
public class Oauth2Token implements AuthenticationToken {

    private String token;

    public Oauth2Token(String token)
    {
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken()
    {
        return token;
    }
}
