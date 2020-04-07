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

<div id="login">

<form action="login" method="post">
	<p>请输入账号：<input type="text" name="account"  onblur="func(this.value)"/></p>
	<p>请输入密码：<input type="password" name="password"  id="psw"/>
	<input type="hidden" name="newsid" value=""/>	
	</p>
	
	
	<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;"/></p>
	<p><input type="submit" value="&nbsp;&nbsp;重置&nbsp;&nbsp;"/></p>
</form>
	
</div>
	
	
	
</body>
</html>