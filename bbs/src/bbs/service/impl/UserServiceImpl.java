package bbs.service.impl;

import bbs.dao.UserDao;
import bbs.dao.ipml.UserDaoImpl;
import bbs.model.user;
import bbs.service.UserService;

public class UserServiceImpl implements UserService {
private UserDao ud=(UserDao) new UserDaoImpl();


	@Override
	public user login(String account, String psw) {
		// TODO Auto-generated method stub
		return ud.getUser(account, psw);
	}

	@Override
	public void register(user u) {
		// TODO Auto-generated method stub
		ud.adduser(u);
	}

	@Override
	public void updatePsw(int id, String psw) {
		// TODO Auto-generated method stub
		ud.updatepsw(id, psw);
	}

}
