package goodsManger.Dao;

import goodsManger.model.User;

public interface UserDao {
public User getUser(String account,String psw);
}
