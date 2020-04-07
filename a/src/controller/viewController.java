package  controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comments;
import  model.User;
import  model.comment;
import model.news;
import  service.CommentsService;
import  service.commentService;
import  service.newsService;
import service.impl.CommentsServiceImpl;
import service.impl.commentServiceImpl;
import service.impl.newsServiceImpl;

/**
 * Servlet implementation class viewController
 */
@WebServlet("/viewController")
public class viewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����newsid��ѯ����
		String id=request.getParameter("id");

		CommentsService cs=new CommentsServiceImpl();
	
	newsService nn=new newsServiceImpl();
	//����id������ȫ��������
	news news=nn.selectidnews(Integer.parseInt(id));
	
	List< Comments> lst=cs.getCommentsByNewsId(news.getId());
	
	
	//�����յ�����������һ��ȫ�ֱ���
	request.setAttribute("idnews", news);
	
	request.setAttribute("CommLst", lst);
	//�����ݴ��ݵ�view.jspȥ����
	request.getRequestDispatcher("view.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession(true);
		
		User u=(User)session.getAttribute("User");
		
		if(u!=null) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
		String content=request.getParameter("content");
		String newsid=request.getParameter("newsid");
		CommentsService cs=new CommentsServiceImpl();
		Comments comm=new Comments();
	comm.setContent(content);
	comm.setDate(new Date());
	comm.setUserid(u.getId());
	comm.setNewsid(Integer.parseInt(newsid));
	

	
	cs.addComments(comm);
	
	response.sendRedirect("viewController?id="+newsid);
		}else {
			//��ת����½ҳ��
			response.sendRedirect("Login.jsp");
		}
	}

}
