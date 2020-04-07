package  controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  model.User;
import  model.news;
import  service.newsService;
import  service.impl.newsServiceImpl;

/**
 * Servlet implementation class myindexController
 */
@WebServlet("/myindexController")
public class myindexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//根据userid查询帖子
		HttpSession session=request.getSession(true);
		
		User u=(User)session.getAttribute("User");
		//u.getId();
		
		newsService ns=new newsServiceImpl();
		List<news>list=	ns.selectueridnews(u.getId());
		
		request.setAttribute("newsss", list);
		
	
		
		request.getRequestDispatcher("/personal/myindex.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
