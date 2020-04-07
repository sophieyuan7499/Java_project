package  controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import  model.User;
import  service.UserService;
import  service.impl.UserServiceImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	String account=request.getParameter("account");
	String psw=request.getParameter("psw");
	String auto=request.getParameter("auto");
	
	PrintWriter writer=response.getWriter();
	UserService uu=new UserServiceImpl();
	User u=uu.login(account, psw);
	
	if(u!=null) {
		/*response.setStatus(302);
		response.setHeader("Location", "index.jsp");*/
		//response.sendRedirect("index.jsp");
		
		//添加记住密码功能 cookie
		 
		//如果登陆成功 
		if("1".equals(auto)) {
		Cookie cookie1=new Cookie("account", account);
		cookie1.setMaxAge(60*60*24);
		
		Cookie cookie2=new Cookie("psw", psw);
		cookie2.setMaxAge(60*60*24);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		}
		
		
		//如果登陆成功，那么将用户信息存入进session中
		HttpSession session=request.getSession();
		session.setAttribute("User", u);
		
		response.sendRedirect("indexController");
		//request.getRequestDispatcher("indexController").forward(request, response);
	}else {
		writer.write("登陆失败");
	}
	}

}
