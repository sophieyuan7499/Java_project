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
 * Servlet implementation class IndexController
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService ns=new NewsServiceImpl();
		List<News> lst = ns.getallNews(1, 10);
		
		//将数据转发给JSP
		request.setAttribute("NewsLst", lst);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");

		//获取请求的参�?
				String title=request.getParameter("title");
//				System.out.println(title);
					
				//根据标题查询新闻
				NewsService ns=new NewsServiceImpl();
				List<News> lst=ns.getNewsByTitle(title, 1, 10);
//				System.out.println(lst);
				
				//转发到页面中�?
				request.setAttribute("NewsLst", lst);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
