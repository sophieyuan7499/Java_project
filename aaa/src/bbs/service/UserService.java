package bbs.service;

import bbs.model.User;

public interface UserService {
	public  User login(String account,String psw);
	
	public void register(User u);
	
	public void update(int id,String psw);
}
