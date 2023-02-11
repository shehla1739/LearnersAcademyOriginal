package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.entities.AcademicClass;

public interface AcademicClassService {
	public List<AcademicClass> getAllAcademicClass();
	public AcademicClass getAcademicClass(int id);
	public void addAcademicClass(AcademicClass academicClass);

}
