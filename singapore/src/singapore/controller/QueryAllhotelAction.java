package singapore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import singapore.dao.HotelsDao;
import singapore.dao.impl.HotelsDaoImpl;
import singapore.model.hotels;

/**
 * Servlet implementation class QueryAllhotelAction
 */
@WebServlet("/test4")
public class QueryAllhotelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllhotelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/test4.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelsDao hotels=new HotelsDaoImpl();
		 List<hotels> hotelsList = null;
		try {
			hotelsList = hotels.queryAllhotelMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Gson g=new Gson();
			Type t=new TypeToken<List<hotels>>() {}.getType();
			String str=g.toJson(hotelsList,t);
			System.out.println(str);
			PrintWriter pw=response.getWriter();
			pw.print(str);
			pw.close();
	}

}
