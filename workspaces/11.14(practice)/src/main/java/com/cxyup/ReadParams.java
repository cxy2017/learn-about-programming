package com.cxyup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ReadParams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadParams() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String title = "读取所表单数据";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        out.print(docType + "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n" +
                "</tr>\n");
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.print("<tr><td>" + paramName + "<td\n>");
            String[] paramValues = request.getParameterValues(paramName);
            //读取单个数值
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    out.println("<td><i>没有值</i></td>");
                } else {
                    out.println("<td><i>" + paramValue + "</i></td>");
                }
            } else {
                // 读取多个值的数据
                out.println("<td><ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul></td>");
            }
            out.print("</tr>");
        }
        out.println("\n</table>\n</body></html>");
    }
}
