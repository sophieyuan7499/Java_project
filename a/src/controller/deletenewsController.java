package   controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  service.newsService;
import  service.impl.newsServiceImpl;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deletenewsController")
public class deletenewsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String newsid=request.getParameter("newsid");
		//System.out.println(newsid);
		newsService ns=new newsServiceImpl();
		
		ns.delete(Integer.parseInt(newsid));
		
		response.sendRedirect("myindexController");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
