package  service.impl;

import  dao.UserDao;
import   dao.impl.UserDaoImpl;
import  model.User;
import  service.UserService;

/**
 * ����ҵ��ʵ��
 * 
 * */
//Service����Dao��ķ���   
public class UserServiceImpl implements UserService{
	private UserDao ud = new UserDaoImpl();  //��������ָ���������

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
