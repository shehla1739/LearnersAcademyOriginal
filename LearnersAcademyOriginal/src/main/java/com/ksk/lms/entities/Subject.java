package com.ksk.lms.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String name;
	
	/*
	//many subjects many-classes
	@ManyToMany
	@JoinTable(name="Subject_Class",
	joinColumns=@JoinColumn(name="sid"),
	inverseJoinColumns=@JoinColumn(name="cid"))
	private Set<AcademicClass> acdClasses;
	*/

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="tid")
	private Teacher teacher;

	public Subject() {
		super();
	}

	public Subject(String name) {
		super();
		this.name = name;
	}	

	//getters and  setters
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/*
	 	public Set<AcademicClass> getAcdClasses() {
		return acdClasses;
	}

	public void setAcdClasses(Set<AcademicClass> acdClasses) {
		this.acdClasses = acdClasses;
	}
	 */
}
