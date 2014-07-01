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

<title>您好，管理员，请登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<BODY BACKGROUND="image/bg.gif">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="100%" height="32"><TABLE WIDTH=100% BORDER=0
					CELLPADDING=0 CELLSPACING=0>
					<TR>
						<TD width="376"><IMG SRC="image/top_1.jpg" WIDTH=376
							HEIGHT=54 ALT="">
						</TD>
						<TD width="90%" align="right" valign="bottom"
							background="image/top_2.jpg"><table width="100%" border="0"
								align="right" cellpadding="0" cellspacing="0">
								<tr>
									<td width="5%" align="center">&nbsp;</td>
									<td width="80%" align="right">&nbsp;</td>
									<td width="27%" align="right"><table width="75%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="128" height="24" align="right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</TD>
					</TR>
				</TABLE>
			</td>
		</tr>

	</table>

	<s:form action="admin_login" theme="simple" method="post">
		<table width="100%" height="40%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">
					<table width="300" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>用户名:<s:textfield name="user.username"></s:textfield>
							</td>
							<td>密&nbsp;码:<s:password name="user.password"></s:password>
							</td>
							<td><s:submit value="登录"></s:submit>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</BODY>
</html>