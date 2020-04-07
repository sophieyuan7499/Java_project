package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.news;
import service.newsService;
import service.impl.newsServiceImpl;

/**
 * Servlet implementation class editnewsController
 */
@WebServlet("/editnewsController")
public class editnewsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newsid=request.getParameter("newsid");
		
		
		/*request.setAttribute("content", content);
		request.setAttribute("title", title);
		
		System.out.println(content);*/
		
		
		newsService  ns=new newsServiceImpl();
		news n= ns.selectidnews(Integer.parseInt(newsid));
		
		HttpSession session2=request.getSession();
		session2.setAttribute("newsss", n);
		//request.setAttribute("newsss", n);
		
		request.getRequestDispatcher("/personal/editnews.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newsid=request.getParameter("newsid");
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		
		System.out.println(title);
		newsService ns=new newsServiceImpl();
		ns.update(content, title, Integer.parseInt(newsid));
		
		response.sendRedirect("editnewsController?newsid="+newsid);
	}

}
