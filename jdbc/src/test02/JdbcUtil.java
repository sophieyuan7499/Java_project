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
 * �����ࣺר�����ڼ�����������ȡ���ӡ��ر�����
 */
public class JdbcUtil {
	
	static String driverClass;
	static String url;
	static String user;
	static String psw;
	static {
	
		//��ȡ�����ļ��е�ֵ
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("src//jdbc.properties")));
			//load����Ϊ������ȡ������ݱ�����p��

			driverClass=(String)p.get("driverClass");//��ȡ��ֵ��.propertiese�ļ��б����ֵ��
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

