package com.ksk.lms.dao;

import java.util.List;

import com.ksk.lms.entities.Teacher;

public interface TeacherDao {
	
	public List<Teacher> getAll();
	Teacher get(int tid);
	//Teacher get(String tname);
	void insert(Teacher teacher);
	void update(Teacher teacher); 
	void delete(Teacher teacher);
	
}
