package exam.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import exam.util.JdbcUtil2;
import exam.dao.UserDao;
import exam.model.User;

public class UserDaoImpl implements UserDao{
QueryRunner r=new QueryRunner(JdbcUtil2.getDataSource());
	@Override
	public User getUser(String account, String psw) {
		// TODO Auto-generated method stub
		String sql="select * from user where account=?,psw=?";
		Object[] param= {account,psw};
		User user=null;
		try {
	user =r.query(sql, param, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override 
	public void addUser(User u) {
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?,?) ";
		Object[] param= {null,u.getAccount(),u.getPsw(),u.getName(),u.getEmail()};
		try {
			r.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePsw(int id, String psw) {
		// TODO Auto-generated method stub
		String sql="update user set psw =? where id=?";
		Object[] param= {psw,id};
		try {
			r.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	UserDao mDao=new UserDaoImpl();
	mDao.updatePsw(1, "123");
}
}
