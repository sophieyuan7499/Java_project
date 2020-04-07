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
		//获取spring上下文对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-web.xml");
		//通过spring容器获取容器中存放的学生服务类和学生对象
		StudentService stuService = ctx.getBean("studentServiceBean", StudentService.class);
		Student stu = ctx.getBean("studentBean", Student.class);
		//调用服务类添加学生
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
