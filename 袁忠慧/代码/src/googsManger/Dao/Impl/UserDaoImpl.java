package googsManger.Dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import goodsManger.Dao.UserDao;
import goodsManger.model.User;

public class UserDaoImpl implements UserDao{
QueryRunner runner= new QueryRunner(goodsManger.util.JdbcUtil2.getDataSource());
	@Override
	public User getUser(String account,String psw) {
		// TODO Auto-generated method stub
		String sql="select * from users where account=? and password=?";
		Object[] param= {account,psw};
		User user=null;
		try {
			user = runner.query(sql,new BeanHandler<User>(User.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
