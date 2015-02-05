<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@include file="header.jsp" %>
<html>
<head>
    <title>springmvc、spring、mybatis集成例子</title>
<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
<script src="${ctx}/resources/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/resources/css/index.css">
<script type="text/javascript">
    $().ready(function () {
            $('.form_date').datetimepicker({
                format: "yyyy-mm-dd",
                language: 'zh-CN',
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2
            }).on('changeDate', function () {
                $(this).blur();
            });
        });

    </script>
</head>
<body>
<div class="container-wrap">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-sm-2 control-label">学号</label>

            <div class="col-sm-5">
                <input type="text" class="form-control" id="number" name="number" value="${student.number}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>

            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" name="name" value="${student.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>

            <div class="col-sm-5">
                <c:choose>
                    <c:when test="${student.sex==\"男\"}">
                        男&nbsp;<input type="radio" value="男" data-checkedClass="checked"
                        checked="checked" name="sex" id="sex">
                        &nbsp;&nbsp;&nbsp;女&nbsp;<input type="radio" value="女"
                        data-checkedClass="checked" name="sex" id="sex">
                    </c:when>
                    <c:when test="${student.sex==\"女\"}">
                        男&nbsp;<input type="radio" value="男" data-checkedClass="checked"
                        name="sex" id="sex">
                        &nbsp;&nbsp;&nbsp;女&nbsp;<input type="radio" value="女"
                        data-checkedClass="checked" checked="checked" name="sex"
                        id="sex">
                    </c:when>
                </c:choose>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">生日</label>

            <div class="input-group date form_date col-sm-5"
                 data-date-format="dd MM yyyy"
                 data-link-field="dtp_input3" data-link-format="yyyy-mm-dd">
                <input class="form-control" size="16" type="text"
                       id="birthday" name="birthday"
                       value='<fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/>'
                       readonly> <span class="input-group-addon"><span
                    class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>
        <div class="form-group">

            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" id="button"
                       onclick="return confirmtxt();" value="提交"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>
