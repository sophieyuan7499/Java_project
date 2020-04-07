package bbs.service;

import bbs.model.user;

public interface UserService {
public user login(String account,String psw);
public void register(user u);
public void updatePsw(int id,String psw);


}
