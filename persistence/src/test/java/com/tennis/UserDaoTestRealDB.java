package com.tennis;

import com.tennis.configuration.Config;
import com.tennis.domain.User;
import com.tennis.persistence.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTestRealDB {

	int userID = 1;
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testGetByIdExpectedNoUserFound() {
		User user = userDAO.getById(userID);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		User user = new User("solyap", "some");
		user.setBirthDate("768976");
		user.setEmail("ghjk");
		user.setSex("M");
		userDAO.create(user);
		user.setUserName("solya");
		user.setPassword("password");
		userDAO.create(user);
	}

	@Test
	public void testGetById() {
		User user = userDAO.getById(userID);
		System.out.println(user);
	}

	@Test
	public void testDeleteUser() {
		userDAO.delete(userID);
	}
}