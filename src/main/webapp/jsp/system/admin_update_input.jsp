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
<title>用户详细</title>
<link rel="stylesheet" href="css/cjpm.css">

</head>

<SCRIPT LANGUAGE="javaScript">
function save() {
	alert("保存成功！");
}

function back() {
	history.back();
}
</SCRIPT>
<BODY BACKGROUND="image/bg.gif">
	<s:form action="superAdmin_update" theme="simple" method="post">
		<table border="0" width="100%" id="table1" cellspacing="0"
			cellpadding="2" bgcolor="gray">
			<tr>
				<td class="headerbar61" width="15%" colspan="1">用户详细</td>
				<td class="headerbar63" width="85%" colspan="1">
				<s:submit value="保存"></s:submit>
				<input type="button"
					name="back70302003" onClick="javascript:back()" value=" 返 回 ">
				</td>
			</tr>
		</table>

		<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
		</table>

		<table border="0" width="100%" id="table1" cellspacing="1"
			cellpadding="2" bgcolor="gray">

				<input name="Id" type="text"  style="visibility:hidden" value="<%=request.getParameter("id") %>"></input>

			<tr>
				<td class="textbar81" width="15%" colspan="1">用户登录号</td>
				<td class="textbar01" width="85%" colspan="1">
				<input name="username" type="text" readonly="readonly" value="<%=request.getParameter("username") %>"></input>
				</td>
			</tr>
			
			<tr>
				<td class="textbar81" width="15%" colspan="1">用户姓名</td>
				<td class="textbar01" width="85%" colspan="1">
				<input name="name" type="text" value="<%=request.getParameter("name") %>"></input>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%" colspan="1">用户密码</td>
				<td class="textbar01" width="85%" colspan="1">
				<input name=password type="text" value="<%=request.getParameter("password") %>"></input>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%" colspan="1">用户简介</td>
				<td class="textbar01" width="85%" colspan="1">
				<input name="introduction" type="text" value="<%=request.getParameter("introduction") %>"></input>
				<input name="flag" type="hidden" value="<%=request.getParameter("flag") %>"></input>
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
