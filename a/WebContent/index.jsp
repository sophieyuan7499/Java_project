<%@page import="model.User"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="model.news"%>
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
  User u= (User)session.getAttribute("User");
if(u==null){
	%>
	<div id="firstRow">
	<p class="title">您好游客</p>
	<a href="register" id="register">注册</a> <a href="Login.jsp" id="login">登录</a>
</div>
<% 
}else{
	%>
	
	<div id="secondRow">
	<p class="title">欢迎您，<%=u.getName() %></p>
	<a href="myindexController" id="myAccount">我的账户</a>
	<a href="loginoutController" id="cancel">注销</a> 
		
</div>
	<% 
	
}
%>
	

	
	<%-- <%
	news newsss=(news)request.getAttribute("ALL");
	out.println(newsss);

	%> --%>
	<form action="indexController" method="post" id="form">
		<p id="search">
			请输入标题：<input type="text" name="title" value="" />
			 <input type="submit"  value="搜索">
		</p>
		<table id="content">
			<tr>
				<th>序号</th>
				<th>标题</th>
				<th>楼主</th>
				<th>发帖时间</th>
			</tr>
			<%
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				int id = 0;
				int userid = 0;
				String content = "";

				String titie = "";
				List<news> l = (List<news>) request.getAttribute("All");
				//  Object obj=getServletContext().getAttribute("All");
				for (news list : l) {
					//request.setAttribute("id", list.getId());
					id = list.getId();
			%>
			<tr>
				<td><%=id%>></td>
				<%
					titie = list.getTitle();
				%>

				<td><a href="viewController?id=<%=id%>"><%=titie%>></a></td>
				<%
					userid = list.getUserid();
				%>

				<td><%=userid%></td>
				<%
					Timestamp date = list.getDate();
				%>
				<td><%=date%></td>
			</tr>
			<%
				}
			%>



		</table>

	</form>

</body>
</html>
