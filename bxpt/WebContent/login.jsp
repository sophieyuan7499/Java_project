<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<title>设备管理系统的</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
	
	
	<link href="css/common.css" rel="stylesheet">
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
	
	<!-- <link rel="shortcut icon" href="favicon.ico"/> -->
</head>

<body class="login">
	<div class="menu-toggler sidebar-toggler">
	</div>
	<div class="logo">
		<h3 class="logo-title">科大讯飞教育设备报修平台</h3>
	</div>
	<div class="content">
		<form class="login-form" action="loginServlet?param=login" method="post">
			<h3 class="form-title">用户登录</h3>
			<c:if test="${requestScope.error != null }">
				<div class="alert alert-danger ">
					<button class="close" data-close="alert"></button>
					<span>${requestScope.error }</span>
				</div>
			</c:if>
			<div class="form-group">
				<label class="control-label">用户名</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" value="${cookie.username.value}"/>
			</div>
			<div class="form-group">
				<label class="control-label">密码</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" value="${cookie.password.value}"/>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-success">确定登录</button>
				<label class="rememberme check">
				<input type="checkbox" name="remember" value="1" checked="checked"/>记住我 </label>
				<a href="javascript:;" id="forget-password" class="forget-password">忘记密码？</a>
			</div>
		</form>
		
		<form class="forget-form" action="loginServlet?param=forget" method="post" onsubmit="return inspect();">
			<h3>忘记密码?</h3>
			<p>
				 输入你的邮箱找回你的密码
			</p>
			<div class="form-group">
				<input class="form-control" type="text" autocomplete="off" placeholder="Email" name="email" id="email"/>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn btn-default">返回</button>
				<button type="submit" class="btn btn-success pull-right">确定提交</button>
			</div>
		</form>
	</div>
	<div class="copyright">
		 2019 © 科大讯飞教研项目组.
	</div>
</body>
</html>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$('#forget-password').click(function() {
        $('.login-form').hide();
        $('.forget-form').show();
    });

    $('#back-btn').click(function() {
        $('.login-form').show();
        $('.forget-form').hide();
    });
</script>
<script type="text/javascript">
$(function(){
	if($('input[name="username"]').val()==null||$('input[name="password"]').val()==null){
		$('input[name="username"]').attr({"value":"用户名"});
		$('input[name="password"]').attr({"value":"密码"});
	}
});
	
</script>
<script type="text/javascript">
function inspect(){
	var emailNode=document.getElementById("email");
	regEmail = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
	if(emailNode.value.length == 0) {
		alert("邮箱号不能为空");
		return false;
	}
	if (!regEmail.test(emailNode.value)) {
		alert("输入格式有误！");
		return false;
	}
	return true;
}
</script>