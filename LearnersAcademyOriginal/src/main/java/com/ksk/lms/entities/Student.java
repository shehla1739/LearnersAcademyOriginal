package com.ksk.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stuId;
	private String name;
	private String address;
	private int age;
	//class_id -> FK
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="cid")
	private AcademicClass academicClass;
	
	public Student() {
		super();
	}
	public Student(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	//Getters and Setters
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public AcademicClass getAcademicClass() {
		return academicClass;
	}
	public void setAcademicClass(AcademicClass academicClass) {
		this.academicClass = academicClass;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}	
	
}
