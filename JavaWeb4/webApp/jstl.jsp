<%@ page import="com.cyx.jsp.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签使用</title>
</head>
<body>
<%
    User user = new User();
%>
    <div><%--相当于在页面中创建了一个变量名为test 值为'测试'--%>
        <c:set var="test" value="测试" scope="page" />
        <c:set target="<%=user%>" value="管理员" property="name" />
    </div>

    <div>
        页面中的变量：${pageScope.test}
    </div>
    <%--移除页面范围内的test变量--%>
    <c:remove var="test" scope="page" />
    <div>
        页面中的变量：${pageScope.test}
    </div>
    <div>
        <%= user.getName() %>
    </div>
</body>
</html>
