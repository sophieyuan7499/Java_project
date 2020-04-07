<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="robots" content="index, follow">
	<title></title>
	<link rel="stylesheet" href="./css/box.css">
	<link rel="stylesheet" href="css/layout.css" />
	<link rel="stylesheet" href="css/top.css" />
	<link rel="stylesheet" href="css/ltbox.css" />
	<link rel="stylesheet" href="css/circleReset.css" />
    <link rel="stylesheet" href="css/circleStyle.css" />
   
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/common.js"></script>
<script src="js/date.js"></script>
<script src="js/source/online.js"></script>
	<script src="js/html5_3d_animation.js" ></script>
	<script type="text/javascript">	
		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"  			
   		}); 
		$(function() {
			var window_width=$(window).width();
			var window_height=$(window).height()
			$("#html5_3d_animation").html5_3d_animation({
				window_width:window_width,
				window_height:window_height+200,
				window_background: '#00040d',
				star_count: '250',
		        star_color: 'rgba(100,149,237,0.9)',
		        star_depth: '400'
			});
			$(window).resize(function(){
				var window_width=$(window).width();
				var window_height=$(window).height()
				$("#html5_3d_animation").html5_3d_animation({
					window_width:window_width,
					window_height:window_height+200,
					window_background: '#02050a',
					star_count: '250',
		        	star_color: 'rgba(100,149,237,0.9)',
		        	star_depth: '400'
				});
			});
		}); 	
	</script>
	<style type="text/css">
	    	.box:after{
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
		.amap-logo {
			right: 0 !important;
			left: auto !important;
			display: none;
		}
		
		.amap-copyright {
			right: 0px !important;
			left: auto !important;
			display: none;
		} 
		.info-title{
			color: white;
			font-size: 14px;
			background-color: blue;
			line-height: 26px;
			padding: 0px 0 0 6px;
			font-weight: lighter;
			letter-spacing: 1px
		}
		.info-content{
			padding: 4px;
			color: #666666;
			line-height: 23px;
			font: 12px Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial;
		}
		.info-content img{
			float: left;
			margin: 3px;
		} 
		#myPageTop1 {
			position: absolute;
			top: 0px;
			left: 100px;
			font-family: "Microsoft Yahei", Pinghei;
			font-size: 14px;
			background: none 0px 0px repeat scroll rgb(255, 255, 255);
			border-width: 1px;
			border-style: solid;
			border-color: rgb(204, 204, 204);
			border-image: initial;
			margin: 10px auto;
			padding: 6px;
		}
		.radmenu > a {
		  	/*top: 80%;*/
    		left: 87px;
		}
	</style>
</head>
<body>
<div class="main bg">
		<canvas id="html5_3d_animation"></canvas>
		<!-- 这是圆圈导航 -->
		<div class="radmenu">
			<a href="#" class="show" draggable='false'>关于我们</a>
			<ul>
				<li>
			      <a href="index.jsp">首页</a>
			    </li>
			    <li>
			      <a href="TrafficLive.jsp">数据展示</a>
			    </li>
			</ul>
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
						<li><a href="index.jsp">首页</a></li>
						<li><a href="TrafficLive.jsp">数据展示</a></li>
						<li><a class="on">关于我们</a></li>
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
<script src="js/circle.js" ></script>

<script>
  $(document).on("click",'button',function(){
	  $("button").each(function(n,value){
		  $(value).removeClass("trafbtn selected");
	  })
	  $(this).addClass("trafbtn selected")
  })
</script>
<script type="text/javascript">
  $(function load(){
	  $("#trf1").show();
	  $("#trf2").hide();
	  $("#trf3").hide();
	  $("#trf4").hide();
  })
</script>
<script type="text/javascript">
  $("#load1").click(function(){
	  $("#trf1").show();
	  $("#trf2").hide();
	  $("#trf3").hide();
	  $("#trf4").hide();
  })  
</script>
<script type="text/javascript">
  $("#load2").click(function(){
	  $("#trf2").show();
	  $("#trf1").hide();
	  $("#trf3").hide();
	  $("#trf4").hide();
  })  
</script>
<script type="text/javascript">
  $("#load3").click(function(){
	  $("#trf3").show();
	  $("#trf2").hide();
	  $("#trf1").hide();
	  $("#trf4").hide();
  })  
</script>
<script type="text/javascript">
  $("#load4").click(function(){
	  $("#trf4").show();
	  $("#trf2").hide();
	  $("#trf3").hide();
	  $("#trf1").hide();
  })  
</script>
</body>
</html>