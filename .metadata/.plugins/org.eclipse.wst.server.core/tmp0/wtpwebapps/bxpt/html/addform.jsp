<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<body style="background-color: #FFFFFF;">
		<div class="page-container container-fluid" style="margin-top:0;overflow-y:auto;height:100%;">
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
				<li>
					<a href="${pageContext.request.contextPath}/equipmentServlet?param=list&pageNo=1" >
					设备列表 </a>
				</li>
				<li class="active">
					<a href="#">
					新增设备 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
					<form action="${pageContext.request.contextPath}/equipmentServlet?param=add&pageNo=1" class="form-horizontal" method="post" role="">
						<div class="form-body">
						<div>
						<br>
						</div>
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 col-sm-3 control-label">型号：</label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="model" placeholder="请输入型号"/>	
									<span class="help-block">
									请输入物品的产品型号，包装或者物品背面</span>							 								
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputWarning">编号：<span class="required">
								</span></label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="number" placeholder="请输入编号"/>
								     <span class="help-block">
								         请输入正确的编号形式</span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputError">分类：</label>
								<div class="col-md-4 col-sm-4">									
									<div class="input-group">
										<select name="typeid" class="form-control">
											<option value="1" selected="selected">电脑</option>
											<option value="2">黑板</option>
											<option value="3">桌椅</option>
											<option value="4">投影仪</option>
											<option value="5">音响设备</option>
											<option value="6">交换器</option>
										</select>
									</div>
									
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputError">品牌：</label>
								<div class="col-md-4 col-sm-4">									
									<div class="input-group">
										<select name="brandsid" class="form-control">
											<option value="1" selected="selected">联想</option>
											<option value="2">三星</option>
											<option value="3">戴尔</option>
											<option value="4">松下</option>
											<option value="5">sony</option>
										</select>
									</div>									
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputWarning">地址：<span class="required">
								</span></label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="address" placeholder="请输入地址"/>
								     <span class="help-block">
								         请输入地址，比如：东一202</span>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputWarning">日期：<span class="required">
								</span></label>
								<div class="col-md-4 col-sm-4">
									<input type="date" class="form-control" name="buydate" placeholder="请输入购买日期"/>
								     <span class="help-block">
								         请输入正确的日期格式，例如：2015-03-09</span>
								</div>
							</div>
								<div class="form-group">
								<label class="control-label col-md-3 col-sm-3" for="inputError">状态：</label>
								<div class="col-md-4 col-sm-4">									
									<div class="input-group">
										<select name="statusid" class="form-control">
											<option value="1" selected="selected">正常</option>
											<option value="2">故障</option>
											<option value="3">报废</option>
										</select>
									</div>									
								</div>
							</div>														
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9 col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn blue">提交</button>
									<button type="reset" class="btn default "><i class="icon icon-refresh"></i>重置信息</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
