package com.iflytek.bxpt.mapper;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.iflytek.bxpt.mapper.EquipmentMapper;
import com.iflytek.bxpt.po.Equipment;
public class EquipmentMapperTest {
	

	private  EquipmentMapper equipmentMapper;
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml",
				"spring/spring-mybatis.xml");
		this.equipmentMapper = context.getBean(EquipmentMapper.class);
	}

	@Test
	public void testQueryUserAll() {
		//System.out.println(this.equipmentMapper.queryAll());
		//System.out.println(this.equipmentMapper.queryAllDestoried());
		//System.out.println(this.equipmentMapper.queryAllEquipmentsByPageNo(1));
		//System.out.println(this.equipmentMapper.querytotalRecords());
		//System.out.println(this.equipmentMapper.searchEquipments(1, "E430", 2, 1));
		//this.equipmentMapper.deleteEquipment(8);
		//Equipment equipment=new Equipment(1,"sdsa",2,4,5,"ddd","2016-5-12",1);
		//System.out.println(this.equipmentMapper.queryByEid(1));
	
		equipmentMapper.isrepair(1, new Date());
	}
}
