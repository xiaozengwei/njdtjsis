package com.gx.core.export;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportBean {
    /**
     * 字段名称
     *
     * @return
     */
    String[] columnName() default {};

    /**
     * 字段宽度（用于导出字段列名显示）
     *
     * @return
     */
    int[] columnWidth() default {};

    /**
     * 字段备注（用于导出字段列名显示）
     *
     * @return
     */
    String[] columnComment() default {};
}
