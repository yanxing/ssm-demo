<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="${pageContext.request.contextPath}/css/back_comm.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/back_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="login-buttom-bg">
		<tr>
			<td align="center"><span class="login-buttom-txt">滁州学院计算机与信息工程学院
					中国·安徽·滁州</span></td>
		</tr>
	</table>
</body>
</html>