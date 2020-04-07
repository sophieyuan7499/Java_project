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

<form action="loginServlet" method="post">
	<%
	String account="";
	String psw="";
	//获取服务器传过来的所有的cookie 类型为数组
	Cookie []c=request.getCookies();
	//对for循环进行遍历
	for(int i=0;i<c.length;i++){
		if("account".equals(c[i].getName())){
			 account=c[i].getValue();
		}else if("psw".equals(c[i].getName())){
			 psw=c[i].getValue();
		}
		}

	%>
	<p>请输入您的账号：<input type="text" name="account" value="<%=account%>" /></p>
	<p>请输入您的密码：<input type="password" name="psw"  value="<%=psw %>" id="psw" />
	<input type="hidden" name="newsid" value=""/>
	
	</p>
	<p><input type="checkbox" value="1" name="auto">记住密码</p>
	<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;"/></p>
</form>
	
</div>
	
</body>
</html>