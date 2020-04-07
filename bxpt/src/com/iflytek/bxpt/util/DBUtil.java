package com.iflytek.bxpt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//数据库资源管理工具
public class DBUtil {
	 private static Connection connection;
	 private static Statement statement;
	 private static PreparedStatement preparedStatement;
 
 
	 static {
			//加载驱动
			try {	
			Class.forName("com.mysql.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	 }
 //实例化数据库连接connection
	 public static Connection getConnection() {
		 try {
			 
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bxpt", "root", "1234");
		 }catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return connection;
	 }
	//实例化SQL执行语句statement
	 public static Statement getStatement() {
		 Connection connection=getConnection();
		 try {
			if(connection!=null) {
				statement=connection.createStatement();
			}
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		 return statement;
		 
	 }
	 //实例化SQL执行句柄preparedStatement
	 public static PreparedStatement getPreparedStatement(String sql) {
		 Connection connection=getConnection();
		 try {
			if(connection!=null) {
				preparedStatement=connection.prepareStatement(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		 return preparedStatement;
	 }
	 //关闭数据库连接资源
	 public static void closeDBResources() {
		 try {
			 if(preparedStatement != null && !preparedStatement.isClosed()) {
				//如果preparedStatement不为空，并且还未关闭
				 preparedStatement.close();
				}
				if(statement != null && !statement.isClosed()) {
				//如果statement不为空，并且还未关闭
					statement.close();
				}
				if(connection != null && !connection.isClosed()) {
				//如果connection不为空，并且还未关闭
					connection.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
	 }
}
