package com.iflytek.bxpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iflytek.bxpt.business.AdminService;
import com.iflytek.bxpt.po.Admin;
import com.iflytek.bxpt.util.SendMail;

public class LoginServlet extends HttpServlet{
      private AdminService adminService=new AdminService();
      private static final String RMB_STATUS = "1";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");       
		response.setContentType("text/html; charset=utf-8");
		String param = request.getParameter("param");
		System.out.println(param);
		PrintWriter out = response.getWriter();
		
	if("login".equals(param)) {
	    	System.out.println("true");
			String username=request.getParameter("username");
			String password=request.getParameter("password");		   
			Admin admin=new Admin(username,password);
			boolean legal=adminService.legal(admin);
			
			if(legal) {	
				request.getSession().setAttribute("admin", admin);
				 //需要读取当前硬盘的Cookie信息，如果有则跳过登录。
			  	Cookie[] cs=request.getCookies();//读取当前硬盘的所有cookie	
			  	 for(Cookie c : cs){
			  		               if(c.getName().equalsIgnoreCase("username")){
			  		                username = c.getValue();
			  		               }
			  		              if(c.getName().equalsIgnoreCase("password")){
			  		                  password = c.getValue();
			                       }
			  	}
				if(RMB_STATUS.equals(request.getParameter("remember"))) {	
					//当用户点击记住我后，创建cookie来保存用户名和密码
					Cookie name=new Cookie("username", username);
					Cookie pwd=new Cookie("password", password);
					name.setMaxAge(60*60*24);
					pwd.setMaxAge(60*60*24);
					response.addCookie(name);
					response.addCookie(pwd);
				}	
				response.sendRedirect("index.jsp");
				
			}else {
				Cookie pwd=new Cookie("password", "");
				pwd.setMaxAge(0);
				response.addCookie(pwd);
				String error="用户名或密码不正确";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	 }else if("forget".equals(param)) {
		  response.setContentType("textml;charset=UTF-8");
		  String email=request.getParameter("email");
		  Admin admin=null;		  
		  admin= adminService.searchPasswsordByEmail(email);
		  SendMail mySendMail = new SendMail();
		  //判断该邮箱是否存在对应的用户
		  if (admin != null) {			  
				mySendMail.sendMail(email, "科大讯飞教育提醒您，您的密码为：" + admin.getPassword());
				out.println("<script>+alert('恭喜，找回密码成功');window.location.href='login.jsp'</script>");
			}else {
				out.println("<script>+alert('该邮箱尚未注册！请重新输入');window.location.href='login.jsp'</script>");
			}
	
			
	  }
	}   
}
