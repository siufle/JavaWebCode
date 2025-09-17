
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response内置对象</title>
</head>
<%
    String username = "",password = "";
    boolean rememberMe = false;
    //从请求中获取cookie信息
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie cookie : cookies) {
            if("username".equals(cookie.getName())){
                username = cookie.getValue();
            }else if("password".equals(cookie.getName())){
                password = cookie.getValue();
            }else if("rememberMe".equals(cookie.getName())){
                rememberMe = "on".equals(cookie.getValue());
            }
        }
    }
%>
<body>
    <form action="process.jsp" method="post">
        <div>
            <span>用户名</span>
            <input type="text" name="username" value="<%=username%>">
        </div>
        <div>
            <span>密码</span>
            <input type="password" name="password" value="<%=password%>">
        </div>
        <div>
            <input type="checkbox" name="rememberMe" <%=rememberMe ? "checked" : ""%>>记住密码
        </div>
        <div>
            <input type="submit" value="登录">
        </div>
    </form>
</body>
</html>
