package bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.model.News;
import bbs.service.NewsService;
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class MyindexController
 */
@WebServlet("/myindex")
public class MyindexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyindexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService ns=new NewsServiceImpl();
		List<News> lst = ns.getallNews(1, 10);
//		System.out.println(lst);
//		String userid =request.getParameter("userid");
//		NewsService ns=new NewsServiceImpl();
//		News n=new News();
//		List<News> lst=ns.queryConByUserID(Integer.parseInt(userid));
//		
		request.setAttribute("NewsLst",lst);
		request.getRequestDispatcher("/myindex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
