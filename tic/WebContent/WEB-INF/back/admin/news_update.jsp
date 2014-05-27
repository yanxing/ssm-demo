<%@ page language="java" pageEncoding="utf-8" import="com.chzu.tic.model.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><base href="<%=basePath%>"/>
  <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
.STYLE6 {
	font-size: 16px;
	color: #6633FF;
}
.STYLE7 {font-size: 14px}
-->
  </style>
  <script type="text/javascript">
    var msg = "" ;
    msg = "${request.msg}" ;
    if(msg!=""){
       alert(msg) ;
    }
 </script>
<script src="${pageContext.request.contextPath}/js/tab.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8"
			src="${pageContext.request.contextPath}/js/kindeditor/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'news_content',
        cssPath : './index.css'
    });
  </script>
  <script type="text/javascript">
    function checkForm(){
        //去掉字符前后的空格 
        var $title = $.trim($("#news_title").val()) ;
        if($title==""){
           alert("公告标题不能为空！") ;
        }else{
           form1.noticecontent.value=KE.util.getData('news_content');
           form1.submit() ;
        }
    }
</script>
</head>
  
  <body>
<form method="post" name="form1" action="admin/news_updateOneNews?id=${requestScope.news.id}"> 
 <table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30" background="${pageContext.request.contextPath}/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="${pageContext.request.contextPath}/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="${pageContext.request.contextPath}/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1">[修改公告信息]</td>
              </tr>
            </table></td>
            <td width="54%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  
    <td>  <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="${pageContext.request.contextPath}/images/tab_12.gif">&nbsp;</td>
        <td>
        
       <!-- 表格开始  -->
       
        <table align="center" width="85%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6"  >
          <tr>
            <td colspan=2 height="37" bgcolor="#ECF8FF"><div align="center" class="STYLE1">
              <div align="center"><span class="STYLE6">修改公告信息</span></div>
            </div></td>
            </tr>
            <tr>
           <td width="16%" height="36" bgcolor="#ECF8FF"><div align="center"><span class="STYLE7">
             公告标题：
           </span>
           </div></td>
           <td width="84%" height="36" bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
           <input type="text" name="news_title" id="news_title" size="90" maxlength=90 STYLE="font-size:12pt;font-family:verdana;color:#333333;background-color:#D5D9E5"
           value="${requestScope.news.title}"/>
           </span>
           </div></td>
            </tr>
             <tr>
           <td height="20" bgcolor="#ECF8FF"><div align="center"><span class="STYLE7">
             公告内容：
           </span>
           </div></td>
           <td height="20" bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
           <textarea   id="news_content" style="width: 820px; height: 347px; visibility: hidden;">${requestScope.news.content}</textarea>
           <input type="hidden" id="noticecontent" name="news_content"/>
           </span>
           </div></td>
            </tr>
			<tr>
            <td height="35"  colspan=2 bgcolor="#ECF8FF"><div align="center" class="STYLE1">
              <input type="button" value="修改" onclick="checkForm()" STYLE="font-size:12pt;font-family:verdana;color:#333333;background-color:#D5D9E5"/>
              &nbsp;&nbsp;&nbsp;
              <input type="reset" value="重置" STYLE="font-size:12pt;font-family:verdana;color:#333333;background-color:#D5D9E5"/>
            </div> <div align="center"></div></td>
            </tr>
        </table>
 <!-- 表格结束  -->
       
          </td>
        <td width="8" background="${pageContext.request.contextPath}/images/tab_15.gif">&nbsp;</td>
     </tr>
    </table>
    
    </td>
   
 </tr>
  <tr>
    <td height="35" background="${pageContext.request.contextPath}/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/images/tab_20.gif" width="16" height="35" /></td>
        </tr>
       </table></td>
     </tr>
   </table>
</form>
  </body>
</html>
