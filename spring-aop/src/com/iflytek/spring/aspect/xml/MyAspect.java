package com.iflytek.spring.aspect.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

/*
 * 切面类
 */

public class MyAspect {
public void log(JoinPoint point) {
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//point.getSignature().getName() 获取接入点方法名
	System.out.println("张三操作方法时间："+ format.format(date)+"方法名："+point.getSignature().getName() );
}
}
