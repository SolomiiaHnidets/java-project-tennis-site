package com.tennis.persistane;

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

	@Autowired
	private UserDAO userDAO;

	private static final int USER_ID = 1;
	private static final String USER_NAME = "solomiya";
	private static final String PASSWORD = "password";
	private static final String SEX = "F";
	private static final String EMAIL = "some@ru.com";

	@Test
	public void testGetByIdExpectedNoUserFound() {
		User user = userDAO.getById(USER_ID);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		User user = new User(USER_NAME, PASSWORD);
		user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
		user.setEmail(EMAIL);
		user.setSex(SEX);
		userDAO.create(user);
		user.setUserName(USER_NAME);
		user.setPassword(PASSWORD);
		userDAO.create(user);
	}

	@Test
	// TODO expected exception
	public void testInsertExistingUser() {
		User user = new User(USER_NAME, PASSWORD);
		user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
		user.setEmail(EMAIL);
		user.setSex(SEX);
		userDAO.create(user);
		user.setUserName(USER_NAME);
		user.setPassword(PASSWORD);
		userDAO.create(user);
	}

	@Test
	public void testGetById() {
		User user = userDAO.getById(USER_ID);
		// TODO
		System.out.println(user);
	}

	@Test
	public void testGetAll() {
		List<User> users = new ArrayList<User>();
		users = userDAO.getAll();
	}

	@Test
	public void testDeleteUser() {
		userDAO.delete(USER_ID);
	}
}