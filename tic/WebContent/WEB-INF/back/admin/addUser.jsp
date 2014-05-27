<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大学生科技创新竞赛系统后台</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<style type="text/css">
#Form label.error {
	color: red;
	margin: 4px;
}
</style>
<script type="text/javascript">
	function confirmtxt() {
		$().ready(function() {
			$("#Form").validate({
				rules : {
					username : "required",
					password : {
						required : true,
						rangelength : [ 6, 16 ]
					//输入长度必须介于 6 和 10 之间的字符串")(汉字算一个字符)
					},
					repassword : {
						required : true,
						rangelength : [ 6, 16 ],
						equalTo : "#password"
					},
					email : {
						email : true
					}
				},
				messages : {
					username : "请输入姓名",
					password : {
						required : "请输入密码",
						rangelength : jQuery.format("密码字符长度必须在6到16之间")
					},
					repassword : {
						required : "请输入确认密码",
						rangelength : jQuery.format("密码字符长度必须在6到16之间"),
						equalTo: "您输入的确认密码和密码不一致，请重新输入"
					},
					email : {
						email : "您输入的电子邮箱不合法"
					}
				}
			});
		});

	}
</script>
</head>
<body>
	<form id="Form" method="post" action="admin/admin_addoneUser">
		<p>
			用户名&nbsp;&nbsp;：<input type="text" name="username" id="username" /><span
				style="color: red;">*</span><br /> 密码&nbsp;&nbsp;&nbsp;&nbsp;：<input
				type="password" name="password" id="password" /><span style="color: red;">*</span><br />
			确认密码：<input type="password" name="repassword" id="repassword" /><span
				style="color: red;">*</span> <br /> 邮箱&nbsp;&nbsp;&nbsp;&nbsp;：<input
				type="text" name="email" id="email" /><br />
			<br /> <input type="hidden" name="type1" value="1" /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				value="确定" onclick="confirmtxt();" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="reset" value="重置" />

		</p>
		<p><span style="color: red;">
							<s:if test="tip!=null">
								<s:property value="tip" />
							</s:if> </span></p>
	</form>
</body>
</html>