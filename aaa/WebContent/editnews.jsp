<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bbs.model.User"%>
<%@ page import="bbs.model.News"%>
<%@ page import="java.util.List"%>
<%@ page import="bbs.model.Comment"%>
<%@ page import="bbs.model.User"%>
<%@ page import="java.sql.Date"%>
<%@ page import=" bbs.service.CommentService"%>
<%@ page import=" bbs.service.NewsService"%>
<%@ page import=" bbs.service.impl.CommentServiceImpl"%>
<%@ page import=" bbs.service.impl.NewsServiceImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发表帖子</title>
<link href="../css/addNews.css" rel="stylesheet" />
</head>
<body>
<form action="DeleteNewsController" method="post" id="form">
		<%News n=(News)request.getAttribute("News");%>	
		<p>标题：<input type="text" name="title" id="titleStyle" value="<%=n.getTitle() %>"/></p>
		<p id="content">内容：<textarea rows="10" cols="40" id="contentStyle" name="content"><%=n.getContent()%></textarea></p>
		<input type="hidden" value="<%=n.getId()%>" name="newsid">
		<p id="publish"><input type="submit" value="&nbsp;&nbsp;编辑&nbsp;&nbsp;"/></p>
	</form>
</body>
</html>