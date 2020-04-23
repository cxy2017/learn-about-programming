package com.issc.annotation;


import com.issc.bean.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    /**
     * 请求的类名与路径
     */
    String value()default "";

    /**
     * The HTTP request methods to map to, narrowing the primary mapping:
     * GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE.
     *
     */

    RequestMethod[] requestMethod() default {};

}
