package com.cyx.jsp.servlet;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class FirstServlet implements Servlet {
    private ServletConfig servletConfig;

    //servlet实例在该servlet处理第一次请求时才会创建 创建完成之后立即调用初始化方法
    public FirstServlet(){
        System.out.println("创建servlet实例");

    }

    //servlet初始化 只有初始化的servlet才能提供服务
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        //获取所有servlet参数名
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            //获取下一个参数名
            String initParameterName = initParameterNames.nextElement();
            //获取给定参数名对应的参数值
            String initParameterValue = servletConfig.getInitParameter(initParameterName);
            System.out.println(initParameterName + " => " + initParameterValue);
        }
        System.out.println("servlet 初始化完成");
    }

    //获取servlet配置
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    //处理请求的服务方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet 处理请求并做出响应");
        //获取字符编码集
        String characterEncoding = servletRequest.getCharacterEncoding();
        System.out.println("characterEncoding = " + characterEncoding);
        //设定字符编码集
        servletRequest.setCharacterEncoding("UTF-8");
        characterEncoding = servletRequest.getCharacterEncoding();
        System.out.println("characterEncoding = " + characterEncoding);
        System.out.println("读取请求体中的数据---------");
        BufferedReader reader = servletRequest.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("==========================================");
        System.out.println("读取请求中的属性---------");
        //获取request对象中存储的属性名称
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            //获取request对象中存储的属性对应的值
            Object attributeValue = servletRequest.getAttribute(attributeName);
            System.out.println(attributeName + " => " + attributeValue);
        }
        System.out.println("==========================================");
        System.out.println("读取请求中的参数---------");
        //获取request对象中存储的参数名称
        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            //获取request对象中存储的参数对应的值
            String parameterValue = servletRequest.getParameter(parameterName);
            System.out.println(parameterName + " => " + parameterValue);
        }
        System.out.println("==========================================");
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        parameterMap.forEach((key,value) -> System.out.println(key + " => " + Arrays.toString(value)));


        System.out.println("===========================================");
        System.out.println("响应的字符集编码：" +
                servletResponse.getCharacterEncoding());
        servletResponse.setCharacterEncoding("UTF-8");
        System.out.println("响应的字符集编码：" +
                servletResponse.getCharacterEncoding());
        System.out.println("响应的内容类型：" + servletResponse.getContentType());
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("响应的内容类型：" + servletResponse.getContentType());
        PrintWriter writer = servletResponse.getWriter();
        writer.print("登录请求已处理");
        writer.flush();
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁");
    }
}
