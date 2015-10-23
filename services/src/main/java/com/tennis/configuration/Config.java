package com.tennis.configuration;

import com.tennis.authentication.AuthenticationServiceImpl;
import com.tennis.persistance.login.LoginRecordDao;
import com.tennis.persistance.login.LoginRecordDaoJdbsImpl;
import com.tennis.persistance.user.UserDAO;
import com.tennis.persistance.user.UserDAOjdbcImpl;
import com.tennis.persistance.user.UserHibernateImpl;

import org.springframework.context.annotation.*;

@Configuration
public class Config {

	@Bean
	public UserDAO userDAO() {
		return new UserDAOjdbcImpl();
	}

	@Bean
	public UserDAO userHibernate() {
		return new UserHibernateImpl();
	}

	// @Bean
	// public AuthenticationServiceImpl authenticationService() {
	// return new AuthenticationServiceImpl();
	// }

	@Bean
	public LoginRecordDao loginRecord() {
		return new LoginRecordDaoJdbsImpl();
	}
}