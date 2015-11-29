package com.tennis.persistance.login;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tennis.configuration.Config;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class LoginRecordDaoTest {

	@Autowired
	LoginRecordDao login;

	private static final String USER_NAME = "solomka";
	private static final String PASSWORD = "pass";
	private static final String SEX = "F";
	private static final String EMAIL = "somemail@ru.com";
	private static final String TEST_TOKEN = "0878027b-0f25-40b1-8281-beaf4643460e";

	private User createUserDto() {
		User user = new User();
		user.setUserName(USER_NAME);
		user.setEmail(EMAIL);
		user.setSex(SEX);
		user.setPassword(PASSWORD);
		user.setUserID(4);
		return user;
	}

	@Test
	public void testSaveToken() {
		User user = createUserDto();
		AuthorizationToken userToken = new AuthorizationToken();
		userToken.setToken(TEST_TOKEN);
		userToken.setUserID(user.getUserID());
		login.saveToken(userToken);
	}

	@Test
	public void testGetLoginRecord() {
		AuthorizationToken userToken = login.getLoginRecord(TEST_TOKEN);
		assertEquals(TEST_TOKEN, userToken.getToken());
	}

	@Test
	public void testDeleteToken() {
		User user = createUserDto();
		AuthorizationToken userToken = new AuthorizationToken();
		userToken.setToken(TEST_TOKEN);
		userToken.setUserID(user.getUserID());
		login.deleteToken(userToken);
	}
}
