<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="bbs.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link href="css/index.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="script/fenye1.js"></script>
</head>

<body>
<%
//验证是否登录，若登录显示第二个div

user user=(user)session.getAttribute("user");
if(user==null){
%>
	<div id="firstRow"><p class="title">您好，游客</p>
	 <a href="register" id="register">注册</a>
	 <a href="login" id="login">登录</a>
</div>
	
<% }else{%>
	<div id="secondRow"><p class="title">欢迎您，</p>	
	<a href="logout" id="cancel">注销</a>
   <a href="personal/myindex" id="myAccount">我的账户</a>
</div>
	
<%}  %>


	

	

	<form action="index" method="post" id="form">
	<p id="search">请输入标题：<input type="text" name="title" value=""/>
		<input type="submit" value="搜索">
	</p>
	
	
	<%
		List<news> lst =(List<news>)request.getAttribute("newsList");
	 // out.print(lst);
	%>
	
	<table id="content">
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>楼主</th>
			<th>发帖时间</th>
		</tr>

		<%
		for(int i=0;i<lst.size();i++){
			news u=lst.get(i);
			int newsid=u.getId();
			String title=u.getTitle();
			Date day=u.getDate();
			int  userid1=u.getUserid();
			String content=u.getContent();
%>	
		<tr>
			<td>1</td>
			<td><a href="view?newsid=<%=newsid%>"><%=title%></a></td>
			<td><%=userid1%></td>
			<td><%=day%></td>
		</tr>
     
<%} %>
	</table>
	
	</form>

	</body>
	</html>