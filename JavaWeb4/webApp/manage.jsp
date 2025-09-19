
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理页面</title>
</head>
<body>
    <%--在request中取值         在session中取值--%>
    <%--${requestScope.user}<br>${sessionScope.user}--%>

    <div>
        ${requestScope.user.name} &nbsp;&nbsp; ${requestScope.user["sex"]}
    </div>
    <div>
        ${sessionScope.user.name} &nbsp;&nbsp; ${sessionScope.user["sex"]}
    </div>

    <div>    <%--通过下标引用集合中的元素--%>
        ${sessionScope.users[0].name} &nbsp;&nbsp; ${sessionScope.users[0]["sex"]}
    </div>
    <div>
        ${sessionScope.users[1].name} &nbsp;&nbsp; ${sessionScope.users[1]["sex"]}
    </div>

    <div>
        ${sessionScope.map.admin}
    </div>
    <div>
        ${sessionScope.map.test >= 90}
    </div>

    <div><%--不存在则返回true--%>
        ${empty sessionScope.test}
    </div>
</body>
</html>
