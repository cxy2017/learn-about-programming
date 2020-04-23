package com.issc.proxy;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;
public class ProxyChain {

    private final Class<?> targeyClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private  List<Proxy> proxyList;
    private int proxyIndex=0;
    public ProxyChain(Class<?> targeyClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targeyClass = targeyClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Class<?> getTargeyClass() {
        return targeyClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }
    public Object doProxyChain()throws Throwable{
        Object methodResult;
        if (proxyIndex<proxyList.size()){
            methodResult=proxyList.get(proxyIndex++).doProxy(this);
        }else {
            methodResult=methodProxy.invokeSuper(targetObject,methodParams);
        }
        return methodResult;
    }
}
