package com.issc.proxy;

/**
 * 代理类接口
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
