package dbUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


/*
 * DBUtils:对获取statement、执行SQL、获取ResultSet进行封装
 * 
 * 查询功能：
 * 
 * ResultSetHandler：结果集处理器
 * 
 * BeanHandler：将结果集封装为一个对象
 * 
 * BeanListHandler：将结果集封装为一个集合
 * 
 */
public class DBUtils {
private QueryRunner runner=new QueryRunner(JdbcUtil2.getDataSource());
//注册
	public void addUser(User u) {
		String sql="insert into user values(?,?,?,?,?)";
		Object[]  param= {null,u.getAccount(),u.getPsw(),u.getMoney(),u.getName()};
		try {
			runner.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public User getUser(String account,String psw) {
		String sql ="select * from user where account=? and psw=?";
		Object [] params= {account,psw};
		User user=null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	
	
	public List<User> getAllUser() {
		String sql="select *from user";
		
		List<User> user = null;
		try {
			user =  runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	
	
	public Long getUserCount() {
		String sql="select count(*) from user";
		Long a=null;
		try {
		  a=runner.query(sql,  new ScalarHandler<Long>());//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//注意整数应使用Long，int类型不接收
		return a;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//User user=new User("123","123",10000,"xurong");
		DBUtils dbUtils=new DBUtils();
		//dbUtils.addUser(user);
		/*User user2=dbUtils.getUser("test003", "003");
		if(user2!=null) {
			System.out.println(user2);
		}else {
			System.out.println("账号或密码错误");
		}
		*/
		System.out.println(dbUtils.getUserCount());
	}
}
