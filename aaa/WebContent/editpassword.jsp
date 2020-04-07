<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<link href="../css/editPassword.css" rel="stylesheet" />
</head>
<body>
	<form action="logout" method="post" id="edit">
		<p>请输入新密码：<input type="password" name="psw1" /></p>
		<p>再输入一次&nbsp;&nbsp;&nbsp;：<input type="password" name="psw2"/></p>
		<input type="submit" value="&nbsp;&nbsp;确认&nbsp;&nbsp;" />
		<input type="button" value="&nbsp;&nbsp;取消&nbsp;&nbsp;"/>
	</form>
</body>
</html>