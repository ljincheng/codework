package cn.booktable.modules.annotation;

import java.lang.annotation.*;

/**
 * @author ljc
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActionLog {

    String mode();
    String content() default "";
    ActionLogLevel level();
    String detail();

}
