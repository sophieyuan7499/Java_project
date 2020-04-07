$(function(){
	$(".chooseIt").click(function(){
		//弹出pageIndex
		var pageIndexStr = $("#pageIndex").val();
		var pageCountStr = $("#pageCount").val();
		
		var pageIndex = parseFloat(pageIndexStr);
		var pageCount = parseFloat(pageCountStr);
		
		var id = $(this).attr("id");
		
		if(id == "frist"){
			pageIndex = 1;
			alert(pageIndex);
		}else if(id == "previous"){
			if(pageIndex == 1){
				return false;
			}else{
				pageIndex -=1;
			}
			alert(pageIndex);
		}else if(id == "next"){
			//如果已经是最后一页
			if(pageIndex == pageCount){
				return false;
			}else{
				pageIndex +=1;
			}
			alert(pageIndex);
		}else{
			pageIndex = pageCount;
			alert(pageIndex);
		}
		//更改后的pageIndex  要反传回页面
		$("#pageIndex").val(pageIndex);
		$("#form").submit();//提交表单
		
		return false;
	});
});