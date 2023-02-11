package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.dao.TeacherDao;
import com.ksk.lms.dao.TeacherDaoImpl;
import com.ksk.lms.entities.Teacher;

public class TeacherServiceImpl implements TeacherService{
	TeacherDao teacherDao = new TeacherDaoImpl();
	@Override
	public List<Teacher> getAllTeacher() {
		return teacherDao.getAll();
	}

	@Override
	public Teacher getTeacher(int id) {
		return teacherDao.get(id);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.insert(teacher);
	}
	
}
