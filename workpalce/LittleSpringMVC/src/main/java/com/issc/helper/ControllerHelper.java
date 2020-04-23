package com.issc.helper;

import com.issc.annotation.Controller;
import com.issc.annotation.RequestMapping;
import com.issc.bean.Handler;
import com.issc.bean.Request;
import com.issc.bean.RequestMethod;
import com.issc.util.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *控制器助手类
 */
public class ControllerHelper {
    //用于存放请求与处理器的映射关系（简称 RequestMapping Map）
    private static final Map<Request,Handler> REQUEST_MAPPING_MAP =
            new HashMap<>();
    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet=ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)){
            //用于保存类上的RequestMapping的URL
            String mappingType=null;
            for (Class<?> clazz :
                    controllerClassSet) {
                //  如果Controller类上有RequestMapping注解，将其中的Value保存下来
                if (clazz.isAnnotationPresent(RequestMapping.class)){
                    RequestMapping requestMappingType= clazz.getAnnotation(RequestMapping.class);
                    mappingType=requestMappingType.value();
                }
             Method[] methods= clazz.getDeclaredMethods();
             if (ArrayUtils.isNotEmpty(methods)){
                 //判断当前方法是否带有RequestMapping注解
                 for (Method method :
                         methods) {
                     if (method.isAnnotationPresent(RequestMapping.class)){
                         //从requestmapping注解或者能够获取URL映射规则
                         RequestMapping requestMappingMethod=method.getAnnotation(RequestMapping.class);
                         String mapping=requestMappingMethod.value();
                         //连接Class上的URL和Method上的URL
                         if (StringUtil.isNotEmpty(mappingType)){
                             mapping=mappingType+mapping;
                         }
                         //获取到RequestMapping注解中的所有RequestMethod值
                         RequestMethod[] requestMethods=requestMappingMethod.requestMethod();
//                         String strRequestMethod=requestMethod.toString();
                         for (RequestMethod requestMethod :requestMethods) {
                             //将RequestMapping注解中method参数获取并转为小写字符串

                             Request request=new Request(requestMethod,mapping);
                             Handler handler=new Handler(clazz,method);
                             REQUEST_MAPPING_MAP.put(request,handler);
                         }
                     }
                 }
             }
            }
        }
            /**
             * 获取Handler
             */
    }

    public static Handler getHandler(RequestMethod requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
        return REQUEST_MAPPING_MAP.get(request);
    }
}
