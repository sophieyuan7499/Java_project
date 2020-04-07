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
	
	<p><input type="checkbox" value="1" name="auto">记住密码</p>
	<p id="registerSubmit"><input type="submit" value="&nbsp;&nbsp;登录&nbsp;&nbsp;"/></p>
</form>
	
</div>
	
	
<script type="text/javascript">
	var cookie=document.cookie;
	function func(acc){
		var strs=cookie.split(";");
		for(var i=0;i<strs.length;i++){
			var arrs=strs[i].split("=");
			if(acc==arrs[0]){
				document.getElementById("psw").value=arrs[1];
			}
		}
	}
</script>	
</body>
</html>