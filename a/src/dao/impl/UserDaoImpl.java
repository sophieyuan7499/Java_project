package  dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import  dao.UserDao;
import  model.User;
import  util.JdbcUtil;


public class UserDaoImpl implements UserDao{
	private QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());   

	@Override
	//µÇÂ½
	public User getUserByAccAndPsw(String account, String psw) {
		// TODO Auto-generated method stub
		String sql="select * from user where account =? and psw=?";
		Object [] params= {account,psw};
		User user=null;
		try {
			user=runner.query(sql, new BeanHandler<User>(User.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//ÐÞ¸ÄÃÜÂë
	@Override
	public void updatePsw(int account, String psw) {
		// TODO Auto-generated method stub
		//System.out.println(account+"  "+psw);
		String sql="update user set psw=? where account=?";
		Object [] params= {psw,account};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	//×¢²á
	public void addUser(User u) {
		// TODO Auto-generated method stub
	String sql="insert into user(account,psw,email,name) values(?,?,?,?)";
		Object []params= {u.getAccount(),u.getPsw(),u.getEmail(),u.getName()};
		
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		User user=new User();
		user.setAccount("004");
		user.setPsw("123456");
		user.setEmail("1147");
		user.setName("ÍõÎå");
		UserDaoImpl uDaoImpl=new UserDaoImpl();
		//uDaoImpl.addUser(user);
		
	//	uDaoImpl.updatePsw(12, "123");
		
	/*	Date date=new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		System.out.println(timeStamp);*/
	}
}
