<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻详情</title>
</head>
<body>
<br/>
<p align="center"><font size="4" color="black">${requestScope.news.title}</p>
<hr>
<p align="center"><font size="2" color="black">发布时间：${requestScope.news.date} &nbsp;&nbsp;&nbsp;  信息来源：计算机与信息工程学院<br><br>
<p align="center">${requestScope.news.content}
</body>
</html>