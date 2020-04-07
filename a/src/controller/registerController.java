package  controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  model.User;
import  service.UserService;
import  service.impl.UserServiceImpl;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String psw=request.getParameter("psw");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		
		PrintWriter printWriter=response.getWriter();
		
		User user=new User();
		user.setAccount(account);
		user.setEmail(email);
		user.setName(name);
		user.setPsw(psw);
		
		UserService uu=new UserServiceImpl();
		uu.register(user);
		
		UserService uuu=new UserServiceImpl();
		User u=uu.login(account, psw);
		if(u!=null) {
			/*response.setStatus(302);
			response.setHeader("Location", "Login.jsp");*/
			response.sendRedirect("Login.jsp");
		}else {
			
			printWriter.write("×¢²áÊ§°Ü");
		}
	}

}
