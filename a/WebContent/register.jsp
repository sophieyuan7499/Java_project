<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link href="css/register.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
	<div id="form">

	<form action="registerServlet" method="post">
		<p>请输入您的账号：<input type="text" name="account" id="account"/><span id="span1"></span></p>
		<p>请输入您的呢称：<input type="text" name="name" /></p>
		<p>请输入您的邮箱：<input type="text" name="email" /></p>
		<p>请输入您的密码：<input type="password" name="psw" /></p>
		<p><span>确&nbsp;&nbsp;&nbsp;认&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;：<input type="password" name="passwordAgain" /></span></p>
		<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;" /></p>
	</form>	
	
	</div>
</body>
</html>