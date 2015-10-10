package com.tennis;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;

import com.tennis.configuration.Config;
import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;
import com.tennis.persistence.UserHibernateImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserHibernateTest {

	@Autowired
	private UserDAO userHibernate;

	@Test
	public void testCreate() {
		User user = new User();
		user.setUserName("uranfgh21");
		user.setPassword("passwfgord");
		user.setEmail("some@www.ru");
		userHibernate.create(user);
	}
}
