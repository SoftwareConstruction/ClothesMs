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
<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=utf-8">
<META HTTP-EQUIV="content-script-type" CONTENT="text/JavaScript">
<META HTTP-EQUIV="content-style-type" CONTENT="text/css">
<title>用户管理</title>
<link rel="stylesheet" href="css/cjpm.css">
</head>

<SCRIPT LANGUAGE="javaScript">

function goto()
{
	document.forms[0].action="jsp/system/USER1002.jsp";
	document.forms[0].submit();
}
 
function del(id)
{
	if(confirm("您确定删除该条数据？")){
		alert("删除成功！");
	}
}

function goSearch(){
	document.forms[0].action="jsp/system/USER1001.jsp";
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
	<s:form action="superAdmin_list" theme="simple" method="post">
		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">用户明细查询</td>
				<td class="headerbar61"><p align="right">
						<s:submit value="查询"></s:submit>
						
					</p></td>
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
				<td class="textbar81" width="15%">用户姓名</td>
				<td class="textbar01" width="35%"><input type="text" size="20" name = "checkName">
				</td>
				<td class="textbar81" width="15%">用户登录号</td>
				<td class="textbar01" width="35%"><input type="text" size="20">
				</td>
			</tr>

		</table>
		<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
		</table>
		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="2" bgcolor="gray">
			<tr>
				<td class="headerbar61" width="50%" colspan="1">用户明细表</td>
				<td class="headerbar63" width="50%" colspan="1"><input
					type="button" name="add" tabindex="1" onClick="javascript:goto()"
					value=" 新 增 "></td>
			</tr>
		</table>

		<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
		</table>

		<%--<s:iterator value="#request.admins" status="admins">
			<s:property value="username" /><br>
			<s:property value="password" /><br>
			<s:property value="name" /><br>
			<s:property value="flag" /><br>
			<s:property value="introduction" /><br>
		</s:iterator>

		--%>
		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="0" bgcolor="gray">
			<tr>
				<td width="100%" colspan="1">
					<table border="0" cellspacing="1" cellpadding="2" width="100%">
						<tr>
							<td width="5%" class="headerbar82">序号</td>
							<td width="35%" class="headerbar82">用户登录号</td>
							<td width="35%" class="headerbar82">用户姓名</td>
							<td class="headerbar82">操作</td>
						</tr>

						<s:iterator value="#request.admins" status="admins">
							<tr>
								<td class="gridbar11" align="center">${admins.count}</td>
								<td class="gridbar11" align="center"><s:property
										value="username" /></td>
								<td class="gridbar11" align="center"><s:property
										value="name" /></td>
								<td class="gridbar11" align="center">
								 
								         <!-- 这里应该传一个ID 到action ,action中再通过id 获取管理员信息，然后再压到session中，转到编辑页面显示出来-->
										<a href="jsp/system/admin_update_input.jsp?id=${Id}&username=${username}&password=${password}&name=${name}&introduction=${introduction}&flag=${flag}">
										  <img src="image/edit.gif" align="bottom" border="0" alt="编辑" /> 
										</a>
										&nbsp;&nbsp;
										
								    <a href="superAdmin_delete?username=${username}" onclick="del()"><img
										src="image/del.gif" align="bottom" border="0" alt="删除" /> </a></td>
							</tr>
						</s:iterator>

					</table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td colspan="2" align="right" height="20" nowrap class="textbar3">
					&nbsp; 共${accountAdmin }条 &nbsp; 第${page_num}/${accountPage}页 &nbsp; <a href="superAdmin_list?page_num=1" style="cursor:hand">首页</a>&nbsp;
					<a style="cursor:hand" href="superAdmin_list?page_num=${page_num-1}">上一页</a>&nbsp; <a
					style="cursor:hand" href="superAdmin_list?page_num=${page_num+1}">下一页</a>&nbsp; <a style="cursor:hand"
					href="superAdmin_list?page_num=${accountPage}">尾页</a>&nbsp; &nbsp;
				</td>
			</tr>
		</table>


	</s:form>
</BODY>
</html>
