package com.ksk.lms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.ksk.lms.config.HibConfig;
import com.ksk.lms.entities.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Teacher> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		///In the HQL , you should use the java class name and property name of the mapped @Entity instead of the actual table name and column name , so the HQL should be 
		List<Teacher> result = session.createQuery("from Teacher", Teacher.class).getResultList();
		session.close();
		return result;
		/*
		Query<Teacher> query=session.createQuery("select t from com.ksk.lms.entities.Teacher t");
		session.close();
		return query.list();
		*/
	
	}

	@Override
	public Teacher get(int tid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
								
		// start a transaction
		session.beginTransaction();				
		// get the airline detail object							
		Teacher tempTeacher = session.get(Teacher.class, tid);	
		
        session.getTransaction().commit();
												
		// handle connection leak issue
		session.close();							
		factory.close();
		return tempTeacher;
						
		/*
		Teacher teacher=session.get(Teacher.class, tid);
		session.close();
		return teacher;
		*/
	}
	
	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}

}
