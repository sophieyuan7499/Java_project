<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册</title>
</head>
<body>
<form action="login" method="post">
账号：<input type="text"  name="account">
密码：<input type="text"  name="password">
<input type="submit" value="登录">
</form>
${requestScope.msg }
</body>
</html>