package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.dao.StudentDao;
import com.ksk.lms.dao.StudentDaoImpl;
import com.ksk.lms.entities.Student;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao = new StudentDaoImpl();

	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAll();
	}

	@Override
	public Student getStudent(int id) {
		return studentDao.get(id);
	}

	@Override
	public void addStudent(Student student) {
		studentDao.insert(student);
	}

}
