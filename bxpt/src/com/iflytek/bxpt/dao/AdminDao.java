package com.iflytek.bxpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iflytek.bxpt.po.Admin;
import com.iflytek.bxpt.util.DBUtil;

public class AdminDao {
public  boolean isExists(String username,String password) {
	//判断指定的账号或者密码是否存在
	boolean isExists=false;
	String sql="select * from User_tb where username=? and password=?";
	PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
	try {
		preparedStatement.setString(1,username);
		preparedStatement.setString(2,password);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			isExists=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();// TODO: handle exception
	}finally {
		DBUtil.closeDBResources();
	}
	return isExists;
}
public Admin searchPasswsordByEmail(String email) {
	Admin admin=null;
	String sql="select username,password,email from User_tb where email=? ";
	//根据邮箱来查询用户名和密码
	PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
	try {
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			String username=resultSet.getString("username");
			String password=resultSet.getString("password");
			admin=new Admin(username,password,email);
		}
		resultSet.close();
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		DBUtil.closeDBResources();
	}
	return admin;
}
}
