package com.ksk.lms.service;

import java.util.List;

import com.ksk.lms.entities.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public Student getStudent(int id);
	public void addStudent(Student student);
}
