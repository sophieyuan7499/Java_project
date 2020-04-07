<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width:98%;">
	<head>
		<meta charset="UTF-8">
		<meta content="width=device-width, initial-scale=1" name="viewport"/>
		<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="../simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
		<link href="../css/common.css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/default.css" rel="stylesheet">
	</head>
	<script type="text/javascript">
	function confimRepair(eid){
		alert(eid);
		var result=window.confirm("维修成功了么？");
		if(result){
			window.location.href="equipmentServlet?param=result&results=1&eid="+eid;
		}else{
			window.location.href="equipmentServlet?param=result&results=2&eid="+eid;
		}
	}
	</script>
	<body style="background-color: #FFFFFF;">
		<div class="page-container container-fluid" style="margin-top:0;">
			<div class="page-bar">
				<ul class="breadcrumb">
				  <li>
				  	<i class="fa fa-home"></i>
					<a href="index.html">我的工作台</a>
					<i class="fa fa-angle-right"></i>
				  </li>
				  <li><a href="#">信息和报表</a></li>
				</ul>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="jumbotron dashboard-stat blue-madison">
						<div class="visual">
							<i class="fa fa-comments"></i>
						</div>
						<div class="details">
							<div class="number">
								 1349
							</div>
							<div class="desc">
								 未使用设备
							</div>
						</div>
						<a class="more" href="#">
							查看设备库存 <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="jumbotron dashboard-stat red-intense">
						<div class="visual">
							<i class="fa fa-bar-chart-o"></i>
						</div>
						<div class="details">
							<div class="number">
								 ￥125,000
							</div>
							<div class="desc">
								 本月维修费用
							</div>
						</div>
						<a class="more" href="#">
							维修记录查询 <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="jumbotron dashboard-stat green-haze">
						<div class="visual">
							<i class="fa fa-shopping-cart"></i>
						</div>
						<div class="details">
							<div class="number">
								 549
							</div>
							<div class="desc">
								 最新故障单
							</div>
						</div>
						<a class="more" href="#">
							故障处理 <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="row ">
				<div class="col-md-12 col-sm-12">
					<div class="panel panel-green">
					  <div class="panel-heading">
					  	<div class="caption">
							<i class="fa fa-check"></i>最新保修单
						</div>
						<div class="actions">
							<div class="btn-group">
								
							</div>
						</div>
					  </div>
					  <div class="panel-body">
						    <table class="table table-striped table-bordered table-advance table-hover">
								<thead>
								<tr>
									<th>
										设备所在地址
									</th>
									<th class="hidden-xs">
										设备类型
									</th>
									<th class="hidden-xs">
										设备编号
									</th>
									<th>
										<i class="fa fa-shopping-cart"></i>设备型号 
									</th>
									<th>
									        保修日期时间
									</th>
									<th>
									        维修结果
									</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${equipments}" var="eqlist">
								<tr>
									<td class="highlight">
										<div class="success">
										</div>
										<a href="#">
										${eqlist.address} </a>
									</td>
									<td class="hidden-xs">
										 ${eqlist.type}
									</td>
									<td class="hidden-xs">
										 ${eqlist.number}
									</td>
									<td>
										${eqlist.model}
									</td>
									<td>
										${eqlist.rtime}
									</td>
									<td>
										
										<i class="fa fa-edit"></i> ${eqlist.status}</a>
									</td>
								</tr>
							   </c:forEach>
								</tbody>
							</table>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/nav.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
	
	$(this).css("color","#CCC");
	$(this).unbind("click");
	})
	})
</script>