package cn.booktable.modules.annotation;

/**
 * @author ljc
 */
public enum ActionLogLevel {
    GENERAL("一般"),
    DANGER("危险"),
    IMPORTANT("重要");

    private String text;

    ActionLogLevel(String text)
    {
        this.text=text;
    }
     public String getText()
     {
         return this.text;
     }
}
