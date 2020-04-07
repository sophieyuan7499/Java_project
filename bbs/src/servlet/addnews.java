package servlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import bbs.model.news;
import bbs.service.NewsService;
import bbs.service.impl.NewsServiceImpl;

/**
 * 新增新闻
 * Servlet implementation class addnews
 */
@WebServlet("/addnews")
public class addnews extends HttpServer {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnews() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String userid=request.getParameter("userid");
		System.out.println(title);
		System.out.println(content);
		System.out.println(userid);
		NewsService ns=new NewsServiceImpl();
		news n=new news();
		n.setContent(content);
		n.setTitle(title);
		n.setDate(new Date());
		n.setUserid(Integer.parseInt(userid));
		
		ns.addNews(n);
		
		response.sendRedirect("myindexController");
		
		
		

	}

	@Override
	public void bind(InetSocketAddress addr, int backlog) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExecutor(Executor executor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Executor getExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop(int delay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpContext createContext(String path, HttpHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpContext createContext(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContext(String path) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContext(HttpContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
