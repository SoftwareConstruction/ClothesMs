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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=GB2312">
<META HTTP-EQUIV="content-script-type" CONTENT="text/JavaScript">
<META HTTP-EQUIV="content-style-type" CONTENT="text/css">
<title>点击仓库的时候，右边显示的界面</title>
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
	<s:form action="wareHouse_list" theme="simple" method="post">


		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">仓库查询</td>
				<td class="headerbar63" width="50%" colspan="1"><p
						align="right">
						<s:submit value="查询list仓库"></s:submit>
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

				<td class="textbar81" width="15%">仓库编号</td>
				<td class="textbar01" width="35%"><input type="text" 
					value="" style="width:210px "></td>
				<td class="textbar81" width="15%">仓库名称</td>
				<td class="textbar01" width="35%"><input type="text" 
					value="" style="width:210px "></td>
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
				<td class="headerbar61" width="50%" colspan="1">仓库明细</td>
				<td class="headerbar63" width="50%" colspan="1"><p
						align="right">
						<input type=submit value=" 新 增 "
							onclick="JavaScript:goto('jsp/system/bsd_code_006_1.jsp');">
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
							<td width="10%" class="headerbar82">仓库编号</td>
							<td width="20%" class="headerbar82">仓库名称</td>
							<td width="10%" class="headerbar82">仓储量</td>
							<td width="5%" class="headerbar82">操作</td>
						</tr>

						<s:iterator value="#request.wareHouses" status="wareHouses">
						<tr>
							<td width="5%" class="gridbar11">${wareHouses.count}
							</td>
							<td width="10%" class="gridbar11"><s:property
										value="docu_number" />
							</td>
							<td width="20%" class="gridbar11"><s:property
										value="name" /></td>
							<td width="10%" class="gridbar11"><s:property
										value="total_storage" /></td>
							<td width="5%" class="gridbar11">
							<!-- 这里应该传一个ID 到action ,action中再通过id 获取管理员信息，然后再压到session中，转到编辑页面显示出来-->
							<a href="jsp/system/wareHouse_update_input.jsp?id=${id}&docu_number=${docu_number}&contact_phone=${contact_phone}&name=${name}&contact=${contact}&total_storage=${total_storage}&flag=${flag}">
										  <img src="image/edit.gif" align="bottom" border="0" alt="编辑" /> 
										</a>
							&nbsp;&nbsp;
							<a href="wareHouse_delete?docu_number=${docu_number}" onclick="del()">
								<img src="image/del.gif" align="bottom" border="0" alt="删除" />
							</a>
							</td>
						</tr>
						</s:iterator>
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

	</s:form>
</BODY>
</html>
