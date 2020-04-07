<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="robots" content="index, follow">
<title></title>
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/top.css" />
<link rel="stylesheet" href="css/ltbox.css" />
<link rel="stylesheet" href="css/circleReset.css" />
<link rel="stylesheet" href="css/circleStyle.css" />
<link rel="stylesheet" href="css/trafficeLive.css" />
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/common.js"></script>
<script src="js/date.js"></script>
<script src="js/source/online.js"></script>
<script src="js/html5_3d_animation.js"></script>
<script>	
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
    <script src="js/circle.js" ></script>
<style>
    	@media screen and (max-width: 2000px) {
    		#mapContainer {
    			height: 850px;
    		}
    	}
    	@media screen and (max-width: 1400px) {
    		#mapContainer {
    			height: 500px;
    		}
    	}
    	
    	#submit_btn1{
           width:400px;   
           height:200px;   
           background:url(img/1.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
  #submit_btn2{
           width:400px;   
           height:200px;   
           background:url(img/2.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
  #submit_btn3{
           width:400px;   
           height:200px;   
           background:url(img/3.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
  #submit_btn4{
           width:400px;   
           height:200px;   
           background:url(img/4.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
   #submit_btn5{
           width:400px;   
           height:200px;   
           background:url(img/5.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
   #submit_btn6{
           width:400px;   
           height:200px;   
           background:url(img/6.png) no-repeat center;   
           cursor:pointer;   
  /* 上面的代码是常规设置， 即：引入一个图片背景，设置在中心位置，大小和按钮的大小一致，以及鼠标指针为手型 */  
    
            display:block;   
            font-size:0;   
            line-height:0;   
            text-indent:-9999px;
            margin-top:50px;
            margin-left:50px;
  /* 上面的不用多问，四句一起拷贝就可以了，大概意思就是把value值设置为0像素，也就是肉眼无法看到，但却又是存在的（用$_POST['submit_btn'] 可以证明）*/  
  }  
  #left_one{
  width:500px; 
  height:250px;
  float: left;
  margin-top:50px
  }  
    #right_one{
  width:500px; 
  height:250px;
  float: right;
  margin-top:50px
  }  
    </style>
   
    
    
</head>
<body>
	<div class="main bg">
		<canvas id="html5_3d_animation"></canvas>
		<!-- 这是圆圈导航 -->
		<div class="radmenu">
			  <a href="#" class="show" draggable='false'>数据展示</a>
			<ul>
				<li>
			      <a href="index.jsp">首页</a>
			    </li>
			    <li>
			      <a href="TrafficImpression.jsp">关于我们</a>
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
						<li><a class="on">数据展示</a></li>
						<li><a href="TrafficImpression.jsp">关于我们</a></li>
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
			<div class="content">
<!-- 图1 -->
			<div id="left_one">
					<div class="box_title">新加坡爱彼迎好评前十的酒店的数据分析</div>
					<form action="test1" method="post">
	                <input type="submit" value="进入数据展示" id="submit_btn1"/>
                                        </form>
			</div>
<!-- 图2 -->			
			<div id="left_one">
					<div class="box_title">新加坡爱彼迎回头率前十的酒店的数据分析</div>
					<form action="test2" method="post">
	                <input type="submit" value="进入数据展示" id="submit_btn2"/>
                                        </form>
			</div>
<!-- 图3 -->			
			<div id="left_one">
					<div class="box_title">新加坡各地区酒店数量分析</div>
					<a id="submit_btn3" href="test3.jsp"></a>
		<!--  <object type='text/html' data='test3.jsp' id='submit_btn3'></object>-->
			</div>
<!-- 图4 -->
			<div id="left_one">
					<div class="box_title">新加坡地区各酒店位置分析</div>
					<a id="submit_btn4" href="test4.jsp"></a>
			</div>
<!-- 图5 -->
			<div id="left_one">
					<div class="box_title">新加坡中心地区酒店价格分析</div>
					<a id="submit_btn5" href="test5.jsp"></a>
			</div>
<!-- 图6 -->
			<div id="left_one">
					<div class="box_title">京珠高速 : 人群职业分布图表</div>
					<form action="test6" method="post">
	                <input type="submit" value="进入数据展示" id="submit_btn6"/>
                                        </form>
			</div>
	
			</div>
		</div>
	</div>
<!-- 导航栏实时显示时间 -->

    <script type="text/javascript">
$(function a(){
	$("#ch2_1").hide();
	$("#ch2_2").hide();
	$("#ch3_1").hide();
	$("#ch3_2").hide();
	$("#ch1_1").show();
	$("#ch1_2").show();

})
</script>
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

<script type="text/javascript">
$("#load1").click(function(){
	$("#ch1_1").show(1000);
	$("#ch1_2").show(1000);
	$("#ch2_1").hide(1000);
	$("#ch2_2").hide(1000);
	$("#ch3_1").hide(1000);
	$("#ch3_2").hide(1000);
})
</script>
<script type="text/javascript">
$("#load2").click(function(){
	$("#ch2_1").show(1000);
	$("#ch2_2").show(1000);
	$("#ch1_1").hide(1000);
	$("#ch1_2").hide(1000);
	$("#ch3_1").hide(1000);
	$("#ch3_2").hide(1000);
})
</script>
<script type="text/javascript">
$("#load3").click(function(){
	$("#ch3_1").show(1000);
	$("#ch3_2").show(1000);
	$("#ch1_1").hide(1000);
	$("#ch1_2").hide(1000);
	$("#ch2_1").hide(1000);
	$("#ch2_2").hide(1000);
})
</script>
<script>
  $(document).on("click",'button',function(){
	  $("button").each(function(n,value){
		  $(value).removeClass("trafbtn selected");
	  })
	  $(this).addClass("trafbtn selected")
  })
</script>

</body>
</html>