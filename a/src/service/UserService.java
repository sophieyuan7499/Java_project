package service;

import  model.User;
/**
 * ����ҵ����淶��ҵ���߼��㡣Dao��ʲô�������ʲô
 * */
public interface UserService {
	public User login(String account,String psw);//��½
	
	public void register(User u);//ע��
	
	public void updatePsw(int account,String psw);//�޸�����
}
