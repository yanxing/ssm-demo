<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生管理系统</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-ui.css">
<style type="text/css">
#Form label.error {
	color: red;
	margin: 4px;
}
</style>
<script type="text/javascript">
    
$(function() {
    $( "#datepicker" ).datepicker();
  });
  //自定义jquery校验规则
jQuery.validator.addMethod("isMobile", function(value, element) {
	var length = value.length;
	var mobile = /^((\+86)|(86))?\d{11}$/;
	return this.optional(element) || (mobile.test(value));
	}, "请正确填写您的手机号码");
	function confirmtxt() {
		$().ready(function() {
			$("#Form").validate({
				rules : {
					"student.number" : "required",
					"student.username":"required",
					"student.phone" : {
						isMobile : true
						},
				},
				messages : {
					"student.number" : "请输入学号",
					"student.username":"请输入姓名",
					"student.phone":"手机号码格式不正确！请重新输入！"
				}
			});
		});

	};
	
</script>
</head>
<body>
	<form id="Form" method="post" action="admin/addStudentAction">
		<p>
			学&nbsp;&nbsp;号：&nbsp;&nbsp;&nbsp;<input type="text"
				name="student.number" id="student.number"
				value="<s:property value="list.get(1)"/> " /><span
				style="color: red;">*</span><br /> 用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" name="student.username" id="student.username"
				value="<s:property value="list.get(2).trim()"/> " /><span
				style="color: red;">*</span><br />
			性&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp; <input type="radio"
				name="student.sex" value="男" checked="checked" />男 <input
				type="radio" name="student.sex" value="女" />女 <br /> 出生日期： <input
				type="text" name="birthday" id="datepicker" readonly="readonly"
				value="<s:property value="list.get(4)"/>"> <br />
			手&nbsp;机&nbsp;号: &nbsp;<input type="text" name="student.phone"
				value="<s:property value="list.get(5)"/>" id="mobile" /> <br />
			<%-- 班&nbsp;&nbsp;级：&nbsp; &nbsp;<input type="text"
				name="student.classGrade.name"
				value="<s:property value="list.get(6)"/> " /> <br />
			地&nbsp;&nbsp;址:&nbsp;&nbsp; &nbsp;<input type="text"
				name="user.address" value="<s:property value="list.get(5)"/> " /> --%>
			班&nbsp;&nbsp;&nbsp;级：&nbsp;&nbsp;<select name="name"
				id="professionId">
				<s:iterator value="list1" id="classGrade">
					<option value="<s:property value="#classGrade.name"/>"><s:property
							value="#classGrade.name" /></option>
				</s:iterator>
			</select> <input type="hidden" name="student.id"
				value="<s:property value="list.get(0)"/>" /><br />
			<%-- <input
				type="hidden" name="student.classGrade.id" value="<s:property value="list.get(6)"/>" /> --%>
			<br />
			<%-- <input
				type="hidden" name="student.classGrade.pro" value="<s:property value="list.get(7)"/>" /><br />
				<input
				type="hidden" name="student.classGrade.pro.dep" value="<s:property value="list.get(8)"/>" /><br /> --%>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				value="确定" onclick="confirmtxt();" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <input type="reset" value="重置" /> -->

		</p>
	</form>
	<span class="login_txt" style="color: red;"><s:fielderror /> <s:if
			test="tip!=null">
			<s:property value="tip" />
		</s:if> </span>
</body>
</html>