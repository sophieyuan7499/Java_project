package com.iflytek.spring.dao.impl;

import java.util.List;

import com.iflytek.spring.dao.StudentDao;
import com.iflytek.spring.entity.Student;

/**
 * 学生数据持久化类
 * @author DingXin
 *
 */
public class StudentDaoImpl implements StudentDao {

	/**
	 * 添加学生,将学生添加到数据库中,此方法仅仅模拟
	 */
	@Override
	public void add(Student stu) {
		System.out.printf("添加%s成功...\n",stu.getName());
		
	}

	/**
	 * 删除学生,将学生从数据库中删除,此方法仅仅模拟
	 */
	@Override
	public void delete(Student stu) {
		System.out.printf("刪除%s成功...\n",stu.getName());
		
	}
	/**
	 * 修改学生,将学生信息更新到数据库中,此方法仅仅模拟
	 */
	@Override
	public void update(Student stu) {
		System.out.printf("修改%s成功...\n",stu.getName());
		
	}

	/**
	 * 获取所有学生信息,此方法仅仅模拟
	 */
	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
