package com.iflytek.bxpt.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytek.bxpt.po.Equipment;
import com.iflytek.bxpt.service.EmquipmentServiceImpl;
import com.iflytek.bxpt.util.PageModel;

@Controller

public class EquipmentServlet {
	@Autowired
 	EmquipmentServiceImpl e;
	
	
	
	@RequestMapping("equipmentServlet")
	public String All(ModelMap map,String param,String pageNo,String eid,String model,String number,String typeid,String brandsid,String address,String buydate,String statusid) {
		if("repairs".equals(param)) {
	List<Equipment> rEquipments=	e.queryAllRepairs();
		map.addAttribute("repairs",rEquipments);
		return "repair";
		}else if("destory".equals(param)) {
			List<Equipment > rEquipments2 =e.queryAllDestoried();
			map.addAttribute("destory",rEquipments2);
			return "main";
		}else if("records".equals(param)) {
			List<Equipment > rEquipments3 =e.queryAllRecords();
			map.addAttribute("records",rEquipments3);
			return "records";
		}else if("list".equals(param)){
			
			int a=Integer.parseInt(pageNo);
			List<Equipment> equipments  =e.queryAllEquipmentsByPageNo(a);
			
			int totalRecords=e.querytotalRecords();
			PageModel pageModel=new PageModel();
			pageModel.setEquipments(equipments );
			pageModel.setTotalRecords(totalRecords);
			
			pageModel.setPageNo(a);
			map.addAttribute("pageModel",pageModel);
			
			return "device";
		}else if("add".equals(param)){
			 
		
			 int b=Integer.parseInt(typeid);
			 int c=Integer.parseInt(brandsid);
			 int d=Integer.parseInt(statusid);
			 System.out.println(buydate);
			 Date buydate1=Date.valueOf(buydate);
			 
			 
				Equipment equipment=new Equipment( model, number, b,  c,  address, buydate1, d);
			 System.out.println(equipment);
			 e.addEquipment(equipment);
			 
			 
			 return "addform"; 
		}else if("search".equals(param)){
			int a=Integer.parseInt(pageNo);
			 int b=Integer.parseInt(typeid);
			 int d=Integer.parseInt(statusid);
	List<Equipment>		equipments= e.searchEquipments(b, model, d, a);
	int totalRecords=e.querytotalRecords();
	PageModel pageModel=new PageModel();
	pageModel.setEquipments(equipments );
	pageModel.setTotalRecords(totalRecords);
	
	pageModel.setPageNo(a);
	map.addAttribute("pageModel",pageModel);
	
			return "device";
		}else if("delete".equals(param)){
			
			int f=Integer.parseInt(eid);
			e.deleteEquipment(f);
			
			
			return "redirect:equipmentServlet?param=list&pageNo=1";
		}else if("modify".equals(param)){
			int a=Integer.parseInt(eid);
		Equipment equipment=	e.queryByEid(a);
		map.addAttribute("equipment",equipment);
			
			return "updateform";
		}else if("update".equals(param)){
			int a=Integer.parseInt(eid);
			 int b=Integer.parseInt(typeid);
			 int c=Integer.parseInt(brandsid);
			 int d=Integer.parseInt(statusid);
			 System.out.println(buydate);
			 Date buydate1=Date.valueOf(buydate);
			 
			 
				Equipment equipment=new Equipment(a, model, number, b, c, address, buydate1, d);
				e.updateEquipment(equipment);
			
			return "redirect:equipmentServlet?param=list&pageNo=1";
		}else {
			
			int a=Integer.parseInt(eid);
			e.isrepair(a, new java.util.Date());
			
			return "redirect:equipmentServlet?param=repairs";
		}
	}

	
}
