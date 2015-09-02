package com.tennis.user.impl;

import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;
import com.tennis.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}
}
