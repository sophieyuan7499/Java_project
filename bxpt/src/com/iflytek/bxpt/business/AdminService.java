package com.iflytek.bxpt.business;

import com.iflytek.bxpt.dao.AdminDao;
import com.iflytek.bxpt.po.Admin;

public class AdminService {
	
private AdminDao adminDao=new AdminDao();

   //判断管理员是否合法
	public boolean legal(Admin admin) {
		return adminDao.isExists(admin.getUsername(), admin.getPassword());
	}
	//根据邮箱查询用户名和密码
	public Admin  searchPasswsordByEmail(String email) {
		return adminDao.searchPasswsordByEmail(email);
	}
}
