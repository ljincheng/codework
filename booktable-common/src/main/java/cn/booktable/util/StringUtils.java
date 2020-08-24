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


    /**
     * 转化为javascript的String值格式。
     * 注：处理单、双引号，及换行串等
     * @param value
     * @return
     */
    public static String toJsValue(String value) {
        StringBuilder out = new StringBuilder();
        if (value == null) {
            return "";
        }
        for (int i = 0, length = value.length(); i < length; i++) {
            char c = value.charAt(i);
            switch (c) {
                case '"':
                case '\\':
                case '/':
                    out.append('\\').append(c);
                    break;

                case '\t':
                    out.append("\\t");
                    break;

                case '\b':
                    out.append("\\b");
                    break;

                case '\n':
                    out.append("\\n");
                    break;

                case '\r':
                    out.append("\\r");
                    break;

                case '\f':
                    out.append("\\f");
                    break;

                default:
                    if (c <= 0x1F) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
                    break;
            }

        }
        return out.toString();
    }



}
