package bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.model.User;
import bbs.service.NewsService;
import bbs.service.UserService;
import bbs.service.impl.NewsServiceImpl;
import bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LogouController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注销 讲session信息删除
		HttpSession session=request.getSession(true);
		session.invalidate();
		//session.removeAttribute("index.jsp");
		response.sendRedirect("index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		User u=(User) session.getAttribute("User");
		UserService us=new UserServiceImpl();
		String psw1=request.getParameter("psw1");
		String psw2=request.getParameter("psw2");
		
		if(u!=null) {			
			if(psw1!=psw2) {
				System.out.println("两次密码不一致！");
			}else {
				us.update(u.getId(), psw2);
				System.out.println("修改成功�?");
			}	
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
