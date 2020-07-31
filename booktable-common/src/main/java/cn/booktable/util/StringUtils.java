package cn.booktable.util;

import java.util.UUID;

/**
 * @author ljc
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    public static boolean isBlank(String str)
    {
        return (str==null || str.length()==0) ? true:false;
    }

    public static String getUUID32(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        s = s.replace("-", "");
        return s;
    }
}
