package exam.dao;

import exam.model.User;

public interface UserDao {
public User getUser(String account,String psw);
public void  addUser(User u);
public void updatePsw(int id,String psw);
}
