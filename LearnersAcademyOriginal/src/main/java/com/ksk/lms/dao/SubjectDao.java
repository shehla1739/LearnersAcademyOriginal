package com.ksk.lms.dao;

import java.util.List;

import com.ksk.lms.entities.Subject;

public interface SubjectDao {
	List<Subject> getAll();
	Subject get(int tid);	
	void insert(Subject subject);
	void update(Subject subject); 
	void delete(Subject subject);
}
