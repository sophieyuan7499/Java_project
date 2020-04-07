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
			</div>
			 <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('main'));

      var arr = new Array();
      var index = 0;
      <c:forEach items="${HostnameLst}" var="host">
          arr[index++] = "${host.comments}";
      </c:forEach>

      // 指定图表的配置项和数据
      var option = {
    	color: ['#3398DB'],
          title: {
              text: '新加坡地区爱彼迎好评最高的十个酒店',
              textStyle : {
			  color : '#FBFBFF',
			   fontStyle : 'italic',
              },
          },
          toolbox:{              //工具栏。内置有导出图片，数据视图，动态类型切换，数据区域缩放，重置五个工具。
				feature:{          //各工具配置项。
				   saveAsImage:{
					   type:'png',
					   title:'保存图片',
				   },
				   restore:{
					   show:true,
				   },
				   dataView:{
						 show:true,
						 title:'数据视图工具',
					},
				   dataZoom:{
					    show:true,
				   },
				   magicType:{
					   type:['line','bar','stack','tiled'],
				   },
				},
				iconStyle:{
				    borderColor:'#F0F8FF',
				    borderWidth:'2',
				},
			},
			tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        },
		    },
		    dataZoom:[       //dataZoom 组件 用于区域缩放，从而能自由关注细节的数据信息，或者概览数据整体，或者去除离群点的影响。
		    	{
		    		type:'slider',                 //滑动条型数据区域缩放组件（dataZoomSlider）
		    		orient:'horizontal',                 //布局方式：水平方式
		    	}
		    ],
          xAxis : [
              {
            	  name:'酒店',
            	  nameTextStyle:{            //name的相关设置。
            		  color:'#FBFBFF',
            		  fontFamily:'KaiTi',
            		  fontSize:'20',
            		  fontWeight:'400',
            	  },
            	  
            	  axisLabel:{                  //坐标轴刻度标签的相关设置。
            			    color:'#FBFBFF', 		    
            	  },
            	  splitNumber:'10',
                  type : 'category',
                  data : [
                      <c:forEach items="${HostnameLst}" var="g">
                      ["${g.host_name}"],
                      </c:forEach>
                  ],
                  
              axisTick: {
		             alignWithLabel: true
		            },
              }
          ],
          yAxis : [
              {
                  type : 'value',
                	min:250,
  					max:330,
  					name:'评论数',
  					 nameTextStyle:{
  	            		  color:'#FBFBFF',
  	            		  fontFamily:'KaiTi',
  	            		  fontSize:'20',
  	            		  fontWeight:'400',
  	            	  },
  	            	axisLabel:{                  //坐标轴刻度标签的相关设置。
        			    color:'#FBFBFF', 		    
        	  },
  					splitNumber:12,
                  
              }
          ],
          series : [
              {
                  name:'评论数',
                  type:'bar',
                  data: arr,
                  barWidth: '50%',
                  itemStyle: {
  	                color: new echarts.graphic.LinearGradient(
  	                    0, 0, 0, 1,
  	                    [
  	                        {offset: 0, color: '#83bff6'},
  	                        {offset: 0.5, color: '#188df0'},
  	                        {offset: 1, color: '#188df0'}
  	                    ]
  	                )
  	            },
  	            emphasis: {
  	                itemStyle: {
  	                    color: new echarts.graphic.LinearGradient(
  	                        0, 0, 0, 1,
  	                        [
  	                            {offset: 0, color: '#2378f7'},
  	                            {offset: 0.7, color: '#2378f7'},
  	                            {offset: 1, color: '#83bff6'}
  	                        ]
  	                    )
  	                }
  	            },
              }
          ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>
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