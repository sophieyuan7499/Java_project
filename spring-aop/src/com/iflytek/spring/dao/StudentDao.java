package com.iflytek.spring.dao;

import java.util.List;

import com.iflytek.spring.entity.Student;

public interface StudentDao {
	void add(Student stu);
	void delete(Student stu);
	void update(Student stu);
	List<Student> queryAll();
}
