package com.issc.demo.service;

import com.issc.annotation.Aspect;
import com.issc.annotation.Controller;
import com.issc.proxy.AbstractAspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect(Controller.class)
public class CustomerProxyTest extends AbstractAspectProxy {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerProxyTest.class);
    @Override
    protected void after(Class<?> cls, Method method, Object[] params, Object result) {
        System.out.println("after "+System.currentTimeMillis());
        LOGGER.debug("after");
    }

    @Override
    protected void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("before "+System.currentTimeMillis());
        LOGGER.debug("before");
    }
    @Override
    protected void begin() {
        System.out.println("begin "+System.currentTimeMillis());
        LOGGER.debug("begin");
    }
}
