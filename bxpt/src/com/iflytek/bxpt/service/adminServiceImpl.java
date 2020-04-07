package com.iflytek.bxpt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.bxpt.mapper.AdminMapper;
import com.iflytek.bxpt.po.Admin;
import com.iflytek.bxpt.service.adminService;


@Service
public class adminServiceImpl implements adminService{

	@Autowired(required = true)
	private AdminMapper a;

	@Override
	public boolean isExists(String username, String password) {
		// TODO Auto-generated method stub
		return a.isExists(username, password);
	}

	@Override
	public Admin searchPasswsordByEmail(String email) {
		// TODO Auto-generated method stub
		return a.searchPasswsordByEmail(email);
	}
	
	
	
}
