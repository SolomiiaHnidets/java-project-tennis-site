package com.tennis;

import com.tennis.config.Config;
import com.tennis.domain.User;
import com.tennis.persistent.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTest {

	@Autowired
	private UserDAO userDAO;

	@Test
	public void testGetById() {
		User user = userDAO.getById(12);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUserName("uran");
		user.setPassword("password");
		user.setEmail("some@www");
		userDAO.create(user);
	}
}
