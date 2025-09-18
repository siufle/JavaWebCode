package com.cyx.jsp.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SecondServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println(name + " => " + value);
        }
        System.out.println("上下文路径：" + servletContext.getContextPath());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("读取请求头部信息");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + " => " + headerValue);
        }
        System.out.println("============================================");
        String contextPath = req.getContextPath();//获取上下文路径
        System.out.println("上下文路径: " + contextPath);
        String requestURI = req.getRequestURI();//获取包括上下文路径在内的请求地址
        requestURI = requestURI.replace(contextPath, "");
        System.out.println("请求地址: " + requestURI);
        System.out.println();
        HttpSession session = req.getSession();
        session.setAttribute("user","admin");
        System.out.println("开始做出响应");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("请求已处理");
        writer.flush();
        writer.close();
    }
}
