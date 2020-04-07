<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.model.News"%>
<%@ page import="java.util.List"%>
<%@ page import="bbs.model.Comment"%>
<%@ page import="bbs.model.User"%>
<%@ page import="java.sql.Date"%>
<%@ page import=" bbs.service.CommentService"%>
<%@ page import=" bbs.service.NewsService"%>
<%@ page import=" bbs.service.impl.CommentServiceImpl"%>
<%@ page import=" bbs.service.impl.NewsServiceImpl"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子</title>
<link href="css/view.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
	<%News n=(News)request.getAttribute("News");%>	
	<p id="title"><%=n.getTitle() %></p>
	
	<div id="label">
	<p>发帖人：<%=n.getUserid() %></p>
	<p><%=n.getContent()%></p>
	<p>发帖时间：<%=n.getDate() %></p>
	</div>
	
	<div id="content"><%=n.getContent()%></div>
	
	<hr>
	
	<a href="#" id="checkComm">查看评论</a>
	<div id="comment">
	<!---新闻的评论---->
	<%
	List<Comment> lst=(List<Comment>)request.getAttribute("CommLst");
	for(int i=0;i<lst.size();i++){
		Comment comm=lst.get(i);
		String content=comm.getContent();
		Date d=comm.getDate();
		int userid=comm.getUserid();
		%>
		<p>评论人<%=userid%>[<%=d %>]:<%=content %></p>
	<% }
	%>
	
	</div>	
	
	<form action="ViewController" method="post">
	<p id="myComment">我的评论：<textarea rows="10" cols="30" id="input" name="content"></textarea></p>
	<input type="hidden" value="<%=n.getId()%>" name="newsid">
	<p id="myCommentSubmit"><input type="submit" value="&nbsp;&nbsp;评论&nbsp;&nbsp;"/></p>
	</form>	
		

</body>
</html>