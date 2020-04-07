package  controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import  model.User;
import  service.UserService;
import  service.impl.UserServiceImpl;

/**
 * Servlet implementation class editpasswordController
 */
@WebServlet("/editpasswordController")
public class editpasswordController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String psw1=request.getParameter("psw1");
		String psw2=request.getParameter("psw2");
		System.out.println(account);
		System.out.println(psw1);
		if(psw1.equals(psw2)) {
			
		UserService us=new UserServiceImpl();
		us.updatePsw(Integer.parseInt(account), psw1);
		//request.getRequestDispatcher("editpassword.jsp").forward(request, response);
		response.sendRedirect("/bbs/personal/editpassword.jsp");
		}else {
			response.getWriter().write("¡©¥Œ√‹¬Î≤ª“ª÷¬");
		}
	}

}
