package test02;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test0202 {
	public static void main(String[] args) {
		Connection conn=JdbcUtil.getConnection();
		
		String sql = "INSERT INTO product VALUES (NULL,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		//(NULL,'��÷��',2,5.8,'����','����',0.85,5)
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, "����");
				ps.setInt(2, 1);
				ps.setFloat(3, 2000);
				ps.setString(4, "��С��");
				ps.setString(5, "����");
				ps.setFloat(6, (float) 0.85);
				ps.setFloat(7,1700);
				
				ps.executeUpdate();	
				JdbcUtil.close(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
}