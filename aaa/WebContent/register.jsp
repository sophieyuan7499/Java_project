<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

<div id="register">

<form action="register" method="post">
		<p>请输入您的Id号：<input type="text" name="Id" id="Id"/><span id="span1"></span></p>
	    <p>请输入您的账号：<input type="text" name="account" id="account"/><span id="span1"></span></p>
		<p>请输入您的呢称：<input type="text" name="nickname" /></p>
		<p>请输入您的邮箱：<input type="text" name="email" /></p>
		<p>请输入您的密码：<input type="password" name="password" /></p>
		<p><span>确&nbsp;&nbsp;&nbsp;认&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;：<input type="password" name="passwordAgain" /></span></p>
		<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;" /></p>
</form>
	
</div>

</body>
</html>