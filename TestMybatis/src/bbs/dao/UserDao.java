package bbs.dao;

import java.util.List;

import bbs.model.Users;

public interface UserDao {
	public Users getUserById(int id);
	public List<Users> getAllUser();
	public void addUser(Users u);
	//动态SQL，更新用户信息 ，set传入什么更新什么，更新部分字段
	public void updatUser(Users u);
	
}
