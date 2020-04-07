package  service.impl;

import  dao.UserDao;
import   dao.impl.UserDaoImpl;
import  model.User;
import  service.UserService;

/**
 * 这是业务实现
 * 
 * */
//Service调用Dao层的方法   
public class UserServiceImpl implements UserService{
	private UserDao ud = new UserDaoImpl();  //父类引用指向子类对象

	public User login(String account, String psw) {
		// TODO Auto-generated method stub
		return ud.getUserByAccAndPsw(account, psw);
	}

	public void register(User u) {
		// TODO Auto-generated method stub
		ud.addUser(u);
	}

	public void updatePsw(int account, String psw) {
		// TODO Auto-generated method stub
		ud.updatePsw(account, psw);
	}  
	

}
