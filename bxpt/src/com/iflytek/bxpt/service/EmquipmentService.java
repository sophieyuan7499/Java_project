package com.iflytek.bxpt.service;

import java.util.Date;
import java.util.List;

import com.iflytek.bxpt.po.Equipment;

public interface EmquipmentService {
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
			

			//����豸
				public void addEquipment(Equipment equipment);
				
				// ��ѯ�豸
				public List<Equipment> searchEquipments(int typeid, String model, int statusid, int pageNo);
				
				//ɾ��
				public void deleteEquipment(int eid);

				//�޸�
				public void updateEquipment(Equipment equipment);
				
				// ��ѯͨ��eid
				public Equipment queryByEid(int eid);
				
				//ά�޴���
				public void isrepair(int eid,Date rtime);

}
