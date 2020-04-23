package com.issc;

import com.issc.bean.*;
import com.issc.helper.*;
import com.issc.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig){
        //初始化相关Helper类
        HelperLoader.init();
        //获取ServletContext对象（用于注册servlet）
        ServletContext servletContext= servletConfig.getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet=servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet=servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
        UploadHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法与请求路径
        String requestMethod = req.getMethod().toUpperCase();
        String requestPath = req.getPathInfo();
        if("favicon.ico".equals(requestMethod)){
            return;
        }
        //将获取的method转换成RequestMethod枚举类型
        RequestMethod method=RequestMethod.valueOf(requestMethod);
        //获取RequestMapping处理器
        Handler handler = ControllerHelper.getHandler(method, requestPath);
        //将得到的method
        if (handler != null) {
            //获取Controller类及其Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            Param param;
            if (UploadHelper.isMultipart(req)){
                param=UploadHelper.createParam(req);

            }else {
                 param= RequestHelper.createParam(req);
            }

            //调用RequestMapping方法
            Method requestMappingMethod = handler.getRequestMappingMethod();

            Object result ;
            if (requestMappingMethod.getParameterCount()==0){
                result=ReflectionUtil.invokeMethod(controllerBean, requestMappingMethod);
            }else {
                result=ReflectionUtil.invokeMethod(controllerBean, requestMappingMethod,param);
            }
            if (result instanceof View) {
                handleViewResult((View)result,req,resp);

            } else if (result instanceof Data) {
               handleDataResult((Data)result,resp);
            }
        }
      }

    private void handleDataResult(Data data, HttpServletResponse resp) throws IOException {
        Object model = data.getModel();
        if (model != null) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            String json = JsonUtil.toJSON(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }

    private void handleViewResult(View view, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //返回Jsp页面
        String path = view.getPath();
        if (StringUtil.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                resp.sendRedirect(req.getContextPath() + path);
            } else {
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry : model.entrySet()) {
                    req.setAttribute(entry.getKey(), entry.getValue());
                }
                req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
            }
        }
    }
}

