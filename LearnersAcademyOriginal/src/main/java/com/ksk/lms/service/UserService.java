package com.ksk.lms.service;

import com.ksk.lms.entities.User;

public interface UserService {
	void insert(User user);
	User get(String username, String password);
	void updatePassword(String username,String password,String newPassword);

}
