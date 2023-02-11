package com.ksk.lms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String name;
	private int duration;
		
	@OneToMany(mappedBy = "academicClass", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH },fetch=FetchType.EAGER)
	private Set<Student> students=new HashSet<>();	
	/*
	//many-classes many-subject
	@ManyToMany
	@JoinTable(name="Subject_Class",
	joinColumns=@JoinColumn(name="cid"),
	inverseJoinColumns=@JoinColumn(name="sid"))
	private Set<Subject> subjects = new HashSet<>();			
	*/

	public AcademicClass() {
		super();
	}
	
	public AcademicClass(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}	

	//getters and  setters
	public int getCid() {
		return cid;
	}		

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	//helper methods one-to-many
		public void addStudent(Student tempStudent) {
			students.add(tempStudent);
			tempStudent.setAcademicClass(this);
	}
/*
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	*/

		@Override
		public String toString() {
			return "AcademicClass [cid=" + cid + ", name=" + name + ", duration=" + duration + "]";
		}
		
}
