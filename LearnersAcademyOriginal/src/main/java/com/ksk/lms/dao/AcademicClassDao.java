package com.ksk.lms.dao;

import java.util.List;

import com.ksk.lms.entities.AcademicClass;

public interface AcademicClassDao {
	List<AcademicClass> getAll();
	AcademicClass get(int cid);
	void insert(AcademicClass academicClass);
	void update(AcademicClass academicClass); 
	void delete(AcademicClass academicClass);
}
