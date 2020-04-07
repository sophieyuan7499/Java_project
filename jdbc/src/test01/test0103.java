package test01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test0103 {
	private static Connection conn;
	private static Statement stat;
	private static PreparedStatement ps;
		
	public static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project?characterEncoding=utf-8", "root", "123456");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test0103 d = new test0103();
		init();
		//d.login1("' or 1=1 or '", "123");
		d.login2("10002", "111111");
	}
	
	public void login1(String account,String psw) {
		try {
			String sql = "select * from user where account = '"+account +"' and psw = '"+ psw+"'";
			System.out.println(sql);
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				System.out.println("»¶Ó­µÇÂ½£¡"+rs.getString("name"));
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login2(String account,String psw) {
		try {
			System.out.println(conn);
			String sql = "select * from user where account = ? and psw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, psw);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {	
				System.out.println("»¶Ó­µÇÂ½£¡"+rs.getString("name"));
			}else {
				System.out.println("ÕËºÅÃÜÂëÓÐÎó!");
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
