package bbs.dao;

import bbs.model.user;

public interface UserDao {
	public user getUser(String account, String psw);
	public void adduser(user u);
	public void updatepsw(int id, String psw);
}
