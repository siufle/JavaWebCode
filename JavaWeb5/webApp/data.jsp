<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${agents}" var="agent">
    <tr>
        <td>${agent.aid}</td>
        <td>${agent.ano}</td>
        <td>${agent.aname}</td>
        <td>${agent.aregion}</td>
    </tr>
</c:forEach>