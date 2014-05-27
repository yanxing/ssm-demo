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
	var msg = "";
	msg = "${request.msg}";
	if (msg != "") {
		alert(msg);
	}
</script>
<script type="text/javascript">
	function doDelete() {
		if (window.confirm("确认删除吗？")) {
			return true;
		} else {
			return false;
		}
	}
</script>
<!--<script type="text/javascript">
	//全选复选框单击事件 
	var flag = 1;
	function selectAll() {
		if (flag == 1) {
			if (form1.checklist.length != undefined) {
				for (var i = 0; i < form1.checklist.length; i++)
					form1.checklist[i].checked = true;
			} else {
				form1.checklist.checked = true; //全选
			}
			flag = 0;
		} else {
			if (form1.checklist.length != undefined) {
				for (var i = 0; i < form1.checklist.length; i++)
					form1.checklist[i].checked = false;
			} else {
				form1.checklist.checked = false;//全不选 
			}
			flag = 1;
		}
	}
	function formSubmit() {
		if (window.confirm("确认删除您选中的公告信息吗？")) {
			var checklist = document.getElementsByName("checklist");
			var flag = false;
			for (var i = 0; i < checklist.length; i++) {
				if (checklist[i].checked) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				alert("请最少选中一条公告信息进行删除！");
				return false;
			} else {
				form1.submit();
			}
		} else {
			return false;
		}
	}
</script>-->
</head>
<BODY>
	<s:form method="post" action="admin/news_list">
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
													<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[新闻信息]</td>
												</tr>
											</table></td>
										<td width="54%"><table border="0" align="right"
												cellpadding="0" cellspacing="0">
												<tr>
													<!--  <s:if test="#session.flag==0">
                       <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkAll" id="checkAll" onclick="selectAll();"/>
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="addNotice.jsp">新增</a></div></td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/images/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="#" onclick="return formSubmit()">删除</a></div></td>
                  </tr>
                </table></td>
                </s:if> -->
												</tr>
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
										<!--<s:if test="#session.flag==0">
             <td width="4%" height="22" background="${pageContext.request.contextPath}/images/bg1.gif" bgcolor="#FFFFFF"><div align="center">
               <span class="STYLE1">选择</span>
            </div></td>
          </s:if>-->
										<td width="61%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">新闻标题</span>
											</div></td>
										<td width="16%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">发布时间</span>
											</div></td>
										<td width="19%" height="22" bordercolor="#FFFFFF"
											background="${pageContext.request.contextPath}/images/bg1.gif"
											bgcolor="#FFFFFF" class="STYLE1"><div align="center">
												<img
													src="${pageContext.request.contextPath}/images/oper.gif"
													width="14" height="14" />基本操作
											</div></td>
									</tr>
									<s:iterator value="pageBean.list" id="news">
										<tr>
											<s:if test="#session.flag==0">
												<td height="29" bgcolor="#FFFFFF"><div align="center">
														<input type="checkbox" name="checklist"
															value=<s:property value="#news.id"/> />
													</div></td>
											</s:if>
											<td height="29" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE9">
													<div align="center">
														<a href="admin/news_newsDetails?notice.id=${id}"><s:property
																value="#news.title" /></a>&nbsp;&nbsp;
													</div>
												</div></td>
											<td height="29" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE9">
													<s:date name="date" format="yyyy年MM月dd日" />
												</div></td>
											<td height="29" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><div
													align="center" class="STYLE9">
													<span class="STYLE10"> <img
														src="${pageContext.request.contextPath}/images/vie.gif"
														width="16" height="16" /><a
														href="admin/news_newsDetails?notice.id=${id}">详情</a>

														&nbsp; &nbsp;| <img
														src="${pageContext.request.contextPath}/images/edt.gif"
														width="16" height="16" /><a
														href="admin/news_showOneNews?notice.id=${id}">编辑</a>&nbsp;
														&nbsp;| <img
														src="${pageContext.request.contextPath}/images/del.gif"
														width="16" height="16" /><a
														href="admin/news_deleteOneNews?notice.id=${id}"
														onclick="return doDelete();">删除</a>

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
														<td><a href="admin/news_list?page=1"> <img
																src="${pageContext.request.contextPath}/images/first.gif"
																width="37" height="15" />
														</a></td>
														<td><a
															href="admin/news_list?page=<s:property value="%{pageBean.currentPage-1}"/>">
																<img
																src="${pageContext.request.contextPath}/images/back.gif"
																width="43" height="15" />
														</a></td>
													</s:else>
													<s:if
														test="%{pageBean.currentPage != pageBean.totalPage&&pageBean.allRow!=0}">
														<td><a
															href="admin/news_list?page=<s:property value="%{pageBean.currentPage+1}"/>">
																<img
																src="${pageContext.request.contextPath}/images/next.gif"
																width="43" height="15" />
														</a></td>
														<td><a
															href="admin/news_list?page=<s:property value="pageBean.totalPage"/>">
																<img
																src="${pageContext.request.contextPath}/images/last.gif"
																width="37" height="15" />
														</a></td>
													</s:if>
													<s:else>
														<td><img
															src="${pageContext.request.contextPath}/images/next.gif"
															width="43" height="15" /></td>
														<td><img
															src="${pageContext.request.contextPath}/images/last.gif"
															width="37" height="15" /></td>
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