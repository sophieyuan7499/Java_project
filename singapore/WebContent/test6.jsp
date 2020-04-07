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
table {       
                width: 90%;
				margin: 5px auto;
                rgba(0,0,0,0);
				border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/	
			}					
			th,td {
			     height: 24px;
				line-height: 24px;
				text-align: center;
				border: 3px solid #ccc;
			}		
			th {
			    background: #2F4F4F ;	
				color:white;
				font-weight: normal;
	
			}		
			tr {
			
			}	
			tr:hover {
				background: #00FFFF;
				/*background:#FBFBFF;*/
			}		
			td a {
				text-decoration: none;
			}		
			td a:hover {
				
				color:#FBFBFF;
				text-decoration: underline;
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
			<div class="content" >
			<div id="ditu" style="width: 650px; height: 600px;margin-left:1px; float: left;margin-top:50px;"></div>
			<div style="width: 800px;height:400px;margin-top:60px;float: right;">  
			 <table>
	             <tr>
	                   <th>位于地区</th>
	                   <th>酒店名称</th>
	                   <th>酒店入住价格</th>
                       <th>酒店房型</th>
	                   <th>酒店好评数</th>
	             </tr>
	<c:forEach items="${hotel2List }"  var="item"  >
		         <tr>
                       <td>${item.neigh}</td>
	                   <td>${item.name}</td>
	                   <td>${item.price}</td>
	                   <td>${item.room_type }</td>
	                   <td>${item.comments}</td>
	  	         </tr>
	                   </c:forEach>


	        </table>	
			 </div>
		<script>
			
	var charts = echarts.init(document.getElementById('ditu'));
	var option = {
    title: {
        text: '酒店雷达图',
        textStyle : {
  			 color : '#FBFBFF',
  			 fontStyle : 'italic',
                },
    },
    
    tooltip: {},
    legend: {
        data: ['人口数（Population size）', '实际开销（Actual Spending）'],
        textStyle:{
        	color:'#F5FFFA',
        	fontWeight:'300',
        },
        
    },
    radar: {
        // shape: 'circle',
        name: {
            textStyle: {
                color: '#F8F8FF',
                backgroundColor: '#6495ED',
                borderRadius: 3,
                padding: [3, 5],
                borderWidth:"10px"
            }
        },
       
        axisLine:{
        	lineStyle:{
        		 color:'#FFFFFF',   //坐标轴线线的颜色。
        	},
        },
        indicator: [
         
            
            {name:'North East Region',max:830000 },
			{name:'North West Region',max:1300000},
			{name:'South West Region',max:830000},
			 {name:'South East Region',max:840000},
			{name:'Central Region',max:1200000}
        ]
    },
    series: [{
        name: '人口数  and 开销（size and spending）',
        type: 'radar',
        // areaStyle: {normal: {}},
        data: [
            {
                value: [430000, 1000000, 800000, 770000,1100000],
                name: '人口数（Population size）',
                itemStyle:{
                	normal:{
                		color:'rgba(255,255,0,3)',
                		lineStyle:{
                			color:'rgba{255,255,0,3}',
                		},
                	},
                },
                
            },
            {
                value: [650000, 1240000, 640000, 800000,1000000],
                name: '实际开销（Actual Spending）'
            }
        ]
    }]
};

charts.setOption(option);
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