package bbs.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bbs.dao.UserDao;
import bbs.model.User;
import bbs.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
	@Override
	public User getUserByAccAndPsw(String account, String psw) {
		String sql="select * from user where account=? and psw=?";
		Object[] params= {account,psw};
		User u=null;
		try {
			u=(User) runner.query(sql, new BeanHandler<User>(User.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void updatePsw(int id, String psw) {
		String sql="update user set psw=? where id=?";
		Object[] params= {psw,id};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUser(User u) {
		String sql="insert into user value(?,?,?,?,?)";
		Object[] params= {u.getId(),u.getAccount(),u.getPsw(),u.getName(),u.getEmail()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		UserDao ud=new UserDaoImpl();
//		User u=new User();
////		u.setId(1);
////		u.setAccount("test001");
////		u.setPsw("123");
////		u.setName("xiaohong");
////		u.setEmail("123");
////		ud.addUser(u);
//		
////		u.setId(2);
////		u.setAccount("test002");
////		u.setPsw("122");
////		u.setName("xiaolv");
////		u.setEmail("123");
////		ud.addUser(u);
//		
////		ud.updatePsw(2, "123");
//		
//		
//	if(ud.getUserByAccAndPsw("test001", "123")!=null) {
//		System.out.println(ud);
//	}else {
//		System.out.println("账号或密码不正确");
//	}
//		
//	}
}
