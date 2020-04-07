<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta content="width=device-width, initial-scale=1" name="viewport"/>
		<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="../simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
		<link href="../css/common.css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
		<link href="../css/bootstrap.min.css" rel="stylesheet"/>
		<link href="../css/default.css" rel="stylesheet"/>
		<script type="text/javascript">
			   function topPage(){
		   window.location.href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=${pageModel.topPage}";
	   }
	   
	   function previousPage(){
		   window.location.href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=${pageModel.previousPage}"; 
	   }
	   
	   function nextPage(){
		   window.location.href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=${pageModel.nextPage}";
	   }
	   function lastPage(){
		   window.location.href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=${pageModel.lastPage}";
	   }
	  </script>
	</head>
	<body style="background-color: #FFFFFF;">
		<div class="page-container container-fluid" style="margin-top:0;overflow-y:auto;">
			<div class="page-bar">
				<ul class="breadcrumb">
				  <li>
				  	<i class="fa fa-home"></i>
					<a href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=1">设备管理</a>
					<i class="fa fa-angle-right"></i>
				  </li>
				  <li><a href="#">设备库管理</a></li>
				</ul>
			</div>
			
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#" >
					设备列表 </a>
				</li>
				<li>
					<a href="html/addform.jsp">
					新增设备 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
					<div class="form">
						<form class="form-body" action="equipmentServlet?param=search&pageNo=1" method="post">
							<table style="width:100%;">
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">设备类型：</label></td>
									<td>
										<select name="typeid" class="form-control">
											<option value="1" selected="selected">电脑</option>
											<option value="2">黑板</option>
											<option value="3">桌椅</option>
											<option value="4">投影仪</option>
											<option value="5">音响设备</option>
											<option value="6">交换器</option>
										</select>
									
									<td style="text-align: right;padding: 10px;">型号：</td>
									<td><input type="text" class="form-control" name="model" placeholder="请输入设备型号"/></td>
									<td style="text-align: right;padding: 10px;">状态：</td>
									<td>
										<select name="statusid" class="form-control">
											<option value="1" selected="selected">正常</option>
											<option value="2">故障</option>
											<option value="3">报废</option>										
										</select>
									</td>
									<td style="text-align: right;padding: 10px;"></td>
									<td>
										<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i>查询</button>
										
									</td>
								</tr>
							</table>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">型号</th>
									<th class="text-center">编号</th>
									<th class="text-center">分类</th>
									<th class="text-center">品牌</th>
									<th class="text-center">地址</th>
									<th class="text-center">购买日期</th>
									<th class="text-center">状态</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${pageModel.equipments}" var="eqlist">
								<tr>
									<td>${eqlist.model}</td>
									<td>${eqlist.number}</td>
									<td>${eqlist.type}</td>
									<td>${eqlist.brands}</td>
									<td>${eqlist.address}</td>
									<td>${eqlist.buydate}</td>
									<td>${eqlist.status}</td>
									<td class="text-center"><a href="equipmentServlet?param=modify&eid=${eqlist.eid}">编辑</a>
										<a href="equipmentServlet?param=delete&pageNo=${pageModel.pageNo}&eid=${eqlist.eid}">删除</a>
									</td>
								</tr>
							</c:forEach>			
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5 col-sm-12">
					<div class="dataTables_info" style="padding-top: 8px;" role="status" aria-live="polite">显示${pageModel.pageNo } 到 ${pageModel.pageNo+5}共 ${pageModel.totalRecords } 记录</div>
				</div>
				<div class="col-md-7 col-sm-12">
					<div style="float: right;margin: 0px;height: 40px;" id="sample_1_paginate">
						<ul class="pagination" style="visibility: visible;">
							<li class="prev disabled"><a href="#" title="首页" onclick="topPage();"><i class="fa fa-angle-double-left"></i></a></li>
							<li class="prev disabled"><a href="#" title="上一页" onclick="previousPage();"><i class="fa fa-angle-left"></i></a></li>
							<li class="active"><a href="#">1</a></li><li><a href="#">2</a></li>
							<li><a href="#">3</a></li><li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="next"><a href="#" title="下一页" onclick="nextPage();"><i class="fa fa-angle-right"></i></a></li>
							<li class="next"><a href="#" title="尾页" onclick="lastPage();"><i class="fa fa-angle-double-right"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
