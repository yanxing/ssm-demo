<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>学生管理系统</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8 />
</head>
<frameset rows="64,*,20" frameborder="NO" border="0" framespacing="0">
	<frame src="admin/topAction" noresize="noresize" frameborder="0"
		name="topFrame" scrolling="no" marginwidth="0" marginheight="0">
	<frameset cols="200,*">
		<frame src="admin/leftAction" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="no">
		<frame src="admin/mainAction" name="main" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="auto">
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>