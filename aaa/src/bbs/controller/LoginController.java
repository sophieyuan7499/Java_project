package bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.model.User;
import bbs.service.UserService;
import bbs.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String account = request.getParameter("account");
		String psw = request.getParameter("password");
		String auto=request.getParameter("auto");
		UserService us = new UserServiceImpl();
		User u=us.login(account, psw);
		
		if(u != null) {
			if(auto!=null&&auto.equals("1")) {
				//产生cookie
				Cookie cook=new Cookie(account, psw);
				cook.setMaxAge(1000*60*60*24*7);
				//将cookie发�?�给浏览器保�?
				response.addCookie(cook);
			}
			//登陆成功，将用户信息保存进session
			HttpSession session=request.getSession();
			session.setAttribute("User", u);
			response.sendRedirect("index");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
