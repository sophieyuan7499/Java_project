package dao;

import model.User;

public interface UserDao {
	public User getUserByAccAndPsw(String account,String psw);    //�õ��û���ͨ���˻����룬��½	
	
	public void updatePsw(int account,String psw);						//�޸�����
	
	public void addUser(User u);								//�����û�����ע��
}
