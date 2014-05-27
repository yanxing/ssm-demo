<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录-科技创新</title>
<link href="${pageContext.request.contextPath}/css/view_login.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#loginForm").validate({
			rules : {
				username : "required",
				password : {
					required : true,
					rangelength:[6,16]//输入长度必须介于 6 和 10 之间的字符串")(汉字算一个字符)
				},
			},
			messages : {
				firstname : "请输入姓名",
				password : {
					required : "请输入密码",
					minlength : jQuery.format("密码字符长度必须在6到16之间")
				},
			}
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<form action="" method="post" id="loginForm">
			<div class="loginBox">
				<div class="loginBoxCenter">
					<p>
						<label for="username">用户名：</label>
					</p>
					<p>
						<input type="text" id="username" name="username"
							class="loginInput" autofocus="autofocus" 
							autocomplete="on" placeholder="请输入用户名" value="" />
					</p>
					<p>
						<label for="password">密码：</label>
					</p>
					<p>
						<input type="password" id="password" name="password"
							class="loginInput"  placeholder="请输入密码"
							value="" />
					</p>
				</div>
				<div class="loginBoxButtons">
					<button class="loginBtn">登录</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>