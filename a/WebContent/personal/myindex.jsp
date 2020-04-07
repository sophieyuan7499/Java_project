<%@page import="model.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.news"%>
<%@page import="java.util.List"%>
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
	<div id="welcome">欢迎您，呵呵</div>
	<div id="index">
		<a href="../indexController">主页</a> 
		<a href="../logout">注销</a>
	</div>
	<div id="news">
		<a  href="#" onclick="fun2()">我的帖子</a>
		<a target="bottom" href="/bbs/personal/addnews.jsp" onclick="fun1()">发表新帖子</a>
		<a target="bottom" href="/bbs/personal/editpassword.jsp" onclick="fun4()">修改密码</a>
		
	</div>


	<table id="content1" style="border-collapse: collapse;">

		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>楼主</th>
			<th>发帖时间</th>
			<th>操作</th>
		</tr>

<%-- <%
/* HttpSession session=request.getSession(true); */

User u=(User)session.getAttribute("User");
%> --%>
				<%
 List<news> lst=(List<news>) request.getAttribute("newsss");
 for(news l:lst){
	 %>
	<tr>
		    	<td><%=l.getId() %></td>	
		    	<td><%=l.getTitle() %></td>	
		    	<td><%=l.getUserid() %></td>	
		    	<td><%=l.getDate2() %></td>	
		    	<%
		    	
		    	out.println(l.getId());
		    	%>
		    	<td><a href="/bbs/deletenewsController?newsid=<%=l.getId() %>">删除</a>/<a href="/bbs/editnewsController?newsid=<%=l.getId()%>">编辑</a></td>
		    	
		    	</tr>
	 
	 <%
 }
 

%>
		    		
	


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