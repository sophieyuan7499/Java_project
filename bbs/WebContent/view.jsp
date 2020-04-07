<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.model.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>帖子</title>
<link href="css/view.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
<%
	news n=(news)request.getAttribute("news");

%>

	<p id="title"><%=n.getTitle() %></p>
	<div id="label">
	<p>发帖人：<%=n.getUserid() %></p>
	<p><%=n.getContent() %></p>
	<p>发帖时间：<%=n.getDate() %></p>
	</div>
	<div id="content"></div>
	
	<hr>
	<a href="#" id="checkComm">查看评论</a>
	<div id="comment">
		<%
	List<content> con=(List<content>)request.getAttribute("conlst");
	
	

	for(int i=0;i<con.size();i++){
		content conn=con.get(i);
		String content =conn.getContent();
		Date d =conn.getDate();
		int userid =conn.getUserid();
	
		%>
		<p>评论人<%=userid %>   【<%=d %>】：<%=content %></p>
	<%}%>
	
	</div>	
	
	
	
		
	<form action="view" method="post">
	<p id="myComment">我的评论：<textarea rows="10" cols="30" id="input" name="content"></textarea></p>
	
	<input type="hidden" name="newsid" value="<%=n.getId() %>" id="hnewsid">
	<p id="myCommentSubmit"><input type="submit" value="&nbsp;&nbsp;评论&nbsp;&nbsp;"/></p>
	</form>	
	<!-- 点击提交提交按钮   获取内容   将其保存倒数据库中去 -->
</body>
</html>