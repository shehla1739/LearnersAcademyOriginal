package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.entities.Subject;

public interface SubjectService {
	public List<Subject> getAllSubject();
	public Subject getSubject(int id);
	public void addSubject(Subject subject);
}
