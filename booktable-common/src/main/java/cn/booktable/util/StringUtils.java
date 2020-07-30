package cn.booktable.util;

/**
 * @author ljc
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    public static boolean isBlank(String str)
    {
        return (str==null || str.length()==0) ? true:false;
    }
}
