package com.ksk.lms.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.ksk.lms.config.HibConfig;

import com.ksk.lms.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}		
	}

	@Override
	public User get(String username, String password) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<User> query=session.createQuery("select u from com.ksk.lms.entities.User u where u.username=?1 and u.password=?2");
		query.setParameter(1, username);
		query.setParameter(2, password);
		return query.getSingleResult();		
	}

	@Override
	public void update(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
