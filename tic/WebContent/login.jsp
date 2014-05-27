<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生科技创新竞赛系统后台</title>
<link href="css/back_comm.css" rel="stylesheet" type="text/css" />
<link href="css/back_login.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<style type="text/css">
#adminForm label.error {
	color: red;
		margin: 4px;
}
</style>
<script type="text/javascript">
	function loadimage() {
		document.getElementById("randImage").src = "login/verifycodeAction?"
				+ Math.random();
	}

	function confirmtxt() {
		$().ready(function() {
			$("#adminForm").validate({
				rules : {
					"user.username" : "required",
					"user.password" : {
						required : true,
						rangelength : [ 6, 16 ]
					//输入长度必须介于 6 和 10 之间的字符串")(汉字算一个字符)
					},
					verifycode : "required"
				},
				messages : {
					"user.username" : "请输入姓名",
					"user.password" : {
						required : "请输入密码",
						rangelength : jQuery.format("密码字符长度必须在6到16之间")
					},
					verifycode : "请输入验证码"
				}
			});
		});

	}
</script>
</head>
<body>
<body>
	<table width="100%" style="height: 166px" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="42" valign="top"><table width="100%"
					style="height: 42px" border="0" cellpadding="0" cellspacing="0"
					class="login_top_bg">
					<tr>
						<td width="1%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="17%">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td valign="top"><table width="100%" style="height: 590px"
					border="0" cellpadding="0" cellspacing="0" class="login_bg">
					<tr>
						<td width="49%" align="right"><table width="91%"
								style="height: 532px" border="0" cellpadding="0" cellspacing="0"
								class="login_bg2">
								<tr>
									<td height="138" valign="top"><table width="96%"
											style="height: 427px" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="20">&nbsp;</td>
											</tr>
											<tr>
												<td height="80" align="right" valign="middle"><img
													src="images/logo.png" width="340" height="68" /></td>
											</tr>
										</table></td>
								</tr>

							</table></td>
						<td width="1%">&nbsp;</td>

						<td width="50%" valign="bottom"><table width="100%"
								style="height: 59px" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="100"></td>
									<td></td>
								</tr>
								<tr>
									<td width="4%">&nbsp;</td>
									<td width="96%" height="38"><span class="login_txt_bt">管理员/老师
									</span></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="21"><table cellSpacing="0" cellPadding="0"
											width="100%" border="0" id="table211" height="328">
											<tr>
												<s:property value="user.usermane" />
												<td height="164" colspan="2" align="left">
													<form action="login/loginAction" method="post" id="adminForm">
														<table width="100%" border="0"
															style="height: 143px; cellSpacing: 0; cellPadding: 0;"
															id="table212">
															<tr>
																<td width="13%" height="30"><span class="login_txt">用户名：&nbsp;&nbsp;
																</span></td>
																<td height="30"><input type="text"
																	name="user.username" id="username" size="20"
																	placeholder="请输入用户名" autofocus="autofocus" />
															</tr>
															<tr>
																<td width="13%" height="30"><span class="login_txt">
																		密&nbsp;&nbsp;&nbsp;码： &nbsp;&nbsp; </span></td>
																<td height="30" align="left"><input type="password"
																	size="20" name="user.password" id="password"
																	placeholder="请输入密码" /></td>
															</tr>
															<tr>
																<td width="13%" height="30"><span class="login_txt">验证码：</span></td>
																<td height="30"><input type="text"
																	name="verifycode" id="verifycode" maxLength=4 size=10
																	placeholder="请输入验证码" /> <img alt="code..."
																	style="vertical-align: middle;" name="randImage"
																	id="randImage" src="login/verifycodeAction" width="60"
																	height="20" border="1" /> <a
																	href="javascript:loadimage();" class="font_style1">&nbsp;&nbsp;&nbsp;看不清？</a></td>
															</tr>
															<tr>
																<td width="5%"></td>
																<td width="95%" height="30" colspan="2"><input
																	type="submit" value="登 陆"
																	onclick="return confirmtxt();" /></td>
															</tr>
															<tr>
																<td width="13%" height="30"></td>
																<td height="56"><span class="login_txt"
																	style="color: red;"><s:fielderror /> <s:if
																			test="tip!=null">
																			<s:property value="tip" />
																		</s:if> </span></td>
															</tr>
														</table>
														<br />
													</form>
												</td>
											</tr>
											<tr>
												<td width="433" height="138" align="right" valign="bottom"></td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="20">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="login-buttom-bg">
					<tr>
						<td align="center"><span class="login-buttom-txt">滁州学院计算机与信息工程学院
								中国·安徽·滁州</span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>