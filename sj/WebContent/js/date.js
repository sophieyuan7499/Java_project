Date.prototype.format = function (fmt) { //年/月/日，返回字符串
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "D+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(Y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//获得星期几
Date.prototype.getWeek = function() {//返回字符串
    var week = this.getDay();
    switch(week) {
        case 0:
            return "星期日";
            break;
        case 1:
            return "星期一";
            break;
        case 2:
            return "星期二";
            break;
        case 3:
            return "星期三";
            break;
        case 4:
            return "星期四";
            break;
        case 5:
            return "星期五";
            break;
        case 6:
            return "星期六";
            break;
    }// end switch
};

//获得如下时间格式，hh:mm:ss
Date.prototype.getNowTime = function() {
    var hours = this.getHours();
    var minutes = this.getMinutes();
    var seconds = this.getSeconds();
    hours = hours<10? ("0"+hours): hours;
    minutes = minutes<10? ("0"+minutes): minutes;
    seconds = seconds<10? ("0"+seconds): seconds;
    return (hours + ":" + minutes + ":" + seconds); //返回字符串
};

//时间更新函数
Date.prototype.update = function(type) {//更新时间
    var date = new Date();
    var result;//最新结果
    switch(type) {
        case "YYYY-MM-DD"://2017-01-23
            result = date.format(type);
            break;
        case "week"://星期几
            result = date.getWeek();
            break;
        case "nowTime": //23:22:22
            result = date.getNowTime();
            break;
    }
    date = null;
    return result;
};