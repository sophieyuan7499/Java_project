var now_x,now_y,flag=false;
function setSelected(e) {
    if(flag==true){
      flag=false;
      return
    }
    else {
       var $currentItem=$('.radmenu>a');
        if (this.classList.contains("Selected")) {
          this.classList.remove("Selected");
          if (!this.parentNode.classList.contains("radmenu")) {
            this.parentNode.parentNode.parentNode.querySelector("a").classList.add("Selected")
          } else {
            this.classList.add("show");
          }
        } else {
          this.classList.add("Selected");
          if (!this.parentNode.classList.contains("radmenu")) {
            this.parentNode.parentNode.parentNode.querySelector("a").classList.remove("Selected")
          } else {
            this.classList.remove("show");
          }
        }
        if(($currentItem).hasClass('Selected')){
            $currentItem.css({
                'top':'calc(50% - 60px)',
                'left':'calc(50% - 60px)'
            }).parent().css('z-index',6);
        }
        else{
            $currentItem.animate({
                top:now_y,
                left:now_x
            }).parent().css('z-index','initial');
        }
    }
   
}
$(function(){
  var $buttons = $(".radmenu a");
  $buttons.click(setSelected);
  var $div = $(".radmenu>a");
  now_x=$div[0].offsetLeft+'px';
  now_y=$div[0].offsetTop+'px';
  $div.bind("mousedown",function(event){
    var $this=$(this);
    if($this.attr('class')=='show'){
      var window_width=$(window).width();
      var window_height=$(window).height();
      var offset_x = $(this)[0].offsetLeft;
      var offset_y = $(this)[0].offsetTop;
      var mouse_x = event.pageX;
      var mouse_y = event.pageY;
      $(document).bind("mousemove",function(ev){
        flag=true;
        var _x = ev.pageX - mouse_x;
        var _y = ev.pageY - mouse_y;
        temp_x=(offset_x + _x );
        temp_y=(offset_y + _y );
        if(temp_x<0)
          temp_x=0;
        else if((temp_x+$this.width())>window_width)
          temp_x=window_width-$this.width();
        else if(temp_y<0)
          temp_y=0;
        else if((temp_y+$this.height())>window_height)
          temp_y=window_height-$this.height();
        now_x = temp_x + "px";
        now_y = temp_y + "px";
        $div.css({
          'top':now_y,
          'left':now_x
        });
      });
    }
  });
  $(document).bind("mouseup",function(){
    $(this).unbind("mousemove");
  });
})
  

