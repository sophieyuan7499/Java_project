package exam.service.impl;

import exam.dao.UserDao;
import exam.dao.impl.UserDaoImpl;
import exam.model.User;
import exam.service1.UserService;

public class UserServiceImpl implements UserService{
private UserDao u=new UserDaoImpl();
	@Override
	public User login(String account, String psw) {
		// TODO Auto-generated method stub
		return u.getUser(account, psw);
	}

}
