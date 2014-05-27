<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>大学生科技创新竞赛管理系统</title>
<style type="text/css">
body {
	background-color: #EEF2FB;
}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<body>
	<table width="83%" height="351" border="0" align="center">

		<tr>
			<td align="center" valign="middle"><s:property
					value="#session.username" />您好，您的功能有项目管理，学生报名管理，学习管理，上传课件。</td>
		</tr>
	
	</table>
</body>
</html>