<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

<title>图书馆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	登录用户: ${usernameMsg }
	<br>


	<div align="center">
		<h1>欢迎来到我的图书馆!</h1>
		<s:form action="queryByAuthor.action">
			<s:textfield label="搜索作者" name="author">
				<br>
			</s:textfield>
			<table border="1">
				<tr>
					<td width="300">书名</td>
					<td width="200">作者</td>
					<td width="200">操作</td>
				</tr>

				<c:forEach items="${requestScope.authorQuery}" var="list">
					<tr>
						<td>${list.title}</td>
						<td>${current_author}</td>
						<td><s:form action="queryByTitle.action" target="_blank">
								<input name="title" type="hidden" value="${list.title}" />
								<input type="submit" value="查询"/>
							</s:form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</s:form>
	</div>

</body>
</html>






