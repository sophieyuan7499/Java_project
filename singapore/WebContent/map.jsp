<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="js/echarts.min.js"></script> 
		<script type="text/javascript" src="js/Singapore.js"></script> 
		
<meta charset="UTF-8">
<title>地图</title>
</head>
<body>
<div id="map-wrap" style="height: 700px;">
				<!-- 这里以后是地图 -->
				</div>
				<button id="btn">地图</button>
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
							url:"map",
							async:false,
							success:function(data) {
								var arr=eval("("+data+")");
								$.each(arr,function(map,item){
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
		
		
</body>
</html>