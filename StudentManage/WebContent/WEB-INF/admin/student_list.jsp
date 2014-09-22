<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

.STYLE9 {
	font-size: 14px
}

.STYLE10 {
	color: #03515d
}

a:link {
	color: #000066;
	text-decoration: none;
}

a:visited {
	COLOR: #214D90;
	FONT-FAMILY: Arial;
	TEXT-DECORATION: none;
}

a:active {
	COLOR: #ff0000;
	FONT-FAMILY: Arial;
	TEXT-DECORATION: none;
}

a:hover {
	COLOR: #dd6800;
	TEXT-DECORATION: none;
}

.STYLE13 {
	font-size: 13px
}
-->
</style>

<script src="${pageContext.request.contextPath}/js/tab.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	function doDelete() {
		if (window.confirm("确认删除吗？")) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<BODY>
	<s:form method="post" action="Action" namespace="/admin">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30"
					background="${pageContext.request.contextPath}/images/tab_05.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30"><img
								src="${pageContext.request.contextPath}/images/tab_03.gif"
								width="12" height="30" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td width="46%" valign="middle"><table width="100%"
												border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="5%"><div align="center">
															<img
																src="${pageContext.request.contextPath}/images/tb.gif"
																width="16" height="16" />
														</div></td>
													<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[所有学生]</td>
												</tr>
											</table></td>
										<td width="54%"><table border="0" align="right"
												cellpadding="0" cellspacing="0">
											</table></td>
									</tr>
								</table></td>
							<td width="16"><img
								src="${pageContext.request.contextPath}/images/tab_07.gif"
								width="16" height="30" /></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="8"
								background="${pageContext.request.contextPath}/images/tab_12.gif">&nbsp;</td>
							<td><table id="reltable" width="100%" border="0"
									cellpadding="0" cellspacing="1" bgcolor="b5d6e6"
									onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<td width="10%" height="22"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">学号</span>
											</div></td>
										<td width="6%" height="22"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">姓名</span>
											</div></td>
										<td width="10%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">性别</span>
											</div></td>
										<td width="10%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">出生日期</span>
											</div></td>
											<td width="10%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">联系电话</span>
											</div></td>
											<td width="10%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">班级</span>
											</div></td>
											<td width="10%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">专业</span>
											</div></td>
											<td width="17%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">院系</span>
											</div></td>
										<td width="23%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF" class="STYLE1"><div align="center">
												<img
													src="${pageContext.request.contextPath}/images/oper.gif"
													width="16" height="16" />基本操作
											</div></td>
									</tr>
									<s:iterator value="pageBean.list" id="user">
										<tr>
											<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.number" />
												</div></td>
											<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.username" />
												</div></td>
											<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.sex" />
												</div></td>
											<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:date name="#user.birthday"
														format="yyyy-MM-dd" />
												</div></td>
												<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.phone" />
												</div></td>
												<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.classGrade.name" />
												</div></td>
												<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.classGrade.pro.name" />
												</div></td>
												<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE15 STYLE1">
													<s:property value="#user.classGrade.pro.dep.name" />
												</div></td>
											<td height="23" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE9">
													<span class="STYLE10"> <span class="STYLE13">
															<img
															src="${pageContext.request.contextPath}/images/vie.gif"
															width="16" height="16" /> <a
															href="admin/updateAction?user.id=${id}">修改</a>
															&nbsp; &nbsp; &nbsp; &nbsp;<img
															src="${pageContext.request.contextPath}/images/del.gif"
															width="16" height="16" /> <a
															href="admin/deleteAction?user.id=${id}"
															onclick="return doDelete();">删除名片</a>
													</span>
													</span>
												</div></td>
										</tr>
									</s:iterator>
								</table></td>
							<td width="8"
								background="${pageContext.request.contextPath}/images/tab_15.gif">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35"
					background="${pageContext.request.contextPath}/images/tab_19.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35"><img
								src="${pageContext.request.contextPath}/images/tab_18.gif"
								width="12" height="35" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td class="STYLE4">&nbsp;&nbsp;<span class="STYLE13">共有【${pageBean.allRow }】
												条记录，当前第 ${pageBean.currentPage }/${pageBean.totalPage } 页</span></td>
										<td><table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<s:if test="%{pageBean.currentPage == 1}">
														<td width="40"><img
															src="${pageContext.request.contextPath}/images/first.gif"
															width="37" height="15" /></td>
														<td width="45"><img
															src="${pageContext.request.contextPath}/images/back.gif"
															width="43" height="15" /></td>
													</s:if>
													<s:else>
														<td><a href="admin/listAction?page=1"> <img
																src="${pageContext.request.contextPath}/images/first.gif"
																width="37" height="15" />
														</a></td>
														<td><a
															href="admin/listAction?page=<s:property value="%{pageBean.currentPage-1}"/>">
																<img
																src="${pageContext.request.contextPath}/images/back.gif"
																width="43" height="15" />
														</a></td>
													</s:else>
													<s:if
														test="%{pageBean.currentPage != pageBean.totalPage&&pageBean.allRow!=0}">
														<td><a
															href="admin/listAction?page=<s:property value="%{pageBean.currentPage+1}"/>">
																<img
																src="${pageContext.request.contextPath}/images/next.gif"
																width="43" height="15" />
														</a></td>
														<td><a
															href="admin/listAction?page=<s:property value="pageBean.totalPage"/>">
																<img
																src="${pageContext.request.contextPath}/images/last.gif"
																width="37" height="15" />
														</a></td>
													</s:if>
													<s:else>
														<td><a
															href="admin/listAction?page=<s:property value="pageBean.totalPage"/>">
																<img
																src="${pageContext.request.contextPath}/images/next.gif"
																width="43" height="15" />
														</a></td>
														<td><a
															href="admin/listAction?page=<s:property value="pageBean.totalPage"/>">
																<img
																src="${pageContext.request.contextPath}/images/last.gif"
																width="37" height="15" />
														</a></td>
													</s:else>
												</tr>
											</table></td>
									</tr>
								</table></td>
							<td width="16"><img
								src="${pageContext.request.contextPath}/images/tab_20.gif"
								width="16" height="35" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</BODY>
</HTML>