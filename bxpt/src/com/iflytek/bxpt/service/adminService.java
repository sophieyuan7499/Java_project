package com.iflytek.bxpt.service;

import org.apache.ibatis.annotations.Param;

import com.iflytek.bxpt.po.Admin;

public interface adminService {
	
	public boolean isExists(@Param("username") String username,@Param("password")String password);
	
	public Admin searchPasswsordByEmail(String email);
}
