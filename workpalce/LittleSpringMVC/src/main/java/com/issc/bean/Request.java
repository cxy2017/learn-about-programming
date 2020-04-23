package com.issc.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 封装请求信息
 */
public class Request {
    /**
     * 请求方法
     */
    private RequestMethod requestMethod;
    /**
     * 请求路径
     */
    private String requestPath;
    public  Request(RequestMethod requestMethod,String requestPath){
        this.requestMethod=requestMethod;
        this.requestPath=requestPath;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public  int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj);
    }
}
