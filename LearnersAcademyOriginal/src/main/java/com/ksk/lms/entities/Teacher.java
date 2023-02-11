package com.ksk.lms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int tid;
	private String name;
	private String address;
	private String designation;
	private String skill;
	
	//@OneToMany(mappedBy="teacher")
	@OneToMany(mappedBy = "teacher", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH },fetch=FetchType.EAGER)	
	private Set<Subject> subjects=new HashSet<>();
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String address, String designation, String skill) {
		super();
		this.name = name;
		this.address = address;
		this.designation = designation;
		this.skill = skill;
	}


	//getters and setters
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	//helper method
	public void addSubject(Subject tempSubject) {
		subjects.add(tempSubject);
		tempSubject.setTeacher(this);
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", address=" + address + ", designation=" + designation
				+ ", skill=" + skill + "]";
	}
		
}
