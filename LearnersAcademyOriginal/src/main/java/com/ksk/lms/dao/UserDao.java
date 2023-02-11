package com.ksk.lms.dao;

import com.ksk.lms.entities.User;

public interface UserDao {
	void insert(User user);
	User get(String username,String password);
	void update(User user);
}
