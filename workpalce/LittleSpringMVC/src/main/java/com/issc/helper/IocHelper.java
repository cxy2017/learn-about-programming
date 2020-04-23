package com.issc.helper;

import com.issc.annotation.Autowired;
import com.issc.util.ReflectionUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 */
public class IocHelper {

    static{
        Map<Class<?>,Object> beanMap=BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                //从beanMap中获取bean类和bean实例
                Class<?> beanClass=beanEntry.getKey();
                Object beanInstance=beanEntry.getValue();
                //获取bean类定义的所有成员变量
                Field[] fields=beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(fields)){
                    //遍历Bean Field
                    for(Field beanField:fields){
                        //判断当前bean field是否带有Autowired注解
                        if (beanField.isAnnotationPresent(Autowired.class)){
                            Class<?> beanFieldClass=beanField.getType();
                            Object beanFieldInstance=beanMap.get(beanFieldClass);
                            if (beanFieldInstance!=null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
