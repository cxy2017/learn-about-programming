package com.cxyup.DynamicProxy;

import com.cxyup.Hello;
import com.cxyup.HelloImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy);

        helloProxy.say();
        Hello helloProxy1 = (Hello) dynamicProxy.getProxyInstance();
        helloProxy1.say();
    }
}
