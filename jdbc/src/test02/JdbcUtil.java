package test02;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/* 
 * 工具类：专门用于加载驱动、获取链接、关闭链接
 */
public class JdbcUtil {
	
	static String driverClass;
	static String url;
	static String user;
	static String psw;
	static {
	
		//读取属性文件中的值
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("src//jdbc.properties")));
			//load参数为流，读取后的内容保存在p中

			driverClass=(String)p.get("driverClass");//获取键值，.propertiese文件中保存键值对
			url=(String)p.get("url");
			user=(String)p.get("user");
			psw=(String)p.get("psw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() {
		Connection connection=null;
try {
	connection=(Connection) DriverManager.getConnection(url, user, psw);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				return connection;
	}

	
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(conn!=null) {
			conn.close();
			}
			if(ps!=null) {
			ps.close();
			}
			if(rs!=null) {
			rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

