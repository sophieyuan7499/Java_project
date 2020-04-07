package singapore.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import singapore.dao.HotelsDao;
import singapore.dao.impl.HotelsDaoImpl;
import singapore.model.hotels;

/**
 * Servlet implementation class GetHotel6
 */
@WebServlet("/test6")
public class GetHotel6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHotel6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelsDao hd = new HotelsDaoImpl();
		//hotels h=new hotels();
		List<Map<String,Object>> lst2 = hd.getHotelByAeraAndPrice();
		List<hotels> lst =  hd.getHotelByAeraAndComments();
		System.out.print(lst2);
		//灏嗘暟鎹�  杞彂  缁橨SP
		request.setAttribute("hotel2List", lst);//鍙惡甯﹀弬鏁�
		request.getRequestDispatcher("/test6.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
