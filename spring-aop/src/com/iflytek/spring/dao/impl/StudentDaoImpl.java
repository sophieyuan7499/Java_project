package com.iflytek.spring.dao.impl;

import java.util.List;

import com.iflytek.spring.dao.StudentDao;
import com.iflytek.spring.entity.Student;

/**
 * ѧ�����ݳ־û���
 * @author DingXin
 *
 */
public class StudentDaoImpl implements StudentDao {

	/**
	 * ���ѧ��,��ѧ����ӵ����ݿ���,�˷�������ģ��
	 */
	@Override
	public void add(Student stu) {
		System.out.printf("���%s�ɹ�...\n",stu.getName());
		
	}

	/**
	 * ɾ��ѧ��,��ѧ�������ݿ���ɾ��,�˷�������ģ��
	 */
	@Override
	public void delete(Student stu) {
		System.out.printf("�h��%s�ɹ�...\n",stu.getName());
		
	}
	/**
	 * �޸�ѧ��,��ѧ����Ϣ���µ����ݿ���,�˷�������ģ��
	 */
	@Override
	public void update(Student stu) {
		System.out.printf("�޸�%s�ɹ�...\n",stu.getName());
		
	}

	/**
	 * ��ȡ����ѧ����Ϣ,�˷�������ģ��
	 */
	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
