$(function(){
	//点击a标签的时候，希望获取正确的pageIndex
	$(".chooseIt").click(function(){
		//判断点击的是哪一个a标签
		var id = $(this).attr("id");
		var pageIndex = $("#pageIndex").val();
		var pageCount = $("#pageCount").val();
		pageIndex = parseFloat(pageIndex);
		pageCount = parseFloat(pageCount);
		
		if(id == "frist"){
			pageIndex = 1;
		}else if(id == "previous"){
			if(pageIndex == 1){
				return false;
			}else{
				pageIndex = pageIndex - 1;
			}
		}else if(id == "next"){
			if(pageIndex == pageCount){
				return false;
			}else{
				pageIndex = pageIndex + 1;
			}
		}else{
			pageIndex = pageCount;
		}
		
		alert(pageIndex);
		$("#pageIndex").val(pageIndex);
		//使用a标签控制表单提交
		$("#form").submit();
		return false;
	});
});