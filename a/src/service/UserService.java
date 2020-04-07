package service;

import  model.User;
/**
 * 这是业务处理规范，业务逻辑层。Dao有什么这里就有什么
 * */
public interface UserService {
	public User login(String account,String psw);//登陆
	
	public void register(User u);//注册
	
	public void updatePsw(int account,String psw);//修改密码
}
