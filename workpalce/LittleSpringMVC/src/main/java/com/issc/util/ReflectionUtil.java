package com.issc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 */
public class ReflectionUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReflectionUtil.class);
    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> clazz){
        Object instance;
        try {
            instance=clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }
    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method,Object...args){
        Object result;
        try {
            //绕过权限校验
            method.setAccessible(true);
            result=method.invoke(obj,args);
        } catch (IllegalAccessException | InvocationTargetException e ) {
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }
    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field,Object value){
        try {
            field.setAccessible(true);
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
