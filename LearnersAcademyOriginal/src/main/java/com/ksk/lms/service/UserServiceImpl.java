package com.ksk.lms.service;

import com.ksk.lms.dao.UserDao;
import com.ksk.lms.dao.UserDaoImpl;
import com.ksk.lms.entities.User;

public class UserServiceImpl implements UserService{
	UserDao userDao=new UserDaoImpl();
	@Override
	public void insert(User user) {
		
		userDao.insert(user);
	}

	@Override
	public User get(String username, String password) {
		
		return userDao.get(username, password);
	}

	@Override
	public void updatePassword(String username, String password, String newPassword) {
		User user = userDao.get(username, password);
		user.setPassword(newPassword);
		userDao.update(user);
		
	}

}
