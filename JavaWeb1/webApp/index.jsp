<%--导包--%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello JavaWeb
<%
    //这里就是jsp小脚本 支持编写Java代码
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentTime = format.format(now);
%>
<%!
    //这里可以定义方法
    String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
%>
今天是<%= currentTime %> 通过调用方法来展示日期：<%= dateToString(new Date())%>
<%
    String[] names = {"张三","李四","王五"};
%>
<%
    for(String name : names){
%>
<div><%= name %></div>
<%
    }
%>
</body>
</html>
