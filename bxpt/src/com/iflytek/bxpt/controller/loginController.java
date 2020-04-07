package com.iflytek.bxpt.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.bxpt.po.Admin;
import com.iflytek.bxpt.service.adminServiceImpl;





@Controller
public class loginController {
	@Autowired
	private adminServiceImpl asi;
	
	@RequestMapping(value="login",method=RequestMethod.GET )
	public String Login() {
	return "login";
	}
	
	
	@RequestMapping(value="login",method=RequestMethod.POST )
	public String Login1(String username ,String password,String remember,HttpServletResponse response,HttpServletRequest request) {
	    boolean isExists=asi.isExists(username, password);
		
		if(isExists==true) {
		//Ìí¼Ócookie
		if("1".equals(remember)) {
			Cookie cookie1=new Cookie("username", username);
			cookie1.setMaxAge(60*60*24);
			
			Cookie cookie2=new Cookie("password", password);
			cookie2.setMaxAge(60*60*24);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		}
		
		//Ìí¼Ósession
		HttpSession session=request.getSession();
		session.setAttribute("isExists",isExists );
		
		
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		return "redirect:index";
	}else {
		return "error";
	}
	}
	
	@RequestMapping(value="forget",method=RequestMethod.POST )
	@ResponseBody
	public Admin  Login2(String email) {
		
		
		return asi.searchPasswsordByEmail(email);
	
	}
	@RequestMapping(value="index",method=RequestMethod.GET )
	public String index() {
	return "index";
	}
}
