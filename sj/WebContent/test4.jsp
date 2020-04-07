<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="robots" content="index, follow">
<title></title>
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/top.css" />
<link rel="stylesheet" href="css/box.css" />
<link rel="stylesheet" href="css/ltbox.css" />
<link rel="stylesheet" href="css/columns.css" />
<link rel="stylesheet" href="css/circleReset.css" />
<link rel="stylesheet" href="css/circleStyle.css" />
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="js/Singapore.js"></script>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/common.js"></script>
<script src="js/date.js"></script>
<script src="js/source/online.js"></script>

<script src="js/html5_3d_animation.js"></script>
<!-- circle.js圆圈 -->
<script src="js/circle.js" ></script>
<script type="text/javascript">
	$(function() {
		var window_width = $(window).width();
		var window_height = $(window).height()
		$("#html5_3d_animation").html5_3d_animation({
			window_width : window_width,
			window_height : window_height + 200,
			window_background : '#00040d',
			star_count : '250',
			star_color : 'rgba(100,149,237,0.9)',
			star_depth : '300'
		});
		$(window).resize(function() {
			var window_width = $(window).width();
			var window_height = $(window).height()
			$("#html5_3d_animation").html5_3d_animation({
				window_width : window_width,
				window_height : window_height + 200,
				window_background : '#02050a',
				star_count : '250',
				star_color : 'rgba(100,149,237,0.9)',
				star_depth : '300'
			});
		});
		var hearderH = $(".header").height();
		var mainH = $(".main").height();
		$("#map_box").height(mainH - hearderH);
	});
</script>
<style>
.box:after {
	content: "";
	position: absolute;
	top: -8px;
	right: -32px;
	left: -32px;
	bottom: -8px;
	/*border: 2px solid red;
			background: skyblue;
			margin: -20px;
			z-index: -1;*/
	-webkit-animation: lineB 8s linear infinite;
	-o-animation: lineB 8s linear infinite;
	animation: lineB 8s linear infinite;
	background: url("./img/box/rb_w.png") no-repeat right bottom;
}

@media screen and (max-width: 2000px) {
	#map_box {
		height: 700px;
	}
}

@media screen and (max-width: 1366px) {
	#map_box {
		height: 500px;
	}
}

#btn { /* 按钮美化 */
	width: 150px; /* 宽度 */
	height: 40px; /* 高度 */
	border-width: 0px; /* 边框宽度 */
	border-radius: 3px; /* 边框半径 */
	background: #B0E0E6; /* 背景颜色 */
	cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
	outline: none; /* 不显示轮廓线 */
	font-family: STKaiti; /* 设置字体 */
	color: white; /* 字体颜色 */
	font-size: 28px; /* 字体大小 */
	font-weight:800;
}#btn:hover { /* 鼠标移入按钮范围时改变颜色 */
	background: #5599FF;
}
</style>
</head>
<body>
	<div class="main bg">
		<canvas id="html5_3d_animation"></canvas>
		<!-- 这是圆圈导航 -->
		<div class="radmenu">
			<a ></a>
		</div>
		<div class='contentWrap'>
			<!-- 导航栏 -->
			<div class="header">
				<!--logo-->
				<div class="logo">
					<h3>
						新加坡爱彼迎数据分析<small></small>
					</h3>
				</div>
				<!--导航-->
				<div class="nav_menu nav">
					<ul>
						<li><a class="on">首页</a></li>
						<li><a href='TrafficLive.jsp'>数据展示</a></li>
						<li><a href="TrafficImpression.jsp">关于我们</a>
					</ul>
				</div>
				<!--时间，设置，帮助-->
				<div class="nav_extra">
					<ul>
						<li id="date">
							<!--星期-年/月/日-->
							<p id="date1"></p> <!--时-分-秒-->
							<p id="date2"></p>
						</li>
					</ul>
				</div>
			</div>
			<!-- 平台主题 -->
			<div class="content" id="main">
			<button id="btn">地图</button>
			<div id="map-wrap" style="height: 700px;">
				<!-- 这里以后是地图 -->
				</div>
				<script>
					var mapChart = echarts.init(document.getElementById('map-wrap'));
					
					var option = {
							geo: {
						      	map: '新加坡'
						  	},
						  	grid:{
			                      top:"50px",
			                      left:"50px",
			                      right:"15px",
			                      bottom:"50px"
			                  },
			
							series:[
							{
								type:'scatter',
								coordinateSystem:'geo',
								symbol:'circle',
								symbolSize:5,		
								data:[]
							}
							]
						}
					mapChart.setOption(option);
					var datas=[];
				
					$("#btn").click(function(){
						$.ajax({
							type:"post",
							url:"test4",
							async:false,
							success:function(data) {
								var arr=eval("("+data+")");
								$.each(arr,function(test4,item){
									var name= item.name;
									var longitude=item.longitude;
									var latitude=item.latitude;
									datas.push([longitude,latitude,name]);
								});
								mapChart.setOption({	series:[{data:datas	}]	});
							}
							
						});
					});
					
					</script>
					
			</div>
			 
		</div>
	</div>
<!-- 导航栏实时显示时间 -->
<script>
var date1 = document.getElementById("date1");
		var date2 = document.getElementById("date2");
		var haha = new Date();
		date1.innerHTML = haha.getWeek() + "   " + haha.format("YY-MM-DD");
		date2.innerHTML = haha.getNowTime();
		setTimeout(function() {
			date1.innerHTML = haha.update("week") + "   " + haha.update("YYYY-MM-DD");
			date2.innerHTML = haha.update("nowTime");
			setTimeout(arguments.callee,50)
		},50)
</script>
</body>
</html>