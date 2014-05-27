<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生科技创新竞赛管理系统</title>
<style type="text/css">
body {
	background-color: #EEF2FB;
}
</style>
</head>
<body>
	<table width="83%" height="351" border="0" align="center">
		<tr>
			<td align="center" valign="middle"><s:property
					value="#session.username" />您好，您的功能有发布新闻，管理新闻，管理用户。</td>
		</tr>
	</table>
</body>
</html>