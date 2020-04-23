package com.cxyup.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {
    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        return instance;
    }

    /**
     * @param cls 需要代理的类对象
     * @param <T> 需要代理的类对象的类型
     * @return 动态代理类
     */
    public <T> T getProxyInstance(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();

        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("处理之后");
    }

    private void before() {
        System.out.println("处理之前");
    }
}
