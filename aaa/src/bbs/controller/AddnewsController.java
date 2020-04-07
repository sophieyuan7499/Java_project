package bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.model.News;
import bbs.model.User;
import bbs.service.NewsService;
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class AddnewsController
 */
@WebServlet("/AddnewsController")
public class AddnewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddnewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证是否登录
		HttpSession session=request.getSession(true);
		User u=(User) session.getAttribute("User");
		NewsService ns=new NewsServiceImpl();
//		System.out.println(u);
		
		if(u!=null) {
			//获取发表的标题和内容，然后提�?
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			News n=new News();
			n.setId(5);
			n.setContent(content);
			n.setTitle(title);
			n.setDate(null);
			n.setUserid(u.getId());
			ns.add(n);
			
//			Comment comm=new Comment();
//			comm.setId(6);
//			comm.setContent(content);
//			comm.setDate(null);
//			comm.setUserid(u.getId());
//			comm.setNewsid(Integer.parseInt(newsid));
//			cs.add(comm);
			//网页跳转
//			response.sendRedirect("view?newsid="+newsid);
			
//			response.sendRedirect("myindex.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
