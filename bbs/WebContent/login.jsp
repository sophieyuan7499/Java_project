<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link href="css/login.css" rel="stylesheet" />
</head>
<body>

<div id="register">

<form action="login" method="post">
	<p>请输入您的账号：<input type="text" name="account"  /></p>
	<p>请输入您的密码：<input type="password" name="psw"  id="psw"/>
	<p><input type="hidden" name="newsid" value=""/></p>
	
	</p>
	<p><input type="checkbox" value="1" name="auto">记住密码 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">注册</a></p>
	<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;"/></p>
</form>
	
</div>
	
</body>
</html>