<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/USA.js"></script>
<title>地图</title>
</head>
<body>
<button id="btn">查询 </button>
<div id="main" style="width: 900px;height:500px;"></div>
<script type="text/javascript">
$(function(){
var mapChart = echarts.init(document.getElementById('main'));

var option = {
		geo: {
	      	map: '美国'
	  	},
	  	tooltip:{
			trigger:'item',
			formatter:function(params){
				 
					 return "死伤人数共："+params.data[2]
				 
				
			}
			},
		series:[
		{
			type:'scatter',
			coordinateSystem:'geo',
			symbol:'circle',
			symbolSize:function(val){
				return val[2]/2;
			},		
			data:[]
		}
		]
	};
	
mapChart.setOption(option);
var datas=[];
$("#btn").click(function(){
	$.ajax({
		type:"post",
		url:"map",
		async:false,
		success:function(data) {
			var arr=eval("("+data+")");
			$.each(arr,function(map,item){
				var longitude=item.longitude;
				var latitude=item.latitude;
				var injuredandkilled=item.injuredandkilled;
				datas.push([longitude,latitude,injuredandkilled]);
			});
			mapChart.setOption({	series:[{data:datas	}]	});
		}
		
	});
});
});




</script>
</body>
</html>