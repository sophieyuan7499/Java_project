package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.model.news;
import bbs.service.NewsService;
import bbs.service.impl.NewsServiceImpl;

/**
 * 编辑新闻
 * Servlet implementation class editnews
 */
@WebServlet("/editnews")
public class editnews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editnews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newsid=request.getParameter("newsid");
		
		
		/*request.setAttribute("content", content);
		request.setAttribute("title", title);
		
		System.out.println(content);*/
		
		
		NewsService  ns=new NewsServiceImpl();
		news n= ns.getNewsByNewsId(Integer.parseInt(newsid));
		
		HttpSession session2=request.getSession();
		session2.setAttribute("newsss", n);
		//request.setAttribute("newsss", n);
		//转发到页面
		request.getRequestDispatcher("/personal/editnews.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newsid=request.getParameter("newsid");
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		//从页面获取
		System.out.println(title);
		NewsService ns=new NewsServiceImpl();
		news news=new news ();
		news.setTitle(title);
		news.setContent(content);
		ns.editNews(news);
		response.sendRedirect("editnews?newsid="+newsid);
	}

}
