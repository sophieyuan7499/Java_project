package com.iflytek.bxpt.mapper;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iflytek.bxpt.mapper.AdminMapper;

public class AdminMapperTest {

	public static AdminMapper adminMapper;
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml",
				"spring-sercice.xml");
		this.adminMapper = context.getBean(AdminMapper.class);
	}

	@Test
	public void testQueryUserAll() {
		System.out.println(this.adminMapper.searchPasswsordByEmail("123@163.com"));
	}
	
}
