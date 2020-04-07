<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bbs.model.News"%>
<%@ page import="bbs.model.User"%>
<%@ page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link href="css/index.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="script/fenye1.js"></script>
</head>

<body>
	<c:if test="${sessionScope.User == null }">	
        <div id="firstRow"><p class="title">您好，游客</p>
   		 <a href="register.jsp" id="register">注册</a>
   		 <a href="login.jsp" id="login">登录</a>
   		</div>
    </c:if>
    <c:if test="${sessionScope.User != null }">
        	<div id="secondRow"><p class="title">欢迎您</p>	
    		<a href="logout" id="cancel">注销</a>
    		<a href="myindex" id="myAccount">我的账户</a> 
    	</div>
    </c:if>  
	



	<form action="index" method="post" id="form">
	<p id="search">请输入标题：<input type="text" name="title" value=""/>
		<input type="submit" value="搜索">
	</p>
	
	
	<table id="content">
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>楼主</th>
			<th>发帖时间</th>
		</tr>

	 <c:forEach items="${requestScope.NewsLst }" var="item" varStatus="s">		
       	<tr>
			<td>${s.index+1 }</td>
			<td><a href="ViewController?newsid=${item.id}">${item.title}</a></td>
			<td>${item.userid}</td>
			<td>${item.date }</td>
		</tr>
	</c:forEach>
	</table>
	
	</form>

</body>
</html>