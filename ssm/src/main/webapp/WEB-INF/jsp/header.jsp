<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<!--  Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/resources/js/jquery-1.11.0.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<title>ssm</title>
<link rel="stylesheet" href="${ctx}/resources/css/header.css">
<nav class="navbar navbar-inverse navbar-fixed-top container-head ">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div id="navbar" class="text-center navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="list">所有学生</a></li>
				<li><a href="add-view">添加学生</a></li>
				<li><a href="search-view">查询学生</a></li>
			</ul>
		</div>
		<!--/.navbar-collapse -->
	</div>
</nav>
