<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head> <base href="<%=basePath%>">
<title>大学生科技创新竞赛后台管理系统</title>
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出该系统吗？")){
		top.location = "login/exit";//先跳转到注销处理器，再到Login
		}
	return false;
}
</script>
<meta http-equiv=Content-Type content=text/html;charset=utf-8 />
<meta http-equiv="refresh" content="300" />
<link href="${pageContext.request.contextPath}/css/back_comm.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/back_skin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="${pageContext.request.contextPath}/images/logo.gif" width="340" height="64" /></td>
    <td width="39%" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr valign="middle">
        <td width="75%" height="38" class="admin_txt">您好,<b><s:property value="#session.username"/></b>！ 欢迎登录本系统！</td>
        <td width="22%" height="38" align="right"><a href="#" target="_self" onClick="return logout();"><img src="${pageContext.request.contextPath}/images/out.gif" alt="安全退出" width="46" height="20" border="0" /></a></td>
        <td width="3%" height="38">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
