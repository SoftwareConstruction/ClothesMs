<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/cjpm.css">
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/cjcalendar.js"></script>
</head>

<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">function goto(strURL)
{
	document.forms[0].action=strURL;
	document.forms[0].submit();
}
function del(id)
{
	if(confirm("您确定删除该条记录？")){
		alert("删除成功！");
	}
}

function doAdd(){
	document.forms[0].action="jsp/system/CLOTHING1002.jsp";
	document.forms[0].submit();
}
 
-->
</SCRIPT>

<BODY BACKGROUND="image/bg.gif">
	<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST" ACTION=""
		ONSUBMIT="return false">

		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">货号查询</td>
				<td class="headerbar63" width="50%" colspan="1"><p
						align="right">
						<input type=submit value=" 查 询 " onClick="">
					</p>
				</td>
			</tr>
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

				<td class="textbar81" width="15%">货号</td>
				<td class="textbar01" width="35%"><input type="text" name="hh"
					value="" style="width:210px "></td>
				<td class="textbar81" width="15%">品名</td>
				<td class="textbar01" width="35%"><input type="text" name="hh"
					value="" style="width:210px "></td>
			</tr>
			<tr>
				<td width="15%" class="textbar81">色号</td>
				<td class="textbar01" width="35%"><select name=""
					style="width:210px ">
						<option value="" selected="selected">请选择</option>
						<option value="1">大红色</option>
						<option value="2">浅红色</option>
						<option value="3">紫红色</option>
						<option value="4">纯白色</option>
						<option value="5">米白色</option>
						<option value="6">深蓝色</option>
						<option value="7">淡蓝色</option>
						<option value="8">黑色</option>
						<option value="9">棕色</option>
				</select>
				</td>

				<td width="15%" class="textbar81">尺码</td>
				<td class="textbar01" width="35%"><select name=""
					style="width:210px ">
						<option value="" selected="selected">请选择</option>
						<option value="150">150</option>
						<option value="155">155</option>
						<option value="160">160</option>
						<option value="165">165</option>
						<option value="170">170</option>
						<option value="175">175</option>
						<option value="180">180</option>
						<option value="185">185</option>
						<option value="190">190</option>
				</select></td>
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
				<td class="headerbar61" width="50%" colspan="1">货号明细</td>
				<td class="headerbar63" width="50%" colspan="1"><p
						align="right">
						<input type=submit value=" 新 增 " onClick="JavaScript:doAdd();">
					</p>
				</td>
			</tr>
		</table>
		<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
		</table>
		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="0" bgcolor="gray">
			<tr>
				<td width="100%" colspan="1">
					<table border="0" cellspacing="1" cellpadding="2" width="100%">
						<tr>
							<td width="5%" class="headerbar82">序号</td>
							<td width="10%" class="headerbar82">货号</td>
							<td width="10%" class="headerbar82">色号</td>
							<td width="10%" class="headerbar82">尺码</td>
							<td width="15%" class="headerbar82">品名</td>
							<td width="10%" class="headerbar82">出厂价</td>
							<td width="10%" class="headerbar82">零售价</td>
							<td class="headerbar82">操作</td>
						</tr>


						<tr>
							<td class="gridbar11" align="center">1</td>
							<td class="gridbar11" align="center"><a href="#"
								onclick="javascript:goto('jsp/system/CLOTHING1002.jsp');">BR1703</a>
							</td>
							<td class="gridbar11" align="center">大红色</td>
							<td class="gridbar11" align="center">160</td>
							<td class="gridbar11" align="center">中款大衣</td>
							<td class="gridbar11" align="center">450.00</td>
							<td class="gridbar11" align="center">800.00</td>
							<td class="gridbar11" align="center"><img
								src="image/del.gif" align="bottom" border="0" alt="删除"
								onClick="javascript:del('673467')" style="cursor:hand" />
							</td>
						</tr>
						<tr>
							<td class="gridbar01" align="center">2</td>
							<td class="gridbar01" align="center"><a href="#"
								onclick="javascript:goto('jsp/system/CLOTHING1002.jsp');">BR1704</a>
							</td>
							<td class="gridbar01" align="center">大红色</td>
							<td class="gridbar01" align="center">160</td>
							<td class="gridbar01" align="center">中款大衣</td>
							<td class="gridbar01" align="center">450.00</td>
							<td class="gridbar01" align="center">800.00</td>
							<td class="gridbar01" align="center"><img
								src="image/del.gif" align="bottom" border="0" alt="删除"
								onClick="javascript:del('673467')" style="cursor:hand" />
							</td>
						</tr>
						<tr>
							<td class="gridbar11" align="center">3</td>
							<td class="gridbar11" align="center"><a href="#"
								onclick="javascript:goto('jsp/system/CLOTHING1002.jsp');">BR1705</a>
							</td>
							<td class="gridbar11" align="center">大红色</td>
							<td class="gridbar11" align="center">160</td>
							<td class="gridbar11" align="center">中款大衣</td>
							<td class="gridbar11" align="center">450.00</td>
							<td class="gridbar11" align="center">800.00</td>
							<td class="gridbar11" align="center"><img
								src="image/del.gif" align="bottom" border="0" alt="删除"
								onClick="javascript:del('673467')" style="cursor:hand" />
							</td>
						</tr>
						<tr>
							<td class="gridbar01" align="center">4</td>
							<td class="gridbar01" align="center"><a href="#"
								onclick="javascript:goto('jsp/system/CLOTHING1002.jsp');">BR1706</a>
							</td>
							<td class="gridbar01" align="center">大红色</td>
							<td class="gridbar01" align="center">160</td>
							<td class="gridbar01" align="center">中款大衣</td>
							<td class="gridbar01" align="center">450.00</td>
							<td class="gridbar01" align="center">800.00</td>
							<td class="gridbar01" align="center"><img
								src="image/del.gif" align="bottom" border="0" alt="删除"
								onClick="javascript:del('673467')" style="cursor:hand" />
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td colspan="2" align="right" height="20" nowrap class="textbar3">
					&nbsp; 共4条 &nbsp; 第1/1页 &nbsp; <a href="#" style="cursor:hand">首页</a>&nbsp;
					<a style="cursor:hand" href="#">上一页</a>&nbsp; <a
					style="cursor:hand" href="#">下一页</a>&nbsp; <a style="cursor:hand"
					href="#">尾页</a>&nbsp; &nbsp;</td>
			</tr>
		</table>

		</td>
		</tr>
		</table>
	</FORM>
</BODY>
</html>
