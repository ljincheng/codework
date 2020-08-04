package cn.booktable.core.constant;

public class SystemConst {

    /** 默认后台 **/
    public static final int PLATFORM_DEFAULT=1;
    public static final String SYSTEM_SUPERROLE="系统超级管理员";

    /**
     * 密码设置规则：不少于8位，必须包括大写、小写和数字
     */
    public static final String REGEX_PWD= "^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])).{8,}$";
    /** 密码设置规则：位数不少于6位 **/
    public static final String REGEX_PWD2= "^\\S{6,}$";

    /**
     * 电话号码
     */
    public static final String REGEX_TELEPHONE = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
}
