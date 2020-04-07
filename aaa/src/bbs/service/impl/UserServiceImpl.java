package bbs.service.impl;

import bbs.dao.UserDao;
import bbs.dao.impl.UserDaoImpl;
import bbs.model.User;
import bbs.service.UserService;

//Serviceï¿½ï¿½ï¿½ï¿½daoï¿½ï¿½Ä·ï¿½ï¿½ï¿?
public class UserServiceImpl implements UserService{

	private UserDao ud=new UserDaoImpl();
	
	@Override
	public User login(String account, String psw) {
		// TODO Auto-generated method stub
		return ud.getUserByAccAndPsw(account, psw);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		ud.addUser(u);
	}

	@Override
	public void update(int id, String psw) {
		// TODO Auto-generated method stub
		ud.updatePsw(id, psw);
	}

//	public static void main(String[] args) {
//		UserService us=new UserServiceImpl();
//		User u=new User();
//		
//		System.out.println(us.login("test001", "123"));
//		
////	    u.setId(3);
////	    u.setAccount("test003");
////	    u.setPsw("123");
////	    u.setName("xiaolv");
////	    u.setEmail("123");
////		us.register(u);
//		
//		//us.update(3, "111");
//	}
}
