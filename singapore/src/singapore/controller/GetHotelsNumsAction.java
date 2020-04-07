package singapore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

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
 * Servlet implementation class GetHotelsNumsAction
 */
@WebServlet("/test3")
public class GetHotelsNumsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHotelsNumsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		 request.getRequestDispatcher("/test3.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelsService hs = new HotelsServiceImpl();
		List<Map<String,Object>> lst  = hs.getHotelsNums();
		//System.out.println(lst);
		//转化为json字符串
		//ajax    js-->ajax发送请求-->hotel1Servlet-->查数据--（json字符串）-->打印输出到页面去
		
		Gson  g=new Gson();
		Type t=new TypeToken<List<Map<String,Object>>>(){}.getType();
		String str = g.toJson(lst, t);
	    System.out.print(str);
		PrintWriter pw =response.getWriter();
		pw.print(str);
		pw.close();
	}

}
