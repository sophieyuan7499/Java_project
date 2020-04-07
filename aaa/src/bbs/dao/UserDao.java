package bbs.dao;

import bbs.model.User;

public interface UserDao {
	//根据账户和密码登录
	public User getUserByAccAndPsw(String account,String psw);
	//根据id和新的密码修改密码
	public void updatePsw(int id,String psw);
	//新增用户
	public void addUser(User u);
}
