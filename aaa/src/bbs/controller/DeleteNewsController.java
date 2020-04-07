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
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class DeleteNewsController
 */
@WebServlet("/DeleteNewsController")
public class DeleteNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		
		HttpSession session=request.getSession(true);
		
		User u=(User) session.getAttribute("User");
		NewsService ns=new NewsServiceImpl();
//		System.out.println(u);
		
		if(u!=null) {
			String newsid=request.getParameter("newsid");
			ns.Cancel(Integer.parseInt(newsid));
//			request.getRequestDispatcher("/myindex.jsp").forward(request, response);
			response.sendRedirect("myindex");
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		HttpSession session=request.getSession(true);
		User u=(User) session.getAttribute("User");
		NewsService ns=new NewsServiceImpl();
		
		
		if(u!=null) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			String newsid=request.getParameter("newsid");
//			System.out.println("title"+title+"content:"+content+"newsid"+newsid);
			ns.update(Integer.parseInt(newsid), content);
			response.sendRedirect("myindex");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
