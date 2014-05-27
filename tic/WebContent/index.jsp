<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生科技创新竞赛</title>
<script src="js/jquery-1.11.0.min.js"></script>
<link href="css/view_index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#nav ul li").hover(function() {
			$(this).css("background", "#CCCCCC").children("ul").slideDown();
		}, function() {
			$(this).css("background", "url(images/nav_bg.jpg)").children("ul").slideUp();
		})
		$("#nav ul li ul li").hover(function() {
			$(this).css("background", "#CCCCCC");//鼠标滑过时候的颜色
		}, function() {
			$(this).css("background", "#FFFFFF");//鼠标滑过后的颜色
		})
	})
</script>
</head>
<body>
<div id="top">
   <div id="top1">
        <div id="logo"></div>
        <div id="login"></div>
   </div>

</div>
	<div id="nav">
		<ul>
			<li><a href="#">概述</a></li>
			<li><a href="#">竞赛项目</a>
				<ul>
					<li><a href="#">飞思卡尔</a></li>
					<li><a href="#">蓝桥杯</a></li>
					<li><a href="#">合财杯</a></li>
				</ul></li>
			<li><a href="#">论坛</a></li>
			<li><a href="#">资料下载</a></li>	
		</ul>
	</div>
</body>
</html>