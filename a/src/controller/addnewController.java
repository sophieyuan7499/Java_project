package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.news;

import service.newsService;

import service.impl.newsServiceImpl;

/**
 * Servlet implementation class addnewController
 */
@WebServlet("/addnewController")
public class addnewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String userid=request.getParameter("userid");
		System.out.println(title);
		System.out.println(content);
		System.out.println(userid);
		newsServiceImpl ns=new newsServiceImpl();
		news n=new news();
		n.setContent(content);
		n.setTitle(title);
		n.setDate2(new Date());
		n.setUserid(Integer.parseInt(userid));
		
		ns.add(n);
		
		response.sendRedirect("myindexController");
		
		
		
		
		
	
	
	}

}
