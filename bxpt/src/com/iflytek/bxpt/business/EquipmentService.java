package com.iflytek.bxpt.business;

import java.util.List;

import com.iflytek.bxpt.dao.EquipmentDao;
import com.iflytek.bxpt.po.Equipment;

public class EquipmentService {
private EquipmentDao equipmentDao=new EquipmentDao();

public List<Equipment> queryAllEquipments(){
	return equipmentDao.queryAllEquipments();
}

public void addEquipment(Equipment equipment) {
	 equipmentDao.addEquipment( equipment);
}
public void updateEquipment(Equipment equipment){
	equipmentDao.updateEquipment(equipment);
}
public void deleteEquipment(int eid) {
	equipmentDao.deleteEquipment(eid);
}
public List<Equipment>  queryAllEquipmentsByPageNo(int pageNo){
	return equipmentDao.queryAllEquipmentsByPageNo(pageNo);
}
public List<Equipment> searchEquipments(String typeid,String model,String statusid,int pageNo){
    return equipmentDao.searchEquipments(typeid,model, statusid, pageNo);
}
public int querytotalRecords() {
	return equipmentDao.querytotalRecords();
} 
public int querytotalRecords1(String typeid,String model,String statusid) {
	return equipmentDao.querytotalRecords1(typeid, model, statusid);
}
public List<Equipment> queryAllDestoried() {
	return equipmentDao.queryAllDestoried();
}
public List<Equipment> queryAllRepairs() {
	return equipmentDao.queryAllRepairs();
}
public List<Equipment> queryAllRecords() {
	return equipmentDao.queryAllRecords();
}
public void isrepair(int eid,String rtime) {
	equipmentDao.isrepair(eid, rtime);
}
public void repairResult(int eid,int statusid) {
	equipmentDao.repairResult(eid, statusid);
}
public Equipment queryByEid(int eid) {
	return equipmentDao.queryByEid(eid);
}
}
