package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.dao.SubjectDao;
import com.ksk.lms.dao.SubjectDaoImpl;
import com.ksk.lms.entities.Subject;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDao subjectDao=new SubjectDaoImpl();

	@Override
	public List<Subject> getAllSubject() {
		return subjectDao.getAll();
	}

	@Override
	public Subject getSubject(int id) {
		return subjectDao.get(id);
	}

	@Override
	public void addSubject(Subject subject) {
		subjectDao.insert(subject);
		
	}
	
	
}
