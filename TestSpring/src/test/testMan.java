package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hello.Person;
import hello.classB;

public class testMan {
public static void main(String[] args) {
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	Person  person=(Person) act.getBean("p");
	person.say();
	classB b1=(classB) act.getBean("clb");//“¿¿µ◊¢»Î
	System.out.println(b1);
	}
}
