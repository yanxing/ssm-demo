<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>error</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back_admin.css" type="text/css"/>
  </head>
  <body>
    <s:fielderror></s:fielderror>
  </body>
</html>
