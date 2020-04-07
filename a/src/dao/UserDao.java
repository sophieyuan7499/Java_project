package dao;

import model.User;

public interface UserDao {
	public User getUserByAccAndPsw(String account,String psw);    //得到用户名通过账户密码，登陆	
	
	public void updatePsw(int account,String psw);						//修改密码
	
	public void addUser(User u);								//增加用户名，注册
}
