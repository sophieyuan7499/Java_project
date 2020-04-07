var NAV = function(){
	var _init = function(){
		$(".sub-menu").eq(0).show();
		
		$(".page-sidebar-menu > li > a").click(function(event){
			event.preventDefault();
			if($(this).find(".arrow").hasClass("open")) {
				$(this).find(".arrow").removeClass("open");	
				$(this).next().hide(500);
			}else {
				$(this).find(".arrow").addClass("open");	
				$(this).next().show(500);
			}
		});
	}
	
	var _loadFrame = function(){
		$("#mainFrame").load(function(){
			$(this).height($(window).height() - 96);
		});
	}
	return {
		init : function(){
			_init();
			_loadFrame();
		}
	}
}();
