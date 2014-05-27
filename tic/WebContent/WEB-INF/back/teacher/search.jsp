<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>" />
<title>大学生科技创新竞赛系统后台</title>
<link href="${pageContext.request.contextPath}/css/back_search.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function confirmtxt() {
		$().ready(function() {
			$("#searchForm").validate({
				rules : {
					"project.name": "required"
				},
				messages : {
					"project.name":"请输入要查询的项目名称"
				}
			});
		});
	}
</script>
<style type="text/css">
#searchForm label.error {
	color: red;
	margin: 4px;
}
</style>
</head>

<body topmargin="0" alink="#EEF2FB">
	<div align="center">
		<table border="0" width="760" cellspacing="0" cellpadding="0"
			height="373">
			<tr>
				<td width="769" align="left" bgcolor="#FFFFFF" height="11">
			<tr>
				<td width="769" align="left" bgcolor="#FFFFFF" height="98">
					<p align="center">
						<img border="0"
							src="${pageContext.request.contextPath}/images/sup.gif"
							width="800" height="275">
			<tr>
				<td width="769" align="left" bgcolor="#FFFFFF" height="264">
					<table border="0" cellPadding="0" cellSpacing="0" width="692"
						height="20">
						<tbody>
							<tr height="78" vAlign="top">
								<td width="168"></td>
								<td width="464">
									<table border="0" width="754" cellspacing="0" cellpadding="0"
										height="49">
										<TBODY>
											<tr>
												<td width="745" colspan="2" height="65"><table
														border="0" width="754" cellspacing="0" cellpadding="0"
														height="49">

														<tr>
															<td colSpan="2" width="745" height="19">

																<table width="745" height="20" border="0"
																	cellpadding="0" cellspacing="0"
																	bordercolorlight="#000000" bordercolordark="#FFFFFF">
																	<tr>
																		<td width="741">
		<form  method="post"
											action="teacher/searchProjectAction"
												 id="searchForm">
												<BR>
												<div align="center">
												<input type="text" name="project.name" size="90"
													placeholder="请输入要查询的项目" autofocus="autofocus">
	&nbsp;&nbsp; <INPUT type="submit" value="搜索" onclick="confirmtxt();">
													</div>
													<table border="0" cellpadding="0" cellspacing="0"
														width="100%" align="center">
														<tr>
															<td align="center">
																<p></p>
																</td>
																		</tr>
																				</table>
	</form>
	<span style="color: red;">
							 <s:if test="tip!=null">
								<s:property value="tip" />
							</s:if> </span>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
										</TBODY>
									</table>
						</TBODY>
					</table>
		</TABLE>
	</DIV>
</BODY>
</html>
