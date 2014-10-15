<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="h"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>注册页面</title>
</head>
<body>
	<h4>请输入用户注册信息</h4>
	点击此处
	<a href="/index.jsp">登录</a><!-- this is the the first file of the second revise.-->
	<h:form action="login">
		<table>
			<tr>
				<td>用户名:</td>
				<td colspan=2><input type="text" name="reg_username" />
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td colspan=2><input type="password" name="reg_password" />
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td colspan=2>
				<input type="reset" name="reset" value="重置" />
				<input type="submit" name="register" value="注册" />
				</td>
				<td><font color="red"><h:property value="resultMsg" /></font></td>
			</tr>
		</table>


	</h:form>
</body>
</html>
