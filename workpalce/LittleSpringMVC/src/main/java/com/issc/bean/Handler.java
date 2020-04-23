package com.issc.bean;

import java.lang.reflect.Method;

/**
 * 封装RequestMapping信息
 */
public class Handler {
    private Class<?> controllerClass;
    /**
     * RequestMapping方法
     */
    private Method requestMappingMethod;

    public Handler(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Handler(Class<?> controllerClass, Method requestMappingMethod){
        this.controllerClass=controllerClass;
        this.requestMappingMethod=requestMappingMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getRequestMappingMethod() {
        return requestMappingMethod;
    }
}
