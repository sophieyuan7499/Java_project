package bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.model.News;
import bbs.model.User;
import bbs.service.NewsService;
import bbs.service.UserService;
import bbs.service.impl.NewsServiceImpl;
import bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ReqisterController
 */
@WebServlet("/register")
public class ReqisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsid =request.getParameter("newsid");
		NewsService ns=new NewsServiceImpl();
		News n=ns.queryConById(Integer.parseInt(newsid));
//		System.out.println(n);
		request.setAttribute("News", n);
		request.getRequestDispatcher("/editnews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us=new UserServiceImpl();
		User u=new User();
		
		String Id =request.getParameter("Id");
		String account =request.getParameter("account");
		String nickname =request.getParameter("nickname");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		String passwordAgain =request.getParameter("passwordAgain");
		
		u.setId(Integer.parseInt(Id));
		u.setAccount(account);
		u.setName(nickname);
		u.setPsw(password);
		u.setEmail(email);
		
//		System.out.println(Id+account+nickname+email+password+passwordAgain);
		
		if(password==passwordAgain) {
			us.register(u);
			response.sendRedirect("login.jsp");
		}else {
			System.out.println("密码不一�?");
		}
	}
}
