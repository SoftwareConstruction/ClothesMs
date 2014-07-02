<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>点击入库管理时候的页面</title>
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
<script type="text/javascript" src="js/page.js"></script>
</head>

<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">
function goSearch()
{
	document.forms[0].action="jsp/stock/order2001.jsp";
	document.forms[0].submit();
}

function delCom(id){
	if(id == '1'){
		document.idFrmMain.gys.value = "";		
	}else{
		document.idFrmMain.sccj.value = "";
	}
}

function changesize(id){
	document.forms[0].action="jsp/stock/order2001.jsp";
	document.forms[0].submit();
}

function jump(id){
	document.forms[0].action="jsp/stock/order2001.jsp";
	document.forms[0].submit();	
}

function locatePage(id){
	document.forms[0].action="jsp/stock/order2001.jsp";
	document.forms[0].submit();		
}
function del()
{
  if(confirm("您真的想删除该记录吗？"))
  {
     return true;
  }
  return false;
}
</SCRIPT>

<BODY BACKGROUND="image/bg.gif">
	<s:form action="orderIn_list" theme="simple" method="post">

		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">入库单查询</td>
				<td class="headerbar61">
					<p align="right">
						<s:submit value="查询"></s:submit>
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
				<td class="textbar81" width="15%">所入仓库</td>
				<td class="textbar01" width="35%"><select 
					style="width:152px">
						<option value="">------</option>
						<option value="1">一号仓库</option>
						<option value="2">二号仓库</option>
						<option value="3">三号仓库</option>
						<option value="4">四号仓库</option>
				</select>
				</td>
				<td class="textbar81" width="15%">单据编号</td>
				<td class="textbar01" width="35%"><input type="text"
					style="width:152px">
				</td>

			</tr>

			<tr>
				<td class="textbar81" width="15%">入库日期</td>
				<td class="textbar01" width="35%" colspan="3"><input
					type="text" 
					value="2007-06-21"
					readonly="readonly" size="12"> <input type="image"
					src="image/calendar.gif" width="18" height="17"
					onClick="CalendarWebControl.show(forms[0].frmWRPT_OPT_DATE2_PJT70302,'',forms[0].frmWRPT_OPT_DATE2_PJT70302);"
					title="显示日历" /> ~ <input type="text"
					
					value="2014-06-26" readonly="readonly" size="12"> <input
					type="image" src="image/calendar.gif" width="18" height="17"
					onClick="CalendarWebControl.show(forms[0].frmWRPT_OPT_DATE3_PJT70302,'',forms[0].frmWRPT_OPT_DATE3_PJT70302);"
					title="显示日历" />
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
				<td class="headerbar61" width="100%" colspan="1">入库单明细</td>
				<td class="headerbar61">
					<p align="rigth">
						<input type=submit value=" 新 增 "
							onClick="JavaScript:goto('jsp/stock/order2002.jsp');">
					</p>
				</td>
		</table>

		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="0" bgcolor="gray">
			<tr>
				<td width="100%" colspan="1">
					<table border="0" cellspacing="1" cellpadding="2" width="100%">
						<tr>
							<td  width="5%"  class="headerbar82">序号</td>
							<td   width="15%"  class="headerbar82">单据编号</td>
							<td   width="20%" class="headerbar82">所入仓库</td>
							<td    width="15%" class="headerbar82">入库日期</td>					
							<td    width="15%" class="headerbar82">经办人</td>
							<td    width="25%" class="headerbar82">来源</td>
							<td  class="headerbar82">操作</td>			
						</tr>
						<s:iterator value="#request.orderIn_list" status="orderIn_list">
						<tr>
							<td class="gridbar11" align="center">${orderIn_list.count}</td>
							<td class="gridbar11" align="center"><s:property value="docu_number"/>
							</td>
							
							<td class="gridbar11" align="center"><s:property value="wareHouse.name"/></td>
							<td class="gridbar11" align="center"><s:property value="in_time"/></td>
							<td class="gridbar11" align="left"><s:property value="manager.name"/></td>
							<td class="gridbar11" align="left"><s:property value="source"/></td>
							<td class="gridbar11" align="center">
								<a href="jsp/stock/orderIn_update_input.jsp?orderId=${orderId}
								&docu_number=${docu_number}&wareHouseName=${wareHouse.name}
								&in_time=${in_time}&managerName=${manager.name}
								&source=${source}
								&remark=${remark}&flag=${flag}">
									<img src="image/edit.gif" align="bottom" border="0" alt="编辑" /> 
								</a>
								&nbsp;&nbsp;
								<a href="orderIn_delete?id=${orderId}" onclick="del()">
									<img src="image/del.gif" align="bottom" border="0" alt="删除" />
								</a>
							</td>
						</tr>
						</s:iterator>
					</table>
					
				</td>
			</tr>
		</table>

		<table width="100%" border="0" cellpadding="0" cellspacing="2">
			<tr>
				<td colspan="2" align="right" height="20" nowrap class="textbar3">
					&nbsp; 共5条 &nbsp;&nbsp; 第1/1页 &nbsp;&nbsp; <a href="#"
					style="cursor:hand">首页</a>&nbsp;&nbsp; <a style="cursor:hand"
					href="#">上一页</a>&nbsp;&nbsp; <a style="cursor:hand" href="#">下一页</a>&nbsp;&nbsp;
					<a style="cursor:hand" href="#">尾页</a>&nbsp;&nbsp;</td>
			</tr>
			
		</table>
	</s:form>
</BODY>
</html>
