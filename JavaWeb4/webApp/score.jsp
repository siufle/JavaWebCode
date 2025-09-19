<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩展示页面</title>
</head>
<body>
    <c:if test="${sessionScope.zhangsan.score > 80}" var="result" scope="request">
        <div>成绩高于80</div>
    </c:if>
    <div>
        成绩高于80吗? ${requestScope.result}
    </div>

    <c:choose>
        <c:when test="${sessionScope.zhangsan.score > 90}">
            <div>优秀</div>
        </c:when>
        <c:when test="${sessionScope.zhangsan.score > 75}">
            <div>良好</div>
        </c:when>
        <c:when test="${sessionScope.zhangsan.score > 60}">
            <div>及格</div>
        </c:when>
        <c:otherwise>
            <div>不及格</div>
        </c:otherwise>
    </c:choose>

<table border="1">
    <thead>
    <tr>
        <th>姓名</th>
        <th>成绩</th>
        <th>考试时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.scores}" var="score" begin="2" step="3" end="14">
        <tr>
            <td>${score.name}</td>
            <td>${score.score}</td>
            <td>
                <fmt:formatDate value="${score.examDate}" pattern="YYYY-MM-dd HH:mm:ss" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    货币类型的数字：<fmt:formatNumber value="100" type="currency" />
</div>
<div>
    数字格式化：<fmt:formatNumber value="12345.678901" type="number" maxIntegerDigits="4" maxFractionDigits="4"/>
</div>
<div>
    数字格式化：<fmt:formatNumber value="12345.678901" type="number" pattern="####.##" />
</div>
<div>
    数字百分比：<fmt:formatNumber value="12345.678901" type="percent" maxIntegerDigits="3" maxFractionDigits="2"/>
</div>
</body>
</html>
