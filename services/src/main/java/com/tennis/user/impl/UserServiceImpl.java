package com.tennis.user.impl;

import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;
import com.tennis.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		User user = new User("solka", "password");
		user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
		user.setEmail("email@com");
		user.setSex("M");
		userDAO.create(user);
		return userDAO.getAll();
	}
}
