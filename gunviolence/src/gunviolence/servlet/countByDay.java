package gunviolence.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import gunviolence.dao.gunviolenceDao;
import gunviolence.daoimpl.gunviolenceDaoImpl;

/**
 * Servlet implementation class countByDay
 */
@WebServlet("/countbyday")
public class countByDay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public countByDay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/countbyday.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gunviolenceDao gvs=new gunviolenceDaoImpl();
		List<Map<String,Object>> lst=null;
		try {
			  lst=gvs.getCountByDay();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson  g=new Gson();
		Type t=new TypeToken<List<Map<String,Object>>>(){}.getType();
		String str = g.toJson(lst, t);
	    System.out.print(str);
		PrintWriter pw =response.getWriter();
		pw.print(str);
		pw.close();
	}

}
