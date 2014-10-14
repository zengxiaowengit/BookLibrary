<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

<title>index</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<s:form action="login.action">
		<table width="510">
			<tr>
				<td width="266" height="92"></td>
				<td colspan="2">请输入用户名和密码。如果你还没有注册，请点击<a
					href="/register.jsp">注册</a>
				</td>

			</tr>
			<tr>
				<td height="31"><font color="RED"><s:property
							value="resultMsg" default=""></s:property> </font>
				</td>
				<td><div align="right">账&nbsp;&nbsp;&nbsp; 号:</div>
				</td>
				<td><input type="text" name="username" value="">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><div align="right">&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码:</div>
				</td>
				<td><input type="password" name="password" value="">
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" id="submit" value="提交">&nbsp;&nbsp;&nbsp;
					<input type="reset" name="reset" id="reset" value="重置">
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
