$(function(){
	//高度获取
	var hearderH=$(".header").height();
	var mainH=$(".main").height();

	$(".content").height(mainH-hearderH);
	$(".box").height((mainH-hearderH-140)*0.5);

	var boxW=$(".box").width();
	var boxH=$(".box").height();
	console.log("boxW---->"+boxW);
	console.log("boxH---->"+boxH);
	var animationW = boxW+24*2+12*2;
	var animationH = boxH+12*2;
	console.log("animationW----->"+animationW);
	console.log("animationH----->"+animationH)
    
    //var styleString = "@keyframes lineB{0%,100%{clip:rect("+(animationH-10)+"px,"+"auto"+","+("auto")+","+0+")} 45%{clip:rect("+0+","+"auto"+","+"auto"+","+(animationW-15)+"px)}}";
    //var styleString = "@keyframes lineB{0%{clip:rect("+(animationH-30)+"px,"+"auto"+","+(animationH-4)+"px,"+0+")} 25%{clip:rect("+(animationH-30)+"px,"+"auto"+","+(animationH-4)+"px,"+(animationW-20)+"px)} 50%{clip:rect("+0+","+"auto"+","+(animationH-4)+"px,"+(animationW-20)+"px)} 75%{clip:rect("+(animationH-30)+"px,"+"auto"+","+(animationH-4)+"px,"+(animationW-20)+"px)} 100%{clip:rect("+(animationH-30)+"px,"+"auto"+","+(animationH-4)+"px,"+0+")}}";
    //var styleString = "@keyframes lineB{0%,100%{clip:rect("+(animationH-5)+"px,"+"auto"+","+("auto")+","+0+")} 45%{clip:rect("+0+","+"auto"+","+"auto"+","+0+")}}";
    var styleString = "@keyframes lineB{0%,100%{clip:rect("+(animationH-35)+"px,"+(animationW+300)+"px,"+"auto"+","+0+")} 45%{clip:rect("+0+","+(animationW+300)+"px,"+"auto"+","+(animationW-10)+"px)}}";

	$('style').append(styleString);

	$(".lr").height((mainH-hearderH-140)*0.5-48);
	$(".box_main").height((mainH-hearderH-140)*0.6-88);
	//$(".box_main canvas").css('height','3);
	$(".web_pannel_ul li").height(((mainH-hearderH-140)*0.5-88)/3);
	//map height
	// $("#map_box").height((mainH-hearderH)*0.55-30);
	$("#map_box").height(mainH-hearderH);
	$(".kpiChart").height((mainH-hearderH)*0.45-120);
	//响应式获取
	$(window).resize(function(){
		//高度获取
		var hearderH=$(".header").height();
		var mainH=$(".main").height();

		$(".content").height(mainH-hearderH);

        var mainHT = (mainH-hearderH-140)*0.5;
		mainHT < 233.5? 233.5: mainHT;
		$(".box").height(mainHT);

		boxW=$(".box").width();
		boxH=$(".box").height();
		animationW = boxW+24*2+12*2;
		animationH = boxH+12*2;
        styleString = "@keyframes lineB{0%,100%{clip:rect("+(animationH-35)+"px,"+(animationW+300)+"px,"+"auto"+","+0+")} 45%{clip:rect("+0+","+(animationW+300)+"px,"+"auto"+","+(animationW-10)+"px)}}";

        $('style').append(styleString);

		$(".lr").height((mainH-hearderH-140)*0.5-48);
		$(".box_main").height((mainH-hearderH-140)*0.5-88);
		$(".web_pannel_ul li").height(((mainH-hearderH-140)*0.5-88)/3);
		//map height
		$(".map_box").height((mainH-hearderH)*0.55-40);
		$(".kpiChart").height((mainH-hearderH)*0.45-120);
	});
});

