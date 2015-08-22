package com.tennis;

import com.tennis.config.Config;
import com.tennis.domain.User;
import com.tennis.persistent.UserDAO;
import com.tennis.vaidation.UserValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTest {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserValidator userValidator;

	@Test
	public void testGetById() {
		User user = userDAO.getById(12);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		BindingResult result = mock(BindingResult.class); 
		user.setUserName("uranfgh21");
		user.setPassword("passwfgord");
		user.setEmail("some@www.ru");
		userValidator.validate(user, result);  
		//Check validation errors
		if (result.hasErrors()) {
			System.out.println( "addUser");
		}else {
			userDAO.create(user);
		}
	}
}
