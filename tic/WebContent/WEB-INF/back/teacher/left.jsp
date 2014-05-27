<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大学生科技创新竞赛管理系统</title>
<script src="${pageContext.request.contextPath}/js/prototype.lite.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/moo.fx.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/moo.fx.pack.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/back_comm.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/back_left.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top">
    <div id="container">
      <h1 class="type"><a href="javascript:void(0)">&nbsp;项目管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="teacher/projectListAction" target="main">所有比赛项目</a></li>
          <li><a href="teacher/searchAction" target="main">比赛项目搜索</a></li>
          <li><a href="teacher/addAction" target="main">添加比赛项目</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">报名管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="teacher/check_pass" target="main">通过名单</a></li>
          <li><a href="teacher/check_nopass" target="main">未通过名单</a></li>
        </ul>
      </div>
      <!-- 下面的一个功能写啥呢 -->
       <!-- <h1 class="type"><a href="javascript:void(0)">学习管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="list_user.jsp" target="main">回复问题</a></li>
        </ul>
      </div> -->
       <h1 class="type"><a href="javascript:void(0)">相关下载</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="teacher/uploadAction" target="main">文件上传</a></li>
          <li><a href="teacher/fileListAction" target="main">文件下载</a></li>
        </ul>
      </div>
      </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>

