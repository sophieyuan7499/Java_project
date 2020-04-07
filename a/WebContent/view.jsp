<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="model.news"%>
<%@page import="model.Comments"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>帖子</title>
<link href="css/view.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
<!-- 得到查询到的新闻 -->
<%
 news nn=(news)request.getAttribute("idnews");
		

%>

	<p id="title">标题：<%=nn.getTitle()%></p>
	<div id="label">
	<p>发帖人：<%=nn.getUserid() %></p>
	<p><%=nn.getContent() %></p>
	<p>发帖时间：<%=nn.getDate() %></p>
	</div>
	<div id="content"></div>
	呵呵
	<hr>
	<a href="#" id="checkComm">查看评论</a>
	<div id="comment">
		<!-- 新闻评论 -->
		 <%
	List<Comments>lst=(List<Comments>)request.getAttribute("CommLst");
		for(int i=0;i<lst.size();i++){
			Comments comm=lst.get(i);
			String content=comm.getContent();
					Date d=comm.getDate();
					int userid=comm.getUserid();
					%>
					<P>评论人<%=userid %>【<%=d %>】:<%=content %></P>
			<% 
		}
		%> 
	
	
	</div>	
	
	
	
		
	<form action="viewController" method="post">
	<p id="myComment">我的评论：<textarea rows="10" cols="30" id="input" name="content"></textarea></p>
	
	<input type="hidden" name="newsid" value="<%=nn.getId() %>" id="hnewsid">
	<p id="myCommentSubmit"><input type="submit" value="&nbsp;&nbsp;评论&nbsp;&nbsp;"/></p>
	</form>	
	<!-- 点击提交提交按钮   获取内容   将其保存倒数据库中去 -->
</body>
</html>