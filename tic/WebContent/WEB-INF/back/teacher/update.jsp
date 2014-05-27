<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<title>大学生科技创新竞赛系统后台</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<style type="text/css">
body {
	background-color: #EEF2FB;
}

#updateProjectForm label.error {
	color: red;
	margin: 4px;
}

#div {
	margin: 0 auto;
	width: 960px;
	text-align: center;
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	function confirmtxt() {
		$().ready(function() {
			$("#updateProjectForm").validate({
				rules : {
					"project.name" : "required",
					"project.period" : "required"
				},
				messages : {
					"project.name" : "请填写比赛名称",
					"project.period" : "请填写赛事届数"
				}
			});
		});
	}
</script>
</head>
<body>
	<div id="div">
		<p>修改比赛项目信息</p>
		<form action="teacher/updateProjectAction?project.id=<s:property value="list.get(0)"/>" method="post"
			id="updateProjectForm">
			<table width="498" border="0" align="center">
				<tr>
					<td align="right">比赛名称：</td>
					<td align="left"><input type="text" name="project.name" value="<s:property value="list.get(1)"/>"
						style="width: 200px"></td>
				</tr>
				<tr>
					<td align="right">赛事水平：</td>
					<td align="left"><select name="project.level"
						style="width: 200px">
							<option value="<s:property value="list.get(2)"/>"><s:property
									value="list.get(2)" /></option>
							<!-- 去除重复选项,但测试失败，没有找到原因-->
							<s:if test='<s:property value="list.get(2)"/>=="院级"'>
								<option value="校级">校级</option>
								<option value="国家级">国家级</option>
							</s:if>
							<s:elseif test='<s:property value="list.get(2)"/>=="校级" '>
								<option value="院级">院级</option>
								<option value="国家级">国家级</option>
							</s:elseif>
							<s:elseif test='<s:property value="list.get(2)"/>==" 国家级" '>
								<option value="院级">院级</option>
								<option value="校级">校级</option>
							</s:elseif>
							<s:else>
								<option value="院级">院级</option>
								<option value="校级">校级</option>
								<option value="国家级">国家级</option>
							</s:else>
					</select></td>
				</tr>
				<tr>
					<td align="right">届&nbsp;&nbsp;&nbsp;&nbsp;数：</td>
					<td align="left"><input type="text" name="project.period" value="<s:property value="list.get(3)"/>"
						style="width: 200px"><span
						style="color: red; margin: 4px;">例如第八届</span></td>

				</tr>
				
				<tr>
					<td colspan="2" align="right"><label> <input
							type="submit" value="修改" onclick="confirmtxt();" />
					</label></td>
				</tr>
			</table>
		</form>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>
</body>
</html>
