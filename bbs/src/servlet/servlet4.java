package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import bbs.dao.ContentDao;
import bbs.dao.ipml.ContentDaoImpl;
import bbs.model.content;
import bbs.model.news;
import bbs.model.user;
import bbs.service.ContentService;
import bbs.service.NewsService;
import bbs.service.impl.ContentServiceImpl;
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class servlet3
 */
@WebServlet("/view")
public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newsid=request.getParameter("newsid");
		ContentService cs=new ContentServiceImpl();
		NewsService ns=new NewsServiceImpl();
		news news=ns.getNewsByNewsId(Integer.parseInt(newsid));
		
		List<content> lst=cs.getContentByNewsId(news.getId());
		
		request.setAttribute("news", news);
		request.setAttribute("conlst",lst);
		request.getRequestDispatcher("/view.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		
		HttpSession session=request.getSession(true);
		user user=(user) session.getAttribute("user");
		if(user!=null) {

			String contentString=request.getParameter("content");
			String newsid =request.getParameter("newsid");
			ContentDao cs=new ContentDaoImpl();
			content content =new content();
			content.setContent(contentString);
			content.setDate(new Date());
			content.setUserid(user.getId());
			content.setNewsid(Integer.parseInt(newsid));
			
			cs.addContent(content);
			response.sendRedirect("view?newsid="+newsid);
		}else {
			response.sendRedirect("login.jsp");
		}
		

		
		
	}

}
