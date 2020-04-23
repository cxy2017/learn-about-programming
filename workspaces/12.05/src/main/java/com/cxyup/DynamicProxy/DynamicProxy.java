package com.cxyup.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现InvocationHandler接口
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("处理之后");
    }

    private void before() {
        System.out.println("处理之前");
    }

    //封装Proxy.newProxyInstance()方法，简化代码
    @SuppressWarnings("unchecked")
    public <T> T getProxyInstance() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
