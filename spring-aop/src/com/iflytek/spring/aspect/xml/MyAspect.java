package com.iflytek.spring.aspect.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

/*
 * ������
 */

public class MyAspect {
public void log(JoinPoint point) {
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//point.getSignature().getName() ��ȡ����㷽����
	System.out.println("������������ʱ�䣺"+ format.format(date)+"��������"+point.getSignature().getName() );
}
}
