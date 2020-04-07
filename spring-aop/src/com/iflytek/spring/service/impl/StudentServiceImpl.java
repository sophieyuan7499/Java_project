package com.iflytek.spring.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iflytek.spring.dao.StudentDao;
import com.iflytek.spring.entity.Student;
import com.iflytek.spring.service.StudentService;
/**
 * ѧ��������,����ѧ����ɾ�Ĳ����ҵ��
 * @author DingXin
 *
 */
public class StudentServiceImpl implements StudentService {
	/**
	 * ѧ�����ݷ��ʽӿ���
	 */
	private StudentDao studentDao;
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * ���ѧ��ҵ��
	 */
	@Override
	public void addStudent(Student stu) {
		//��ʼʱ��
		studentDao.add(stu);
		
	}

	/**
	 * ɾ��ѧ��ҵ��
	 */
	@Override
	public void deleteStudent(Student stu) {
		studentDao.delete(stu);
	}

	/**
	 * �޸�ѧ��ҵ��
	 */
	@Override
	public void updateStudent(Student stu) {
		studentDao.update(stu);

	}

}
