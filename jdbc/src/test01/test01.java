package test01;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/*
 * ʹ��Java�������ݿ�
 * ���裺
 * 1.��������
 * 2.��ȡ���ݿ�����-------->����JDBCUtil
 * 3.����statement������ִ��sql���
 * 4.ִ��sql��䣬��ȡResulSet
 * 5.�ر�����
 */
public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //������������ȫ�޶���
			 conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project?characterEncoding=utf-8","root","123456");//url��ַ(�̶���)���˺š�����
			 stat=(Statement) conn.createStatement();
			String sql="SELECT * FROM product p WHERE p.id=3";
			ResultSet rs=stat.executeQuery(sql);//��ȡ�����ResultSet�ࣨ��������executeQuery����
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
				stat.close();//�ر���Դ
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
