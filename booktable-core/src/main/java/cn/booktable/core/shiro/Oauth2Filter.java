package cn.booktable.core.shiro;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import cn.booktable.util.StringUtils;
import org.springframework.http.HttpHeaders;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljc
 */
public class Oauth2Filter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token=getRequestToken(request);
        if(StringUtils.isBlank(token))
        {
            return null;
        }
        return new Oauth2Token(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String token=getRequestToken(request);
        if(StringUtils.isBlank(token))
        {
//            HttpServletResponse httpResponse=(HttpServletResponse)response;
//            httpResponse.setContentType("application/json;charset=utf-8");
//            httpResponse.setHeader("Access-Control-Allow-Credentials","true");
//            httpResponse.setHeader("Access-Control-Allow-Origin", HttpHeaders.ORIGIN);
//            JSONObject json=new JSONObject();
//            json.put("code","INVALID");
//            json.put("msg","请先登录");
//            httpResponse.getWriter().println(json.toJSONString());
            responseAuthError(request,response,null);
            return false;
        }
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//        HttpServletResponse httpResponse=(HttpServletResponse)response;
//        httpResponse.setContentType("application/json;charset=utf-8");
//        httpResponse.setHeader("Access-Control-Allow-Credentials","true");
//        httpResponse.setHeader("Access-Control-Allow-Origin", HttpHeaders.ORIGIN);
//        try{
//            Throwable throwable=e.getCause()==null?e:e.getCause();
//            JSONObject json=new JSONObject();
//            json.put("code","INVALID");
//            json.put("msg",throwable.getMessage());
//            httpResponse.getWriter().println(json.toJSONString());
//        }catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
        responseAuthError(request,response,e);
        return false;
    }

    private String getRequestToken(ServletRequest request)
    {
        String token=((HttpServletRequest)request).getHeader("token");
        return token;
    }

    /**
     * 将非法请求跳转到 /401
     */
    private void responseAuthError(ServletRequest req, ServletResponse resp, AuthenticationException e) {
        try {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
//            httpServletResponse.sendRedirect("/401");
//
          HttpServletResponse httpResponse=(HttpServletResponse)resp;
            httpResponse.setContentType("application/json;charset=utf-8");
            httpResponse.setHeader("Access-Control-Allow-Credentials","true");
            httpResponse.setHeader("Access-Control-Allow-Origin", HttpHeaders.ORIGIN);
            JSONObject json=new JSONObject();
            json.put("code","INVALID");
            try{
                Throwable throwable=e.getCause()==null?e:e.getCause();
                json.put("msg",throwable.getMessage());
            }catch (Exception ioe)
            {
                ioe.printStackTrace();
            }
            httpResponse.getWriter().println(json.toJSONString());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
    }
}
