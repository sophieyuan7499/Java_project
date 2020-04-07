<%@page import="model.news"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>编辑帖子</title>
<link href="../css/addNews.css" rel="stylesheet" />
</head>
<body>
<%
news n=(news)session.getAttribute("newsss");
	String content= n.getContent();
 

%>

	<form action="editnewsController?newsid=<%=n.getId() %>" method="post" id="form">sss
		<p>标题：<input type="text" name="title" id="titleStyle" value=<%=n.getTitle() %>/></p>
		<p id="content">内容：<textarea rows="10" cols="40" id="contentStyle" name="content" ><%=content%></textarea></p>
		<input type="hidden" value="1" name="newsid">
		<p id="publish"><input type="submit" value="&nbsp;&nbsp;编辑&nbsp;&nbsp;"/></p>
	</form>
</body>
</html>