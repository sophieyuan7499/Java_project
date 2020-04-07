<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>设备管理系统后台</title>
		<meta content="width=device-width, initial-scale=1" name="viewport"/>
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
		<link href="css/common.css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/default.css" rel="stylesheet"/>
	</head>
	
	<body> 
		<div class="page-header navbar navbar-fixed-top">
			<div class="page-header-inner">
				<div class="page-logo">
					<a href="#">
						<img src="img/ifly-logo2.png" alt="logo" class="logo-default"/>
					</a>
					<div class="navbar-header">
				      	<strong class="navbar-brand" href="#">科大讯飞设备管理系统</strong>
				    </div>
					<div class="menu-toggler sidebar-toggler hide">
					</div>
				</div>
				<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
				</a>
				
				<div class="top-menu">
					<ul class="nav navbar-nav pull-right">
						<!-- 登录用户的下拉菜单开始-->
						<li class="dropdown dropdown-user">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
								<img alt="" class="img-circle" src="img/avatar3_small.jpg"/>
								<span class="username username-hide-on-mobile">管理员 </span>
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-default">
								<li>
									<a href="">
									<i class="icon-user"></i> 个人信息 </a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="">
									<i class="icon-lock"></i> 密码修改 </a>
								</li>
								<li>
									<a href="">
									<i class="icon-key"></i> 安全退出 </a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->
		<div class="clearfix"></div>
		
		<div class="page-container">
			<!-- 菜单开始  -->
			<div class="page-sidebar-wrapper">
				<div class="page-sidebar navbar-collapse collapse">
					<ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
						<li class="sidebar-toggler-wrapper">
							<div class="sidebar-toggler">
							</div>
						</li>
						<%-- <li class="active">
							<a href="javascript:">
								<i class="icon-home"></i>
								<span class="title">我的工作台</span>
								<span class="selected"></span>
								<span class="arrow open"></span>
							</a>
							<ul class="sub-menu" id="submenu1">
								<li class="active">
									<a href="html/main.html" target="mainFrame">
									<i class="icon-volume-2"></i>
									信息和报表</a>
								</li>
								<li>
									<a href="html/main.html" target="mainFrame">
									<i class="icon-user"></i>
									个人信息</a>
								</li>
								<li>
									<a href="html/main.html" target="mainFrame">
										<i class="icon-lock"></i>
										密码修改
									</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="javascript:;">
								<i class="icon-settings"></i>
								<span class="title">系统功能</span>
								<span class="arrow "></span>
							</a>
							<ul class="sub-menu">
								<li>
									<a href="${pageContext.request.contextPath}/main.html" target="mainFrame">
										<i class="icon-users"></i>
										员工管理
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/main.html" target="mainFrame">
										<i class="icon-user-following"></i>
										角色管理
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/main.html" target="mainFrame">
										<i class="icon-tag"></i>
										菜单管理
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/main.html" target="mainFrame">
										<i class="icon-handbag"></i>
										数据字典
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/main.html" target="mainFrame">
										<i class="icon-home"></i>
										办公地管理
									</a>
								</li>
							</ul>
						</li> --%>
						<li>
							<a href="javascript:;">
								<i class="icon-screen-desktop"></i>
								<span class="title">设备管理</span>
								<span class="arrow "></span>
							</a>
							<ul class="sub-menu">
								<li>
									<a href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=1" target="mainFrame">
										<i class="fa fa-database"></i>设备库管理
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/equipmentServlet?param=destory" target="mainFrame">
										<i class="icon icon-wrench"></i>设备报修
									</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/equipmentServlet?param=repairs" target="mainFrame">
									<i class="icon-energy"></i>设备报修处理</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/equipmentServlet?param=records" target="mainFrame">
									<i class="icon-bar-chart"></i>维修记录查询</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			<div class="page-content-wrapper">
				<div class="page-content" >
					<iframe id="mainFrame" name="mainFrame" src="html/main.html" frameborder="0" style="width: 100%;min-height: 424px;" scrolling="no"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/nav.js"></script>
<script type="text/javascript">
//	$(".sub-menu").each(function(index,item){
//		$(this).collapse("hide");
//	});
	NAV.init();
</script>