package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.model.user;
import bbs.service.UserService;
import bbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/register")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
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
		UserService us=new UserServiceImpl();
		user user=new user();
		String account=request.getParameter("account");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String passwordAgain=request.getParameter("passwordAgain");
		user.setAccount(account);
		user.setName(nickname);
		user.setEmail(email);
		user.setPsw(password);
		
		if(password==passwordAgain) {
			us.register(user);
		request.getRequestDispatcher("login.jsp").forward(request,response);
		}else{
            //通过getRequestDispatcher传递路径将请求转发给login.jsp
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
	}

}
