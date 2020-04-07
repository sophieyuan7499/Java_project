package com.iflytek.bxpt.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iflytek.bxpt.business.EquipmentService;
import com.iflytek.bxpt.po.Equipment;
import com.iflytek.bxpt.util.PageModel;


public class EquipmentServlet extends HttpServlet{
     private EquipmentService equipmentService=new EquipmentService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.setCharacterEncoding("utf-8");/*涓嶅啓杩欏彞璇濆湪浼犺緭杩囩▼涓細鍑虹幇涔辩爜*/
		String param=request.getParameter("param");/*瀹氫箟涓�涓猵aram鏉ユ帴鏀朵粠椤甸潰浼犺繃鏉ョ殑鍙傛暟*/
		/*涓嬮潰瀵硅繖浜涙帴鏀跺埌鐨勫弬鏁拌繘琛屽垽鏂�*/
		//鏂板
		if("add".equals(param)) {
			int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			String model=request.getParameter("model");
			String number=request.getParameter("number");
			int typeid=Integer.parseInt(request.getParameter("typeid"));
			int brandsid=Integer.parseInt(request.getParameter("brandsid"));
			String address=request.getParameter("address");
			Date buydate=Date.valueOf(request.getParameter("buydate"));
			int statusid=Integer.parseInt(request.getParameter("statusid"));
		//	Equipment equipment=new Equipment( model, number, typeid,  brandsid,  address, buydate, statusid);
		//	equipmentService.addEquipment(equipment);
			request.getRequestDispatcher("equipmentServlet?param=list&pageNo="+pageNo).forward(request, response);	
			/*杞彂鍒伴〉闈㈡垨鑰呭叾浠栧垎鏀�*/
		}
		//淇敼涔嬪墠灏嗚鐗╁搧鐨勮缁嗕俊鎭睍绀哄湪淇敼椤甸潰涓�
		else if("modify".equals(param)) {
			int eid=Integer.parseInt(request.getParameter("eid"));
			Equipment equipment= equipmentService.queryByEid(eid);
			request.setAttribute("equipment", equipment);			
			request.getRequestDispatcher("html/updateform.jsp").forward(request, response);
		}
		//澶勭悊淇敼鎻愪氦鐨勮〃鍗曚俊鎭�
		 else if("update".equals(param)) {			 
			    int eid=Integer.parseInt(request.getParameter("eid"));
			    String pageNo=request.getParameter("pageNo");
				String model=request.getParameter("model");
				String number=request.getParameter("number");
				int typeid=Integer.parseInt(request.getParameter("typeid"));
				int brandsid=Integer.parseInt(request.getParameter("brandsid"));
				String address=request.getParameter("address");
				Date buydate=Date.valueOf(request.getParameter("buydate"));
				int statusid=Integer.parseInt(request.getParameter("statusid"));
			//	Equipment equipment=new Equipment( eid,model, number, typeid,  brandsid,  address, buydate, statusid);
			//	equipmentService.updateEquipment(equipment);
				request.getRequestDispatcher("equipmentServlet?param=list&pageNo="+pageNo).forward(request, response);	
		}
		//鍒犻櫎
		 else  if("delete".equals(param)) {
			 int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			 int eid=Integer.parseInt(request.getParameter("eid"));
			 equipmentService.deleteEquipment(eid);
			 request.getRequestDispatcher("equipmentServlet?param=list&pageNo="+pageNo).forward(request, response);	
			 
		 }
		//椤甸潰鏌ヨ
		 else if("search".equals(param)) {
			 System.out.println("ok");
			 int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			 String model=request.getParameter("model");
			 String typeid=request.getParameter("typeid");
			 String statusid=request.getParameter("statusid");
			 System.out.println(model);
			 System.out.println(typeid);
			 System.out.println(statusid);
			 List<Equipment> equipment=equipmentService.searchEquipments(typeid, model, statusid, pageNo);	
			 int totalRecords = equipmentService.querytotalRecords1(typeid, model, statusid);//鏌ヨ鎬昏褰曟暟
				PageModel pageModel=new PageModel();
				pageModel.setEquipments(equipment);
				pageModel.setTotalRecords(totalRecords);
				pageModel.setPageNo(pageNo);
				request.setAttribute("pageModel", pageModel);
			 request.getRequestDispatcher("html/device.jsp").forward(request, response);
		 }
		//鍒嗛〉灞曠ず
		 else if("list".equals(param)) {
			int pageNo=Integer.parseInt(request.getParameter("pageNo"));		
			List<Equipment> equipments = equipmentService.queryAllEquipmentsByPageNo(pageNo);//鏌ヨ绗竴椤典俊鎭�
			int totalRecords = equipmentService.querytotalRecords();//鏌ヨ鎬昏褰曟暟
			PageModel pageModel=new PageModel();
			pageModel.setEquipments(equipments);
			pageModel.setTotalRecords(totalRecords);
			pageModel.setPageNo(pageNo);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("html/device.jsp").forward(request,response);
		}
		//鏌ヨ鎵�鏈夋晠闅滅殑鐗╁搧
		else if("destory".equals(param)) {
			List<Equipment> equipments=equipmentService.queryAllDestoried();
			request.setAttribute("equipments", equipments);
			request.getRequestDispatcher("html/main.jsp").forward(request, response);
		}
		//鏌ヨ鎵�鏈夌瓑寰呯淮淇殑鐗╁搧
		else if("repairs".equals(param)) {			
			List<Equipment> equipments=equipmentService.queryAllRepairs();
			request.setAttribute("equipments", equipments);
			request.getRequestDispatcher("html/repair.jsp").forward(request, response);
		}
		//绠＄悊鍛樻彁浜ゆ姤淇俊鎭�
		else if("repair".equals(param)) {		
			int eid=Integer.parseInt(request.getParameter("eid"));			 
			String rtime=null;
			equipmentService.isrepair(eid,rtime);
			request.getRequestDispatcher("equipmentServlet?param=repairs").forward(request, response);
		}
		//淇悊鍛樺弽棣堢淮淇粨鏋�
		else if ("result".equals(param)) {
			int eid=Integer.parseInt(request.getParameter("eid"));
			int statusid;
			int results=Integer.parseInt(request.getParameter("results"));
            if(results==1) {
            	 statusid=1;
            	equipmentService.repairResult(eid, statusid);
            }else {
				statusid=3;
				equipmentService.repairResult(eid, statusid);
			}
            request.getRequestDispatcher("equipmentServlet?param=repairs").forward(request, response);
		}
		//灞曠ず鐗╁搧鐨勭淮淇褰�
		else if("records".equals(param)){
			List<Equipment> equipments=equipmentService.queryAllRecords();
			request.setAttribute("equipments", equipments);
			request.getRequestDispatcher("html/records.jsp").forward(request, response);
		}
	}
     
}
