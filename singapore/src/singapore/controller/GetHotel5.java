package singapore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import singapore.service.HotelsService;
import singapore.service.impl.HotelsServiceImpl;

/**
 * Servlet implementation class GetHotel5
 */
@WebServlet("/test5")
public class GetHotel5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHotel5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/test5.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelsService hs = new HotelsServiceImpl();
		
		List<Map<String,Object>> lst2 = hs.getHotelByAeraAndPrice();
		Gson  g=new Gson();
		Type t=new TypeToken<List<Map<String,Object>>>(){}.getType();
		String str2 = g.toJson(lst2, t);
	    System.out.print(str2);
		PrintWriter pw2 =response.getWriter();
		pw2.print(str2);
		pw2.close();
				
	}

}
