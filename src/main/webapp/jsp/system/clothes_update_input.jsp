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

<title>更新货号--输入</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=gb2312">
<META HTTP-EQUIV="content-script-type" CONTENT="text/JavaScript">
<META HTTP-EQUIV="content-style-type" CONTENT="text/css">
<title>品牌修改</title>
<link rel="stylesheet" href="css/cjpm.css">
<script type="text/javascript" src="js/cjcalendar.js"></script>
<script language="javascript" src="js/page.js"></script>
</head>

<script language="javascript">
	var CalendarWebControl = new atCalendarControl();
</script>
<SCRIPT LANGUAGE="javaScript">function delCom(id){
	if(id == '1'){
		document.idFrmMain.gys.value = "";		
	}else{
		document.idFrmMain.sccj.value = "";
	}
}

function save()
{
	alert("保存成功！");
}

function back()
{
	history.back();
}

</SCRIPT>
<BODY BACKGROUND="image/bg.gif">
	<FORM NAME="idFrmMain" ID="idFrmMain" METHOD="POST" ACTION=""
		ONSUBMIT="return false">
		<table border="0" width="100%">
			<tr>
				<td width="100%" colspan="0" rowspan="0" align="center"
					valign="center">
					<table border="0" width="100%" id="table1" cellspacing="0"
						cellpadding="2" bgcolor="gray">
						<tr>
							<td class="headerbar61" width="50%">货号详细</td>
							<td class="headerbar63" width="50%"><input type="button"
								name="save70302002" onClick="javascript:save()" value=" 保 存 ">
								<input type="button" name="save70302002"
								onClick="javascript:back()" value=" 返 回 "> &nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="100%" colspan="0" rowspan="0" align="center"
					valign="center">
					<table border="0" width="100%" id="table1" cellspacing="1"
						cellpadding="2" bgcolor="gray">
						<tr>
							<td class="textbar81" width="15%">货号</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("docuNum") %>" size="15" style="width:210px "></td>
							<td class="textbar81" width="15%">品名</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("commodity_name") %>" size="15" style="width:210px "></td>
						</tr>
						<tr>
							<td width="15%" class="textbar81">色号</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("color") %>" size="15" style="width:210px ">
							</td>

							<td width="15%" class="textbar81">尺码</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("size") %>" size="15" style="width:210px "></td>
						</tr>
						<tr>
							<td width="15%" class="textbar81">面料</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("out_material") %>" size="15" style="width:210px "></td>
							<td class="textbar81" width="15%">里料</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("in_material") %>" size="15" style="width:210px "></td>
						</tr>
						<tr>
							<td width="15%" class="textbar81">出厂价</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("ex_factory_price") %>" size="15" style="width:210px "></td>
							<td class="textbar81" width="15%">零售价</td>
							<td class="textbar01" width="35%"><input type="text"
								value="<%=request.getParameter("retail_price") %>" size="15" style="width:210px "></td>
						</tr>


					</table>
					<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
						<tr>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</FORM>
</BODY>
</html>
