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

#uploadForm label.error {
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
			$("#uploadForm").validate({
				rules : {
                    content: "required"
				},
				messages : {
					content:"请选择上传文件"
				}
			});
		});
	}
</script>
</head>
<body>
	<div id="div">
		<p>您上传的文件应该小于20兆</p>
		<form action="teacher/uploadFileAction" method="post"
			enctype="multipart/form-data" id="uploadForm">
			<table width="334" border="0" align="center">
				<tr>
					<td width="150">选择文件：</td>
					<td align="left"><label> <input type="file" name="content" />
					</label></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><label> <input
							type="submit" value="提交" onclick="confirmtxt();" />
					</label></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><span style="color: red;"><s:fielderror />
							<s:actionerror /> <s:if test="tip!=null">
								<s:property value="tip" />
							</s:if> </span></td>
				</tr>
			</table>
		</form>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>
</body>
</html>
