package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.model.news;
import bbs.service.NewsService;
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/index")
public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	NewsService ns=new NewsServiceImpl();
	List<news> lst=ns.getNews(1, 10);
	//System.out.println(lst);
	
	
	request.setAttribute("newsList", lst);
	request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String title=request.getParameter("title");
	NewsService nService=new NewsServiceImpl();
	List<news> list=nService.getNewsByTitle(title, 1, 5);
	request.setAttribute("newsList", list);
	request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
