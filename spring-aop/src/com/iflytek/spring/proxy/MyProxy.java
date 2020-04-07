package com.iflytek.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyProxy<T> implements InvocationHandler{
private T target;//被代理对象
	public MyProxy(T t) {//回调方法
		target=t;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object object=method.invoke(target, args);

		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.printf("添加学生信息成功，操作者：%s ，时间：%s\n","张三",format.format(date));
		return object;
	}

}
