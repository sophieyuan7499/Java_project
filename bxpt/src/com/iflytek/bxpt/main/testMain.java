package com.iflytek.bxpt.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.iflytek.bxpt.po.Admin;

public class testMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String path="src/mybatis-config.xml";
		
		InputStream inputStream=new FileInputStream(new File(path));
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session=factory.openSession();//获取数据库连接的session
		Admin admin=session.selectOne("AdminDao1.searchPasswsordByEmail","123@169.com");
		System.out.println(admin);
	}

}
