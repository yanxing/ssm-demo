<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>springmvc、spring、mybatis集成例子</title>
</head>
<link rel="stylesheet" href="${ctx}/resources/css/search.css">
<%@include file="header.jsp" %>
<body>
<div class="container-wrap">
    <div class="col-lg-8">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="请输入学生学号">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">搜索</button>
      </span>
        </div>
        <!-- /input-group -->
    </div>
    <!-- /.col-lg-6 -->
</div>
</body>
</html>
