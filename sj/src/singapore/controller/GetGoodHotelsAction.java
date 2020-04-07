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
				//鏌ユ暟鎹�
				HotelsService hs = new HotelsServiceImpl();
				List<hotels>  lst =hs.getInfosHotel("North-East Region","Private room");
				
				//System.out.println(lst);
				 
				//灏嗘暟鎹�  杞彂  缁橨SP
				request.setAttribute("hotelsList", lst);//鍙惡甯﹀弬鏁�
				request.getRequestDispatcher("/test2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //閺屻儲鏆熼幑锟�
		HotelsService hs = new HotelsServiceImpl();
		List<hotels>  lst =hs.getInfosHotel("North-East Region","Private room");
		
	    //	System.out.println(lst);
		//鐏忓棙鏆熼幑锟�  鏉烆剙褰�  缂佹┄SP
		request.setAttribute("hotelsList", lst);//閸欘垱鎯＄敮锕�寮弫锟�
		request.getRequestDispatcher("/test2.jsp").forward(request, response);
	}

}
