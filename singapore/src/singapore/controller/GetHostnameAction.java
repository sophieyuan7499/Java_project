package singapore.controller;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import singapore.model.hotels;
import singapore.service.HotelsService;
import singapore.service.impl.HotelsServiceImpl;

/**
 * Servlet implementation class GetHostnameAction
 */
@WebServlet("/test1")
public class GetHostnameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHostnameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelsService dao=new HotelsServiceImpl();
		List<hotels> lst= dao.gethostname();
		request.setAttribute("HostnameLst", lst);
		request.getRequestDispatcher("/test1.jsp").forward(request, response);
		//转化为json格式
		 /*JSONArray jsonArray = new JSONArray();
		 jsonArray.add(lst);
		 
	     for(hotels lstjson : lst){
	         JSONObject jo = new JSONObject();
	         jo.put("host_name", lstjson.getHost_name());
	         jo.put("comments", lstjson.getComments());
	         jsonArray.add(jo);
	     }*/
	   // System.out.println(lst);
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	/*
public static void main(String[] args) {
	HotelsDao dao=new HotelsDaoImpl();
	List<hotels> lst= dao.gethostname();
	
	 JSONArray jsonArray = new JSONArray();
	 
     for(hotels lstjson : lst){
         JSONObject jo = new JSONObject();
         
         jo.put("host_name", lstjson.getHost_name());
         jo.put("comments", lstjson.getComments());
         jsonArray.add(jo);
     }
     
   //  System.out.println(jsonArray.toString());
     System.out.println(jsonArray.toString());
}*/
}
