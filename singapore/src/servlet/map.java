package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import s.dao.hotelDao;
import s.daoimpl.hotelDaoImpl;
import s.model.hotel;

/**
 * Servlet implementation class map
 */
@WebServlet("/map")
public class map extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public map() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	         request.getRequestDispatcher("/map.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hotelDao hotels=new hotelDaoImpl();
		 List<hotel> hotelsList = null;
		try {
			hotelsList = hotels.queryAllhotelMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Gson g=new Gson();
			Type t=new TypeToken<List<hotel>>() {}.getType();
			String str=g.toJson(hotelsList,t);
			System.out.println(str);
			PrintWriter pw=response.getWriter();
			pw.print(str);
			pw.close();
			
			
			 
	}

}
