package singapore.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import singapore.model.hotels;
import singapore.service.HotelsService;
import singapore.service.impl.HotelsServiceImpl;

/**
 * Servlet implementation class GetGoodHotelsAction
 */
@WebServlet("/test2")
public class GetGoodHotelsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGoodHotelsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//查数据
				HotelsService hs = new HotelsServiceImpl();
				List<hotels>  lst =hs.getInfosHotel("North-East Region","Private room");
				
				//System.out.println(lst);
				
				//将数据  转发  给JSP
				request.setAttribute("hotelsList", lst);//可携带参数
				request.getRequestDispatcher("/test2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //鏌ユ暟鎹�
		HotelsService hs = new HotelsServiceImpl();
		List<hotels>  lst =hs.getInfosHotel("North-East Region","Private room");
		
	    //	System.out.println(lst);
		//灏嗘暟鎹�  杞彂  缁橨SP
		request.setAttribute("hotelsList", lst);//鍙惡甯﹀弬鏁�
		request.getRequestDispatcher("/test2.jsp").forward(request, response);
	}

}
