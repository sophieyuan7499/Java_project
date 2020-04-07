package com.iflytek.bxpt.service;

import java.util.Date;
import java.util.List;

import com.iflytek.bxpt.po.Equipment;

public interface EmquipmentService {
	//查询所有需要报修的物品
		public List<Equipment> queryAllDestoried();
		
		
		
		//查询所有正在维修的物品信息
			public List<Equipment> queryAllRepairs() ;
		
			
		
			//展示物品的维修记录
			public List<Equipment> queryAllRecords();
		
		
			//分页展示
		
			public List<Equipment> queryAllEquipmentsByPageNo(int pageNo);
			
			// 查询全部的记录
			public int querytotalRecords();
			

			//添加设备
				public void addEquipment(Equipment equipment);
				
				// 查询设备
				public List<Equipment> searchEquipments(int typeid, String model, int statusid, int pageNo);
				
				//删除
				public void deleteEquipment(int eid);

				//修改
				public void updateEquipment(Equipment equipment);
				
				// 查询通过eid
				public Equipment queryByEid(int eid);
				
				//维修处理
				public void isrepair(int eid,Date rtime);

}
