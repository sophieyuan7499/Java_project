package goodsManger.Service.Impl;

import goodsManger.Dao.UserDao;
import goodsManger.Service.UserSevice;
import goodsManger.model.User;
import googsManger.Dao.Impl.UserDaoImpl;

public class UserServiceImpl implements UserSevice{
UserDao ud=new UserDaoImpl();
	@Override
	public User login(String account, String psw) {
		// TODO Auto-generated method stub
		return ud.getUser(account, psw);
	}

}
