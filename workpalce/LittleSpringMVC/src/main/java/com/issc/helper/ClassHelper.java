package com.issc.helper;

import com.issc.annotation.Autowired;
import com.issc.annotation.Controller;
import com.issc.annotation.RequestMapping;
import com.issc.annotation.Service;
import com.issc.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 */
public class ClassHelper {
    /**
     *
     */
    private static final Set<Class<?>> CLASS_SET;
    private static final Set<Class<?>> CONTROLLER_CLASS_SET=new HashSet<>();
    private static final Set<Class<?>> BEAN_CLASS_SET=new HashSet<>();
    private static final Set<Class<?>> SERVICE_CLASS_SET=new HashSet<>();
    static {
        String basePackage=ConfigHelper.getAppBasePackage();
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }
    static {
        for (Class clazz:
             CLASS_SET) {
            if (clazz.isAnnotationPresent(Controller.class)){
                CONTROLLER_CLASS_SET.add(clazz);
                BEAN_CLASS_SET.add(clazz);
            }else if (clazz.isAnnotationPresent(Service.class)){
                SERVICE_CLASS_SET.add(clazz);
                BEAN_CLASS_SET.add(clazz);
            }
        }
    }

    /**
     * 获取应用包名下的所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        return CONTROLLER_CLASS_SET;
    }
    /**
     * 获取应用包名下的所有bean类
     */
    public static Set<Class<?>> getBeanClassSet() {
        return BEAN_CLASS_SET;
    }
    /**
     * 获取应用包名下的所有Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        return SERVICE_CLASS_SET;
    }
    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取应用包名下面某父类(或接口)的所有子类（或实现类）
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
        Set<Class<?>> classSet=new HashSet<>();
        for (Class<?> cls :
                CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
    /**
     * 获取应用包名下所有带注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
        Set<Class<?>> classSet=new HashSet<>();
        for (Class<?> cls :
                CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
}

