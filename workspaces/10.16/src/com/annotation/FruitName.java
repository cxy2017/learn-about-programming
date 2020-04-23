package com.annotation;


import java.lang.annotation.*;

/**
 * ˮ������ע��
 *
 * @author cxy
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}