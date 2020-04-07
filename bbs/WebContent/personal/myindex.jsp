<%@page import="bbs.model.news"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>我的主页</title>
<link href="../css/myIndex.css" rel="stylesheet" />
<style type="text/css">
#content1{
	margin-top:20px;
	width: 800px;
	display: block;
	border: 1px red solid;
	clear: both;
	margin: 0 auto;
}
tr{
	height: 30px;
}
td{
	border: 1px gray solid;
	text-align: center;
	font-size: 15px;
	line-height: 20px;
}
</style>
</head>
<body onload="fun3()">
	<div id="welcome"></div>
	<div id="index">
		<a href="../index">主页</a> 
		<a href="../logout">注销</a>
	</div>
	<div id="news">
		<a  href="#" onclick="fun2()">我的帖子</a>
		<a target="bottom" href="addnews.jsp" onclick="fun1()">发表新帖子</a>
		<a target="bottom" href="editpassword.jsp" onclick="fun4()">修改密码</a>
		
	</div>
<%
		List<news> lst =(List<news>)request.getAttribute("news1");
	 // out.print(lst);
	%>
	<table id="content1" style="border-collapse: collapse;">
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>楼主</th>
			<th>发帖时间</th>
			<th>操作</th>
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
		    	<tr><td>i+1</td>	
		    	<td><%=u.getTitle() %></td>	
		    	<td><%=u.getContent() %></td>	
		    	<td><%=u.getDate() %></td>	
		    	<td><a href="/bbs/deletenews?newsid=<%=u.getId() %>">删除</a>/<a href="XXXXX">编辑</a></td></tr>	
	<%} %>


	</table>
	<iframe src="" name="bottom" id="content2"></iframe>
	<script type="text/javascript">
		var table = document.getElementById("content1");
		var ifream = document.getElementById("content2");
		function fun1(){
			ifream.style.display = "block";
			table.style.display = "none";
		}
		function fun2(){
			table.style.display = "block";
			ifream.style.display = "none";
		}
		function fun3(){
			table.style.display = "block";
			ifream.style.display = "none";
		}
		function fun4(){
			ifream.style.display = "block";
			table.style.display = "none";
		}
	</script>
</body>
</html>