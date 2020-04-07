package com.iflytek.spring.service;

import com.iflytek.spring.entity.Student;

public interface StudentService {
	void addStudent(Student stu);
	void deleteStudent(Student stu);
	void updateStudent(Student stu);
}
