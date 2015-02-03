<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>springmvc、spring、mybatis集成例子</title>
</head>
<link rel="stylesheet" href="${ctx}/resources/css/index.css">
<%@include file="header.jsp" %>
<tbody>
<div class="container-wrap">
    <table class="table table-hover">
        <tr class="active">
            <td><strong>学号</strong></td>
            <td><strong>姓名</strong></td>
            <td><strong>性别</strong></td>
            <td><strong>生日</strong></td>
            <td><strong>操作</strong></td>
        </tr>
        <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.number}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>
                <td><a
                        href="${ctx}/updateStudent?id=${student.id}"><span
                        class="glyphicon glyphicon-pencil"></span></a>&nbsp; &nbsp;<a
                        href="javascript:if(confirm('确实要删除该条记录吗？'))location='${ctx}/deleteStudent?id=${student.id}'"
                        style="cursor: pointer"><span
                        class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</tbody>
</html>
