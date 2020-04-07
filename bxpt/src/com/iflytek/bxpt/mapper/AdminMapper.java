package com.iflytek.bxpt.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.iflytek.bxpt.po.Admin;

@Repository
public interface AdminMapper {

	public boolean isExists(@Param("username") String username,@Param("password")String password);
	public Admin searchPasswsordByEmail(String email);
}
