
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application内置对象</title>
</head>
<body>
<%
    Integer count = (Integer) application.getAttribute("count");
    if(count == null) {//第一个用户访问
        count = 1;
    }else{
        count += 1;
    }
    application.setAttribute("count", count);
%>
<div>用户访问次数:<%= count %></div>
</body>
</html>
