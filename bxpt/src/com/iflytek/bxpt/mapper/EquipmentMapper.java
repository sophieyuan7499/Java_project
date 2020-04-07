package com.iflytek.bxpt.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Repository;

import com.iflytek.bxpt.po.Equipment;

@Repository
public interface EquipmentMapper {
	//��ѯ������Ҫ���޵���Ʒ
	public List<Equipment> queryAllDestoried();
	
	
	
	//��ѯ��������ά�޵���Ʒ��Ϣ
		public List<Equipment> queryAllRepairs() ;
	
		
	
		//չʾ��Ʒ��ά�޼�¼
		public List<Equipment> queryAllRecords();
	
	
		//��ҳչʾ
	
		public List<Equipment> queryAllEquipmentsByPageNo(int pageNo);
	
	
		// ��ѯȫ���ļ�¼
		public int querytotalRecords();
		public Equipment queryAll();
	
	
	
	//����豸
		public void addEquipment(Equipment equipment);
	
	

	// ��ѯ�豸
	public List<Equipment> searchEquipments(@Param("typeid")int typeid, String model, @Param("statusid")int statusid, int pageNo);

	//ɾ��
	public void deleteEquipment(int eid);

	//�޸�
	public void updateEquipment(Equipment equipment);

	

	// ��ѯͨ��eid
	public Equipment queryByEid(int eid);

	
	//ά�޴���
		public void isrepair(@Param("eid")int eid,@Param("rtime")Date rtime);
	// ��ѯȫ���ļ�¼1
	public int querytotalRecords1(String typeid, String model, String statusid);

	public List<Equipment> queryAllEquipments();

	

	


}
