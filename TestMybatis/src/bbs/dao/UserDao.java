package bbs.dao;

import java.util.List;

import bbs.model.Users;

public interface UserDao {
	public Users getUserById(int id);
	public List<Users> getAllUser();
	public void addUser(Users u);
	//��̬SQL�������û���Ϣ ��set����ʲô����ʲô�����²����ֶ�
	public void updatUser(Users u);
	
}
