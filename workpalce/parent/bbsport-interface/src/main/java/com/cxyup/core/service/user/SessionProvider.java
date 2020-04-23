package com.cxyup.core.service.user;

public interface SessionProvider {
    //先行提供接口
    //保存用户名到Reds中
    void setAttribuerForUsername(String name, String value);
    //取用户名
    String getAttributeForUsername(String name);
    //验证码
    //退出登录
}
