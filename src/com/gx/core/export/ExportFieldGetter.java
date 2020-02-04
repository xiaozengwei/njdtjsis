package com.gx.core.export;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出字段的指定getter方法：用于一些状态字段的显示（formatter）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportFieldGetter {
    /**
     * 指定的get方法名称
     *
     * @return
     */
    String getterName() default "";
}
