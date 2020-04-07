package test01;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/*
 * 使用Java连接数据库
 * 步骤：
 * 1.加载驱动
 * 2.获取数据库连接-------->升级JDBCUtil
 * 3.创建statement类用于执行sql语句
 * 4.执行sql语句，获取ResulSet
 * 5.关闭连接
 */
public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //加载驱动，完全限定名
			 conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project?characterEncoding=utf-8","root","123456");//url地址(固定的)、账号、密码
			 stat=(Statement) conn.createStatement();
			String sql="SELECT * FROM product p WHERE p.id=3";
			ResultSet rs=stat.executeQuery(sql);//获取结果集ResultSet类（迭代器）executeQuery方法
			if(rs.next()) {
				System.out.println(rs.getString("productName"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();//关闭资源
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
