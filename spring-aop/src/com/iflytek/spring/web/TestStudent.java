package com.iflytek.spring.web;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iflytek.spring.entity.Student;
import com.iflytek.spring.proxy.MyProxy;
import com.iflytek.spring.service.StudentService;

public class TestStudent {

	public static void main(String[] args) {
		//��ȡspring�����Ķ���
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-web.xml");
		//ͨ��spring������ȡ�����д�ŵ�ѧ���������ѧ������
		StudentService stuService = ctx.getBean("studentServiceBean", StudentService.class);
		Student stu = ctx.getBean("studentBean", Student.class);
		//���÷��������ѧ��
		stuService.addStudent(stu);
		stuService.deleteStudent(stu);
		stuService.updateStudent(stu);
System.out.println("=========================================");
	InvocationHandler handler=new MyProxy<StudentService>(stuService);
	StudentService studentServiceProxy=(StudentService) Proxy.newProxyInstance(StudentService.class.getClassLoader(),
			new Class[ ] {StudentService.class}, handler);
	stuService.addStudent(stu);
	}

}
