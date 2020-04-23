package com.issc.helper;

import com.issc.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * bean助手类
 */
public class BeanHelper {
    /**
     * 定义bean映射（用于存放Bean类与Bean的实例的映射关系）
     */
    private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<>();
    static {
        Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
        for (Class<?> beanClass :
                beanClassSet) {
           Object beanInstance= ReflectionUtil.newInstance(beanClass);
           BEAN_MAP.put(beanClass,beanInstance);
        }
    }
    /**
     * 获取bean映射
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> T getBean(Class<T> clazz){
        if(!BEAN_MAP.containsKey(clazz)){
            throw new RuntimeException("can not get com.issc.demo.bean by class:"+clazz);
        }
        return (T) BEAN_MAP.get(clazz);
    }
    public static void setBean(Class<?> cls,Object obj){
        BEAN_MAP.put(cls,obj);
    }
}
