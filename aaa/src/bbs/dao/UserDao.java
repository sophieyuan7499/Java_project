package bbs.dao;

import bbs.model.User;

public interface UserDao {
	//�����˻��������¼
	public User getUserByAccAndPsw(String account,String psw);
	//����id���µ������޸�����
	public void updatePsw(int id,String psw);
	//�����û�
	public void addUser(User u);
}
