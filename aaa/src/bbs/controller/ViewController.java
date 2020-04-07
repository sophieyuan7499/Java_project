package bbs.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.model.Comment;
import bbs.model.News;
import bbs.model.User;
import bbs.service.CommentService;
import bbs.service.NewsService;
import bbs.service.impl.CommentServiceImpl;
import bbs.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		CommentService cs=new CommentServiceImpl();
		//获取参数
		String newsid=request.getParameter("newsid");
		NewsService ns=new NewsServiceImpl();
		News n1=ns.queryConById(Integer.parseInt(newsid));
		
//		News n2=new News();
//		
//		n2.setId(3);
//		n2.setTitle("123");
//		n2.setContent("123");
//		
//		n2.setUserid(3);
//
		List<Comment> lst2=(List<Comment>) cs.queryComByNewsid(Integer.parseInt(newsid));
		
		//根据新闻id查询新闻转发到页面中
		request.setAttribute("News", n1);
		request.setAttribute("CommLst", lst2);
		
		request.getRequestDispatcher("/view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证是否登录
		HttpSession session=request.getSession(true);
		User u=(User) session.getAttribute("User");
		CommentService cs=new CommentServiceImpl();
		
		if(u!=null) {
			//获取发表的评论，然后提交
			String content=request.getParameter("content");
			String newsid=request.getParameter("newsid");
			Comment comm=new Comment();
			comm.setId(6);
			comm.setContent(content);
			comm.setDate(null);
			comm.setUserid(u.getId());
			comm.setNewsid(Integer.parseInt(newsid));
			cs.add(comm);
			//网页跳转
			response.sendRedirect("view?newsid="+newsid);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
