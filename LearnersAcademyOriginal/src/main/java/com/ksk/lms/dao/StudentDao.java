package com.ksk.lms.dao;

import java.util.List;

import com.ksk.lms.entities.Student;

public interface StudentDao {
	public List<Student> getAll();
	public Student get(int tid);
	public void insert(Student student);
	public void update(Student student); 
	public void delete(Student student);
}
