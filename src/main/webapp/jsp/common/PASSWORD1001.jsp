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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码页面</title>
<link rel="stylesheet" href="css/cjpm.css">
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/msn_message.js"></script>
<style type="text/css">
<!--
body {
	background-color: #f8f7f7;
}
-->
</style>
</head>

<BODY BACKGROUND="image/bg.gif">
	<s:form action="admin_changePassword" theme="simple" method="post">
		<table border=0 cellspacing=0 cellpadding=2 width="100%"
			bgcolor="gray">
			<tr>
				<td class="headerbar61">修改密码</td>
				<td class="headerbar61">
					<p align="right">
						<s:submit value="保存"></s:submit>
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
				<td class="textbar81" width="15%">旧密码</td>
				<td class="textbar01" width="85%">
					<s:password name="oldPassword"></s:password>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">新密码</td>
				<td class="textbar01" width="85%">
					<s:password name="newPassword"></s:password>
				</td>
			</tr>
			<tr>
				<td class="textbar81" width="15%">确认密码</td>
				<td class="textbar01" width="85%">
					<s:password name=""></s:password>
				</td>
			</tr>
		</table>

	</s:form>
</body>
</html>