package com.iflytek.bxpt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.bxpt.mapper.EquipmentMapper;
import com.iflytek.bxpt.po.Equipment;

@Service
public class EmquipmentServiceImpl implements EmquipmentService{
	@Autowired
	private EquipmentMapper equipmentMapper;
	
	
	@Override
	public List<Equipment> queryAllDestoried() {
		// TODO Auto-generated method stub
		return equipmentMapper.queryAllDestoried();
	}

	@Override
	public List<Equipment> queryAllRepairs() {
		// TODO Auto-generated method stub
		return equipmentMapper.queryAllRepairs();
	}

	@Override
	public List<Equipment> queryAllRecords() {
		// TODO Auto-generated method stub
		return equipmentMapper.queryAllRecords();
	}

	@Override
	public List<Equipment> queryAllEquipmentsByPageNo(int pageNo) {
		// TODO Auto-generated method stub
		return equipmentMapper.queryAllEquipmentsByPageNo(pageNo);
	}

	@Override
	public int querytotalRecords() {
		// TODO Auto-generated method stub
		return equipmentMapper.querytotalRecords();
	}

	@Override
	public void addEquipment(Equipment equipment) {
		
		 equipmentMapper.addEquipment(equipment);
		
	}

	@Override
	public List<Equipment> searchEquipments(int typeid, String model, int statusid, int pageNo) {
		// TODO Auto-generated method stub
		return equipmentMapper.searchEquipments(typeid, model, statusid, pageNo);
	}

	@Override
	public void deleteEquipment(int eid) {
		// TODO Auto-generated method stub
		equipmentMapper.deleteEquipment(eid);
	}

	@Override
	public void updateEquipment(Equipment equipment) {
		equipmentMapper.updateEquipment(equipment);
		
	}

	@Override
	public Equipment queryByEid(int eid) {
		// TODO Auto-generated method stub
		return equipmentMapper.queryByEid(eid);
	}

	@Override
	public void isrepair(int eid, Date rtime) {
		// TODO Auto-generated method stub
		equipmentMapper.isrepair(eid, rtime);
	}

}
