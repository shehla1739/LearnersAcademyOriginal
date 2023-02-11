package com.ksk.lms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.ksk.lms.config.HibConfig;
import com.ksk.lms.entities.Student;


public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		//In the HQL , you should use the java class name and property name of the mapped @Entity instead of the actual table name and column name , so the HQL should be 
		List<Student> result = session.createQuery("from Student", Student.class).getResultList();
		session.close();
		return result;
		/*
		Query<Student> query=session.createQuery("select s from com.ksk.lms.entities.Student s");
		session.close();
		return query.list();*/
	}

	@Override
	public Student get(int stuId) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();						
			// start a transaction
			session.beginTransaction();
				
			// get the flight detail object							
			Student tempStudent = session.get(Student.class, stuId);
								
			session.getTransaction().commit();
							
			// handle connection leak issue
			session.close();							
			factory.close();
					
			return tempStudent;			
		
		/*
		Student student=session.get(Student.class, stuId);
		session.close();
		return student;*/
	}

	
	@Override
	public void insert(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(student);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}

}
