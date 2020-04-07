package bbs.dao.ipml;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bbs.dao.UserDao;
import bbs.model.user;
import bbs.util.JdbcUtil2;

public class UserDaoImpl implements UserDao{
	QueryRunner runner=new QueryRunner(JdbcUtil2.getDataSource());
	
	public user getUser(String account, String psw) {
		// TODO Auto-generated method stub
		String sql="select * from user where account=? and psw=?";
		Object[] param= {account,psw};
		user u=null;
		try {
			u=runner.query(sql,new BeanHandler<user>(user.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return u;
	}

	@Override
	public void updatepsw(int id, String psw) {
		// TODO Auto-generated method stub
		String sql="update user set psw=? where id=?";
		Object[] params= {psw,id};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void adduser(user u) {
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?,?)";
		Object[] params= {null,u.getAccount(),u.getPsw(),u.getName(),u.getEmail()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO A uto-generated catch block
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		UserDaoImpl ud=new UserDaoImpl();
		user u=new user();
		u.setAccount("111");
		u.setPsw("111");
		u.setName("yuan");
		u.setEmail("7499@qq.com");
		//ud.adduser(u);
		ud.updatepsw(7, "111");
}*/
}
