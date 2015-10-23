package com.tennis;

import com.tennis.configuration.*;
import com.tennis.domain.User;
import com.tennis.persistance.user.UserDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTestRealDB {

	private final int userID = 1;
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
		user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
		user.setEmail("ghjk");
		user.setSex("M");
		userDAO.create(user);
		user.setUserName("solya");
		user.setPassword("password");
		userDAO.create(user);
	}

	@Test
	// TODO expected exception
	public void testInsertExistingUser() {
		User user = new User("solya", "some");
		user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
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
	public void testGetAll() {
		List<User> users = new ArrayList<User>();
		users = userDAO.getAll();
	}

	@Test
	public void testDeleteUser() {
		userDAO.delete(userID);
	}
}