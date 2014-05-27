<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>" />
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
{
FONT-SIZE
:
 
12
px


}
.gridView {
	BORDER-RIGHT: #bad6ec 1px;
	BORDER-TOP: #bad6ec 1px;
	BORDER-LEFT: #bad6ec 1px;
	COLOR: #566984;
	BORDER-BOTTOM: #bad6ec 1px;
	FONT-FAMILY: Courier New
}

.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid;
	BORDER-TOP: #bad6ec 1px solid;
	BACKGROUND-IMAGE: url(../images/bg_th.gif);
	BORDER-LEFT: #bad6ec 1px solid;
	LINE-HEIGHT: 27px;
	BORDER-BOTTOM: #bad6ec 1px solid
}

.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid;
	BORDER-TOP: #bad6ec 1px solid;
	BORDER-LEFT: #bad6ec 1px solid;
	LINE-HEIGHT: 32px;
	BORDER-BOTTOM: #bad6ec 1px solid;
	TEXT-ALIGN: center
}

.cmdField {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	BACKGROUND-IMAGE: url(../images/bg_rectbtn.png);
	OVERFLOW: hidden;
	BORDER-LEFT: 0px;
	WIDTH: 67px;
	COLOR: #364c6d;
	LINE-HEIGHT: 27px;
	BORDER-BOTTOM: 0px;
	BACKGROUND-REPEAT: repeat-x;
	HEIGHT: 27px;
	BACKGROUND-COLOR: transparent;
	TEXT-DECORATION: none
}

.buttonBlue {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	BACKGROUND-IMAGE: url(../images/bg_button_blue.gif);
	BORDER-LEFT: 0px;
	WIDTH: 78px;
	COLOR: white;
	BORDER-BOTTOM: 0px;
	BACKGROUND-REPEAT: no-repeat;
	HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY
	style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../images/bg.gif); BACKGROUND-REPEAT: repeat-x">
	<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>

	<DIV>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR
					style="BACKGROUND-IMAGE: url(../images/bg_header.gif); BACKGROUND-REPEAT: repeat-x"
					height=47>
					<TD width=10><SPAN
						style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
					<TD><SPAN
						style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN
						style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0 px:">员工管理
					</SPAN><SPAN
						style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
					<TD
						style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(../images/main_rc.gif)"
						width=10></TD>
				</TR>
				<TR>
					<TD style="BACKGROUND-IMAGE: url(../images/main_ls.gif)">&nbsp;</TD>
					<TD
						style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white"
						vAlign=top align=middle>
						<DIV>
							<TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1
								style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0
								rules=all border=1>
								<TBODY>
									<TR>

										<TH class=gridViewHeader scope=col>Id</TH>
										<TH class=gridViewHeader scope=col>用户名</TH>
										<TH class=gridViewHeader scope=col>身份</TH>
										<TH class=gridViewHeader scope=col>邮箱</TH>
										<TH class=gridviewHeader scope=col>删除</TH>
									</TR>
									<s:iterator value="%{#request.lists}" id="user">
										<TR>

											<TD class=gridViewItem><s:property value="#user.id" /></TD>
											<TD class=gridViewItem><s:property
													value="#user.username" /></TD>
											<TD class=gridViewItem><s:property
													value="#user.typename" /></TD>
											<TD class=gridViewItem><s:property value="#user.email" /></TD>
											<TD class=gridViewItem><A class=cmdField
												id=ctl00_ContentPlaceHolder2_GridView1_ctl02_LinkButton1
												onclick="return confirm('确定要删除吗？');"
												href="<s:url action="admin/user_deleteOneUser">
            		<s:param name="userId" value="#user.id"/>
            		</s:url>"><font
													size="4" color="red">删除</font></A></TD>
										</TR>
									</s:iterator>
								</TBODY>
							</TABLE>
						</DIV>
					</TD>
					<TD style="BACKGROUND-IMAGE: url(../images/main_rs.gif)"></TD>
				</TR>
				<TR
					style="BACKGROUND-IMAGE: url(../images/main_fs.gif); BACKGROUND-REPEAT: repeat-x"
					height=10>
					<TD style="BACKGROUND-IMAGE: url(../images/main_lf.gif)"></TD>
					<TD style="BACKGROUND-IMAGE: url(../images/main_fs.gif)"></TD>
					<TD style="BACKGROUND-IMAGE: url(../images/main_rf.gif)"></TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>
	<SCRIPT type=text/javascript>
//<![CDATA[
Sys.Application.initialize();
//]]>
</SCRIPT>
</BODY>
</HTML>
