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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=GB2312">
<META HTTP-EQUIV="content-script-type" CONTENT="text/JavaScript">
<META HTTP-EQUIV="content-style-type" CONTENT="text/css">
<title>新建 入库单</title>
<link rel="stylesheet" href="css/cjpm.css">
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/cjcalendar.js"></script>
<script type="text/javascript" src="js/addFunction.js"></script>
</head>

<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">var trFlag = 0;
function tabMove0(objId, position){
  if (event.keyCode == 13) {
          document.getElementById(objId).childNodes[2].innerHTML='07长面包新款';
          document.getElementById(objId).childNodes[3].innerHTML='045';
          tabMove(objId, position);
  }	
}
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
 
function save(){
	alert('保存成功');
}
function setValue(){
	document.forms[0].gys.value = "610";	
}
function delCom(id){
	if(id == "1"){
		document.forms[0].gys.value = "";	
	}else{
		document.forms[0].sccj.value = "";	
	}
}
function setValue1(){
	document.forms[0].sccj.value="";
}
-->
</SCRIPT>

<BODY BACKGROUND="image/bg.gif">
	<s:form action="orderIn_add" theme="simple" method="post">

		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">入库单详细</td>
				<td class="headerbar61"><p align="right">
					<s:submit value="保存"></s:submit>
					<input type=button value=" 返 回 " onClick="JavaScript:history.back();">
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
				<td class="textbar81" width="15%">入库日期</td>
				<td class="textbar01" width="35%">
				<s:textfield name="dateStr"></s:textfield>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">所入仓库</td>
				<td class="textbar01" width="35%">
				<s:textfield name="wareHouse_name"></s:textfield>
				</td>
				<td class="textbar81" width="15%">来源</td>
				<td class="textbar01" width="35%">
				<s:textfield name="source"></s:textfield>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">备注</td>
				<td class="textbar01" width="85%" colspan="3">
				<s:textfield name="remark"></s:textfield>
				</td>
			</tr>


		</table>

		<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
			<tr>
				<td></td>
			</tr>
		</table>

		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="2" bgcolor="gray">
			<tr>
				<td class="headerbar61" colspan="1">入库单明细</td>
				<td class="headerbar63" colspan="1">
					<p align="right">

						<input type=button value=" 新增明细 " onClick="goto('jsp/stock/order2003.jsp');">
					</p>
				</td>
			</tr>
		</table>

		<table id="tab0" border="0" cellspacing="1" cellpadding="2"
			width="100%" bgcolor="gray">
			<tr>
				<td width="5%" class="headerbar82">序号</td>
				<td width="20%" class="headerbar82">货号</td>
				<td width="20%" class="headerbar82">品名</td>
				<td width="15%" class="headerbar82">色号</td>
				<td width="15%" class="headerbar82">尺码</td>
				<td width="15%" class="headerbar82">数量</td>
				<td class="headerbar82">操作</td>
			</tr>
			<tr>
				<td class="gridbar11" align="center">1</td>
				<td class="gridbar11" align="center">BR1703</td>
				<td class="gridbar11">中款大衣</td>
				<td class="gridbar11">大红色</td>
				<td class="gridbar11">155</td>
				<td class="gridbar11" align="center">200</td>
				<td class="gridbar11" align="center"><a href="#"><img
						src="image/del.gif" align="bottom" border="0" alt="删除"
						onClick="javascript:del('673467')" /> </a></td>
			</tr>
			<tr>
				<td class="gridbar01" align="center">2</td>
				<td class="gridbar01" align="center">BR1703</td>
				<td class="gridbar01">中款大衣</td>
				<td class="gridbar01">大红色</td>
				<td class="gridbar01">185</td>
				<td class="gridbar01" align="center">200</td>
				<td class="gridbar01" align="center"><a href="#"><img
						src="image/del.gif" align="bottom" border="0" alt="删除"
						onClick="javascript:del('673467')" /> </a></td>
			</tr>
		</table>


	</s:form>
</BODY>
</html>
