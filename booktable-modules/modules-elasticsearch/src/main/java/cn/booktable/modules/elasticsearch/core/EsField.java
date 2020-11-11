package cn.booktable.modules.elasticsearch.core;

import java.lang.annotation.*;

/**
 * ES索引字段映射，用于代码创建索引
 * @author ljc
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  EsField {

    /**
     * 字段类型
     *
     * @return
     */
    String type() default "text";

    boolean index() default false;
}
