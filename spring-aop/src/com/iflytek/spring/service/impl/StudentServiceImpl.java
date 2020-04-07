package com.iflytek.spring.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iflytek.spring.dao.StudentDao;
import com.iflytek.spring.entity.Student;
import com.iflytek.spring.service.StudentService;
/**
 * 学生服务类,负责学生增删改查相关业务
 * @author DingXin
 *
 */
public class StudentServiceImpl implements StudentService {
	/**
	 * 学生数据访问接口类
	 */
	private StudentDao studentDao;
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 添加学生业务
	 */
	@Override
	public void addStudent(Student stu) {
		//开始时间
		studentDao.add(stu);
		
	}

	/**
	 * 删除学生业务
	 */
	@Override
	public void deleteStudent(Student stu) {
		studentDao.delete(stu);
	}

	/**
	 * 修改学生业务
	 */
	@Override
	public void updateStudent(Student stu) {
		studentDao.update(stu);

	}

}
