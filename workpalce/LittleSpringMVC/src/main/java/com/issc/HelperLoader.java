package com.issc;

import com.issc.helper.*;
import com.issc.util.ClassUtil;

/**
 * 加载相应的Helper类
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] classList={ ClassHelper.class,BeanHelper.class, AOPHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> clazz :
                classList) {
            ClassUtil.loadClass(clazz.getName(),true);
        }
    }
}
