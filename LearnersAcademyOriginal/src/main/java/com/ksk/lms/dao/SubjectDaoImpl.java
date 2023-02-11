package com.ksk.lms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ksk.lms.config.HibConfig;
import com.ksk.lms.entities.Subject;

public class SubjectDaoImpl implements SubjectDao{

	@Override
	public List<Subject> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
	//////In the HQL , you should use the java class name and property name of the mapped @Entity instead of the actual table name and column name , so the HQL should be 
		List<Subject> result = session.createQuery("from Subject", Subject.class).getResultList();
		session.close();
		return result;
		/*
		Query<Subject> query=session.createQuery("select s from com.ksk.lms.entities.Subject s");
		//session.close();
		return query.list();
		*/
	}

	@Override
	public Subject get(int sid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();						
			// start a transaction
			session.beginTransaction();
				
			// get the flight detail object							
			Subject tempSubject = session.get(Subject.class, sid);
								
			session.getTransaction().commit();
							
			// handle connection leak issue
			session.close();							
			factory.close();
					
			return tempSubject;		
		/*
		Subject subject=session.get(Subject.class, sid);
		//session.close();
		return subject;*/
	}

	@Override
	public void insert(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
		//	session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
		//	session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(subject);
			tx.commit();
		//	session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
