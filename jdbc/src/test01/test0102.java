package test01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test0102 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project?characterEncoding=utf-8", "root", "123456");
			String sql = "INSERT INTO product VALUES (NULL,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//(NULL,'话梅糖',2,5.8,'李明','华亨',0.85,5)
			ps.setString(1, "微波炉");
			ps.setInt(2, 1);
			ps.setFloat(3, 700);
			ps.setString(4, "王小二");
			ps.setString(5, "格力");
			ps.setFloat(6, (float) 0.85);
			ps.setFloat(7,300);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
