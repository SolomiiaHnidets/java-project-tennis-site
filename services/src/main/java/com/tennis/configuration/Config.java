package com.tennis.configuration;

import com.tennis.persistence.*;
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
}