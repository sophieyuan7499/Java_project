package com.iflytek.bxpt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Datetimes {

public String getnow(String rtime) {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	rtime=df.format(new Date());	//获取当前日期
	return rtime;
}

}
