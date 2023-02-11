package com.ksk.lms.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ksk.lms.entities.AcademicClass;
import com.ksk.lms.entities.Student;
import com.ksk.lms.entities.Subject;
import com.ksk.lms.entities.Teacher;
/*
import org.simplilearn.lms.entities.AcademicClass;
import org.simplilearn.lms.entities.Student;
import org.simplilearn.lms.entities.Subject;
import org.simplilearn.lms.entities.Teacher;
*/
import com.ksk.lms.entities.User;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/learnersacademydb");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		configuration.setProperties(properties);
		
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(AcademicClass.class);
		configuration.addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}
}
