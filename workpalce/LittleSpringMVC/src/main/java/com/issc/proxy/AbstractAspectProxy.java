package com.issc.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class AbstractAspectProxy implements Proxy {
    private static final Logger logger= LoggerFactory.getLogger(AbstractAspectProxy.class);
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result=null;
        Class<?> cls=proxyChain.getTargeyClass();
        Method method=proxyChain.getTargetMethod();
        Object[] params=proxyChain.getMethodParams();
        try {
            begin();
            if (intercept(cls,method,params)){
                before(cls,method,params);
                result=proxyChain.doProxyChain();
                after(cls,method,params,result);
            }else {
                result=proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure",e);
            error(cls,method,params,e);
            throw e;
        }
        return result;
    }

    protected void error(Class<?> cls, Method method, Object[] params, Exception e) {

    }

    protected void after(Class<?> cls, Method method, Object[] params, Object result) {

    }

    protected void before(Class<?> cls, Method method, Object[] params) {

    }

    protected boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    protected void begin(){

    }
}
