package com.ksk.lms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ksk.lms.config.HibConfig;
import com.ksk.lms.entities.AcademicClass;


public class AcademicClassDaoImpl implements AcademicClassDao{

	@Override
	public List<AcademicClass> getAll() {
	SessionFactory factory=HibConfig.getSessionFactory();
	Session session=factory.openSession();
	//In the HQL , you should use the java class name and property name of the mapped @Entity instead of the actual table name and column name , so the HQL should be 
	List<AcademicClass> result = session.createQuery("from AcademicClass", AcademicClass.class).getResultList();
	session.close();
	return result;
		/*
		Query<AcademicClass> query=session.createQuery("select c from com.ksk.lms.entities.AcademicClass c");
		session.close();
		return query.list();*/
	}

	@Override
	public AcademicClass get(int cid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
						
		// start a transaction
		session.beginTransaction();
				
		// get the airline detail object							
		AcademicClass tempAcademicClass = session.get(AcademicClass.class, cid);
							
		session.getTransaction().commit();

		// handle connection leak issue
		session.close();							
		factory.close();
							
		return tempAcademicClass;
		/*
		AcademicClass academicClass=session.get(AcademicClass.class, cid);
		session.close();
		return academicClass; */
	}

	@Override
	public void insert(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(academicClass);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(academicClass);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(academicClass);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}
}
