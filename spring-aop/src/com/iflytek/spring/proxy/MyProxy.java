package com.iflytek.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyProxy<T> implements InvocationHandler{
private T target;//���������
	public MyProxy(T t) {//�ص�����
		target=t;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object object=method.invoke(target, args);

		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.printf("���ѧ����Ϣ�ɹ��������ߣ�%s ��ʱ�䣺%s\n","����",format.format(date));
		return object;
	}

}
