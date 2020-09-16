package cn.booktable.core.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.booktable.util.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.JSONObject;

/**
 * JSON输出
 * @author ljc
 * @version 1.0
 * @param <T>
 * 数据类型
 */
public class JsonView<T> extends AbstractView{

    @Override
    protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws Exception {
        arg2.setContentType("text/json; charset=UTF-8");
        PrintWriter out = arg2.getWriter();
        out.print(this.toJsonString());
    }

    private Integer code;
    private Integer errorCode;//错误码
    private String msg;
    private T data;
    public static final Integer CODE_SUCCESS=1;
    public static final Integer CODE_FAILE=0;

    public JsonView()
    {
        super();
    }

    /**
     * JSON格式对象
     * @param code
     * 结果编号
     * @param msg
     * 结果信息
     */
    public JsonView(Integer code,String msg)
    {
        super();
        this.setCode(code);
        this.setMsg(msg);
    }


    /**
     * 结果编号
     * @param code
     */
    public void setCode(Integer code)
    {
        this.code=code;
    }

    /**
     * 结果编号
     * @return
     */
    public Integer getCode()
    {
        return this.code;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 结果信息
     * @param msg
     */
    public void setMsg(String msg)
    {
        this.msg=msg;
    }

    /**
     * 结果信息
     * @return
     */
    public String getMsg()
    {
        return this.msg;
    }

    /**
     * 返回值
     * @param data
     */
    public void setData(T data)
    {
        this.data=data;
    }

    /**
     * 返回值
     * @return
     */
    public T getData()
    {
        return this.data;
    }

    public static JsonView error(String msg)
    {
        JsonView jsonView=new JsonView();
        jsonView.setCode(CODE_FAILE);
        jsonView.setMsg(msg);
        return jsonView;
    }

    public static JsonView error(Integer errorCode,String msg)
    {
        JsonView jsonView=new JsonView();
        jsonView.setCode(CODE_FAILE);
        jsonView.setErrorCode(errorCode);
        jsonView.setMsg(msg);
        return jsonView;
    }

    public static <T> JsonView<T> ok(T data)
    {
        JsonView jsonView=new JsonView();
        jsonView.setCode(CODE_SUCCESS);
        jsonView.setMsg("success");
        jsonView.setData(data);
        return jsonView;
    }

    public static <T> JsonView<T> ok(String msg,T data)
    {
        JsonView jsonView=new JsonView();
        jsonView.setCode(CODE_SUCCESS);
        jsonView.setMsg(msg);
        jsonView.setData(data);
        return jsonView;
    }

    /**
     * 返回JSON格式字符串
     * 格式如下：
     * {"code":1,"msg":"消息","data":返回值}
     * @return
     */
    public String toJsonString()
    {
        StringBuilder result=new StringBuilder("{\"code\":");
        if(this.code==null)
        {
            result.append(CODE_FAILE);
        }else{
            result.append(this.code);
        }
        result.append(",\"msg\":\"");
        if(StringUtils.isNotEmpty(this.msg))
        {
            result.append(StringUtils.toJsValue(this.msg));
        }
        result.append("\"");
        if(this.data!=null)
        {
            result.append(",\"data\":");
            if(this.data instanceof String)
            {
                result.append("\"").append(StringUtils.toJsValue(String.valueOf(this.data))).append("\"");
            }else{
                result.append(JSONObject.toJSON(this.data));
            }
        }
        result.append("}");
        return result.toString();
    }

}
