package com.tennis.user.impl;

import com.tennis.configuration.Config;
import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;
import com.tennis.user.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration(classes = Config.class)
public class UserServiceImpl implements UserService {

	// private static final Logger logger = Logger
	// .getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}
}
