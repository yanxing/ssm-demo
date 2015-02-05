<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>springmvc、spring、mybatis集成例子</title>
    <link rel="stylesheet" href="${ctx}/resources/css/search.css">
</head>
<body>
<div class="container-wrap">
    <form:form class="form-horizontal" role="form" commandName="student" action="${ctx}/search">
        <div class="col-lg-8">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="请输入学生学号" name="number"/>
      <span class="input-group-btn">
        <input class="btn btn-default" type="submit" value="搜索">
      </span>
            </div>
            <form:errors path="*" cssStyle="color:red"></form:errors><br/>
        </div>
    </form:form>
    <div class="result">
        <c:if test="${student.id!=null}">
        <table class="table table-hover">
            <tr class="active">
                <td><strong>学号</strong></td>
                <td><strong>姓名</strong></td>
                <td><strong>性别</strong></td>
                <td><strong>生日</strong></td>
                <td><strong>班级</strong></td>
                <td><strong>操作</strong></td>
            </tr>
            <tr>
                <td>${student.number}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${student.grade.name}</td>
                <td><a
                        href="${ctx}/update-view?id=${student.id}"><span
                        class="glyphicon glyphicon-pencil"></span></a>&nbsp; &nbsp;<a
                        href="javascript:if(confirm('确实要删除该条记录吗？'))location='${ctx}/deleteStudent?id=${student.id}'"
                        style="cursor: pointer"><span
                        class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </table>
        </c:if>
    </div>
</div>
</body>
</html>
