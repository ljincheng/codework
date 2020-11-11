package cn.booktable.modules.elasticsearch.core;

/**
 * @author ljc
 */
public class ElasticsearchException extends RuntimeException{

    private Integer code=null;




    public ElasticsearchException(){
        super();
    }

    /**
     * 异常信息
     * @param msg
     */
    public ElasticsearchException(String msg)
    {
        super(msg);
    }

    public ElasticsearchException(Integer code ,String msg)
    {
        super(msg);
        this.setCode(code);
    }

    public ElasticsearchException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ElasticsearchException(Throwable cause) {
        super(cause);
    }

    /**
     * 错误编号
     * @param code
     */
    public void setCode(Integer code)
    {
        this.code=code;
    }

    /**
     * 错误编号
     * @return
     */
    public Integer getCode()
    {
        return this.code;
    }
}
