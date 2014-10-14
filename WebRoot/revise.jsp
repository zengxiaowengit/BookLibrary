<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>My JSP 'revise.jsp' starting page</title>

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
<h2>修改图书${titleMsg }</h2>
	<s:form action="revise.action">
		<table>
			<tr>
				<td><s:textfield name="isbn">ISBN</s:textfield>
				</td>
				<td><s:textfield name="title">题目</s:textfield>
				</td>
				<td><s:textfield name="authorID">作者ID</s:textfield>
				</td>
				<td><s:textfield name="publisher">出版社</s:textfield>
				</td>
				<td><s:textfield name="publishDate">日期出版</s:textfield>
				</td>
				<td><s:textfield name="price">价格</s:textfield>
				</td>
				<td align="center">操作</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
