package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.dao.AcademicClassDao;
import com.ksk.lms.dao.AcademicClassDaoImpl;
import com.ksk.lms.entities.AcademicClass;

public class AcademicClassServiceImpl implements AcademicClassService{
	AcademicClassDao academicClassDao = new AcademicClassDaoImpl();

	@Override
	public List<AcademicClass> getAllAcademicClass() {
		return academicClassDao.getAll();
	}

	@Override
	public AcademicClass getAcademicClass(int id) {
		return academicClassDao.get(id);
	}

	@Override
	public void addAcademicClass(AcademicClass academicClass) {
		academicClassDao.insert(academicClass);		
	}

}
