<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<title>日统计</title>
</head>
<body>
<button id="btn">查询 </button>
<div id="main" style="width: 900px;height:500px;"></div>
<script type="text/javascript">
$(function(){
	var charts1 = echarts.init(document.getElementById('main'))
	option = {
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			    },
			    yAxis: {
			        type: 'value',
			        boundaryGap: [0, '30%']
			    },
			    dataZoom:[{
			    	type: 'slider',//图表下方的伸缩条
			    	show : true, //是否显示
			    	realtime : true, //拖动时，是否实时更新系列的视图
					}],
			    visualMap: {
			        type: 'piecewise',
			        show: false,
			        dimension: 0,
			        seriesIndex: 0,
			        
			    },
			    tooltip:{
					trigger:'axis',
					formatter:function(params){
						console.log(params[0]);
						 for(x in params){
							 return params[x].name +"："+params[x].data[1]
						 }
						
					}
					},
			    series: [
			        {
			            type: 'line',
			            smooth: 0.6,
			            symbol: 'none',
			            lineStyle: {
			                color: '#A52A2A',
			                width: 5
			            },
			            
			            areaStyle: {},
			            data: [ ]
			        }
			    ]
			};
	charts1.setOption(option);
	
	var datas=[];
	$("#btn").click(function(){
		
		$.ajax({	
			type:"post",
			url:"countbyday",
			async:false,
			success:function(data){   //data为一个字符串
				
				//对数据进行处理
				//将其转化为对象
				var arr = eval("("+data+")");
			$.each(arr,function(countByDay,item){
				var day = item.date;
				var num = item.num;
				
				datas.push([
					day, num
]);
				
			}); //循环遍历
			charts1.setOption({ series:[ {data :datas } ]});
			}
		});
	});
	

});
</script>
</body>
</html>