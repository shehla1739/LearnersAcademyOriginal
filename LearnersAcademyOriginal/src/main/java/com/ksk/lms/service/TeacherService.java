package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.entities.Teacher;

public interface TeacherService {
	public List<Teacher> getAllTeacher();
	public Teacher getTeacher(int id);
	public void addTeacher(Teacher teacher);
}
