<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新建 入库单 </title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=utf-8">
<META HTTP-EQUIV="content-script-type" CONTENT="text/JavaScript">
<META HTTP-EQUIV="content-style-type" CONTENT="text/css">
<link rel="stylesheet" href="css/cjpm.css">
<script type="text/javascript" src="js/cjcalendar.js"></script>
<script type="text/javascript" src="js/addFunction.js"></script>
</head>

<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">
 
function goto(strURL)
{
	document.forms[0].action=strURL;
	document.forms[0].submit();
}

function del(id)
{
	if(confirm("您确定删除该条明细？")){
		alert("删除成功！");
	}
}

function goSearch(){
	document.forms[0].action="jsp/stock/order3002.jsp";
	document.forms[0].submit();
}
 
-->
</SCRIPT>

<BODY BACKGROUND="image/bg.gif">
	<s:form action="orderOut_save" theme="simple" method="post">

		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">出库单详细</td>

				<td class="headerbar61">
					<p align="right">
						<s:submit value="保存"></s:submit>
						<input type=button value=" 返 回 " onClick="JavaScript:history.back();">
					</p>
				</td>
			</tr>
		</table>
		<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
		</table>
		<table border=0 cellspacing=1 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="textbar81" width="15%">单据号</td>
				<td class="textbar01" width="35%">
					<s:textfield value="自动编号" readonly="readonly"></s:textfield>
				</td>
				<td class="textbar81" width="15%">单据日期</td>
				<td class="textbar01" width="35%">
					<s:textfield name="dateStr"></s:textfield>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">所出仓库</td>
				<td class="textbar01" width="35%">
					<s:textfield name="wareHouseName"></s:textfield>
				</td>
				<td class="textbar81" width="15%">发往地址</td>
				<td class="textbar01" width="35%">
					<s:textfield name="send"></s:textfield>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">备注</td>
				<td class="textbar01" colspan="3" width="85%">
					<s:textfield name="remark"></s:textfield>
				</td>
			</tr>
		</table>

		<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
			<tr>
				<td></td>
			</tr>
		</table>

	</s:form>
</BODY>
</html>
