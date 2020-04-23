package com.issc.helper;

import com.issc.annotation.Aspect;
import com.issc.annotation.Service;
import com.issc.annotation.Transaction;
import com.issc.proxy.AbstractAspectProxy;
import com.issc.proxy.Proxy;
import com.issc.proxy.ProxyManager;
import com.issc.proxy.TransactionProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * aop助手类
 */
public final class AOPHelper {
    private static final Logger LOGGER= LoggerFactory.getLogger(AOPHelper.class);
    static {
        try {
            //代理类与目标类集合的映射关系
            Map<Class<?>,Set<Class<?>>> proxyMap=createProxyMap();
            //一个目标类对应多个代理类
            Map<Class<?>,List<Proxy>> targetMap=createTargetMap(proxyMap);
            //获取到目标类 和目标代理集合，通过proxyManager创建目标对象的代理
            for (Map.Entry<Class<?>, List<Proxy>> targetEntry :
                    targetMap.entrySet()) {
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList=targetEntry.getValue();
                //创建代理链，并执行代理链，动态创建创建proxy对象
                Object proxy= ProxyManager.createProxy(targetClass,proxyList);
                //将目标类对象替换成代理类对象
                BeanHelper.setBean(targetClass,proxy);
            }
        }catch (Exception e){
            LOGGER.error("AOP failure" ,e);
        }
    }
    private static Set<Class<?>> createTargetClassSet(Aspect aspect){
        //Aspect中写的目标类value值
        Set<Class<?>> targetClassSet=new HashSet<>();
        //获取到目标注解，会对带有目标注解的类进行增强
        Class<? extends Annotation> annotation=aspect.value();

        if (!annotation.equals(Aspect.class)){
            //通过目标注解，获取到所有的目标类，即需要增强的类
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    /**
     * 创建代理类映射关系
     * @return 代理类映射关系
     */
    private static Map<Class<?>,Set<Class<?>>> createProxyMap(){
        Map<Class<?>,Set<Class<?>>> proxyMap=new HashMap<>();
        addAspectProxy(proxyMap);
        addTransactionProxy(proxyMap);

        return proxyMap;
    }

    private static void addTransactionProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
        Set<Class<?>> serviceClassSet=ClassHelper.getClassSetByAnnotation(Service.class);
        proxyMap.put(TransactionProxy.class,serviceClassSet);
    }
    //添加切面代理类
    private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap)  {
        //通过父类AbstractAspectProxy.class获取到所有的proxy类集合
        Set<Class<?>> proxyClassSet=ClassHelper.getClassSetBySuper(AbstractAspectProxy.class);
        for (Class<?> proxyClass :
                proxyClassSet) {
            //如果代理类有Aspect注解就通过aspect获取到所有的目标类，将代理类和目标类集合存储到proxyMap集合中
            if (proxyClass.isAnnotationPresent(Aspect.class)){
                Aspect aspect=proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet=createTargetClassSet(aspect);
                proxyMap.put(proxyClass,targetClassSet);
            }
        }
    }

    private static Map<Class<?>,List<Proxy>> createTargetMap(Map<Class<?>,Set<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>,List<Proxy>> targetMap=new HashMap<>();
        //遍历proxyMap集合
        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry :
                proxyMap.entrySet()) {
            Class<?> proxyClass=proxyEntry.getKey();
            Set<Class<?>> targetClassSet=proxyEntry.getValue();
            //对proxyMap集合进行反转，让映射关系更合理，一个目标类对应多个代理类
            for (Class<?> targetClass:targetClassSet){
                Proxy proxy=(Proxy)proxyClass.newInstance();
                if (targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else {
                    List<Proxy> proxyList=new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass,proxyList);
                }
            }
        }
        return targetMap;
    }
}
