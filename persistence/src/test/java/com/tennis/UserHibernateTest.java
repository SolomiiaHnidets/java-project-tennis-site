package com.tennis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tennis.configuration.Config;
import com.tennis.domain.User;
import com.tennis.persistance.user.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserHibernateTest {

	@Autowired
	private UserDAO userHibernate;

	private static final String USER_NAME = "solomiya";
	private static final String PASSWORD = "password";
	private static final String SEX = "F";
	private static final String EMAIL = "some@ru.com";

	@Test
	public void testCreate() {
		User user = new User();
		user.setUserName(USER_NAME);
		user.setPassword(PASSWORD);
		user.setEmail(EMAIL);
		user.setSex(SEX);
		user.setUserID(4);
		userHibernate.create(user);
	}
}
