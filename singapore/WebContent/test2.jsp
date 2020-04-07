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
<style type="text/css">
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
				border: 2px solid #ccc;
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
			<div id="main" style="width: 600px;height:320px;margin-left:30px;margin-top:50px;float: left;"></div>
			 <div id="main2" style="width: 650px;height:320px;margin-right:80px;margin-top:50px;float: right;"></div>
			<div style="width: 1200px;height:300px;margin-top:10px;margin-left:50px;">
			<table>	<tr>
	                  <th>酒店名称</th>
	                  <th>具体地区</th>
	                  <th>酒店评论数</th>
	                  <th>酒店入住价格</th>
	                  <th>回头率</th>
	
	                </tr>
	
	             <c:forEach items="${requestScope.hotelsList }"  var="item"  >
	
	                <tr>
	                  <td>${item.name}</td>
	                  <td>${item.neigh}</td>
	                  <td>${item.comments}</td>
	                  <td>${item.price}</td>
	                  <td>${item.reviews_per_month}</td>
	
	                </tr>
	                              </c:forEach>
	                 </table>
			</div>
		
			</div>
			 <script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	
	var arr=new Array();
	var index =0;
	<c:forEach items="${requestScope.hotelsList}" var="g">
    arr[index++] = "${g.price}";
</c:forEach>


	var option ={
			
			tooltip:{
				 trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        },
			},
	    title: {
        //left: 'center',
        text: '回头率高的酒店价格图',
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
		xAxis:{
			// type: 'category',
			 name:'酒店名称',
			 data: [
	              //  "Homestay","A","B","C","D","E","F","G","H","I"
				 <c:forEach items="${requestScope.hotelsList}" var="g">
                 ["${g.name}"],
             </c:forEach>
	            ],
		
		 nameTextStyle:{
     		  color:'#FBFBFF',
     		  fontFamily:'KaiTi',
     		  fontSize:'20',
     		  fontWeight:'400',
     	  },
     	axisLabel:{                  //坐标轴刻度标签的相关设置。
		    color:'#FBFBFF', 		    
 },
		},
		yAxis:{
			type:'value',
			min:0,
			max:100,
			name:'价格',
			splitNumber:10,
			 nameTextStyle:{
         		  color:'#FBFBFF',
         		  fontFamily:'KaiTi',
         		  fontSize:'20',
         		  fontWeight:'400',
         	  },
         	axisLabel:{                  //坐标轴刻度标签的相关设置。
			    color:'#FBFBFF', 		    
	  },
		},
		series:[
			{
				name:'酒店入住价格',
				type:'line',
				data:arr,
				smooth: true,
		        showAllSymbol: true,
		        symbol: 'emptyCircle',
		        symbolSize: 15,
				
					
			},{
				name: 'line',
		        type: 'bar',
		        barGap: '-100%',
		        barWidth: 10,
		        itemStyle: {
		            color: new echarts.graphic.LinearGradient(
		                0, 0, 0, 1,
		                [
		                    {offset: 0, color: 'rgba(0,255,255,0.9)'},
		                    {offset: 0.2, color: 'rgba(0,255,255,0.5)'},
		                    {offset: 1, color: 'rgba(0,255,255,0)'}
		                ]
		            )
		        },
		        z: -12,
		        data: arr
			}
		]
		
	};
	 myChart.setOption(option);
 </script>
	
	<script type="text/javascript">
         var myChart2 = echarts.init(document.getElementById('main2'));
         var datas =[];
         var arr,area;

      <c:forEach items="${requestScope.hotelsList}" var="g">
          area = "${g.neigh}";
          arr = "${g.reviews_per_month}";

      datas.push({
	       "name": area,	"value":arr
	
    });
       </c:forEach>


    console.log(datas);

var option ={
		title:{
			left:'right',
		 text:'酒店回头率集中地区扇形图',
		 textStyle : {
 			  color : '#FBFBFF',
 			   fontStyle : 'italic',
               },
		},
	  //  backgroundColor: '#404a59',
	    legend:{
	    	top:'80%',
	    	left:'left',
	    	data:datas.name,
	    	orient:'vertical'
	    },
		tooltip:{},//提示框
		// 饼图的标签的视觉引导线的颜色设置为浅色
		labelLine:{
		    	
		    normal:
		    {
		    	lineStyle:{
		    		color:'rgba(255, 255, 255, 0.3)'
		    	}
		    }
		},
		itemStyle:{
			emphasis:{
			   	// 阴影的大小
                 shadowBlur: 200,
                 // 阴影颜色
                 shadowColor: 'rgba(0, 0, 0, 0.5)'
			   }
		},
		visualmap:[{
			hoverLink:true
		}],
		series:[
		{
			name:'访问来源',
			type:'pie',
			//center:['60%','40%'],
			radius:['40%','75%'],//饼图半径

		    data:datas
		}
		]

	};
myChart2.setOption(option);
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