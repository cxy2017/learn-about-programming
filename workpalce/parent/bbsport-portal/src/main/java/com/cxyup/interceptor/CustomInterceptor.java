package com.cxyup.interceptor;

import com.cxyup.common.utils.RequestUtils;
import com.cxyup.core.service.user.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截的是Controller层之前 Springmvc handler处理器
 */
public class CustomInterceptor implements HandlerInterceptor{
    @Autowired
    private SessionProvider sessionProvider;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //必须登录
        String username = sessionProvider.getAttributeForUsername(RequestUtils.getCSESSIONID(httpServletRequest, httpServletResponse));
        if (null==username){
            //未登录
            //重定向至登录界面
            httpServletResponse.sendRedirect("http://localhost:8081/login.aspx?returnUrl=http://localhost:8082/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
