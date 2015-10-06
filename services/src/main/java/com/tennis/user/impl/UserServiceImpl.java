package com.tennis.user.impl;

//import com.tennis.configuration.Config;

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

	// private static final Logger logger = Logger
	// .getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}
}
