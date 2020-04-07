package  controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  model.news;
import  service.newsService;
import  service.impl.newsServiceImpl;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/indexController")
public class indexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		newsService nn=new newsServiceImpl();
		List<news> list=nn.selectAllnews();
		//System.out.println(list);
		
		//getServletContext().setAttribute("All", list);
		
		request.setAttribute("All", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//…Ë÷√±‡¬Î
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String title=request.getParameter("title");
		//System.out.println(title);
		newsService nn=new newsServiceImpl();
		
	List<news> list=nn.selectuertitlenews(title);
	System.out.println(list);
	
	
	
	request.setAttribute("All", list);
	
	request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
