package cn.booktable.exception;

public class BusinessException  extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 2883426725735227407L;

    public static Integer code_argument=100;//参数异常
    public static Integer code_auth=200;//权限异常
    public static Integer code_other=0;//其他
    public static Integer code_assert=10;//断言异常
    private Integer code=null;




    public BusinessException(){
        super();
    }

    /**
     * 异常信息
     * @param s
     */
    public BusinessException(String msg)
    {
        super(msg);
    }

    public BusinessException(Integer code ,String msg)
    {
        super(msg);
        this.setCode(code);
    }

    public BusinessException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
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
