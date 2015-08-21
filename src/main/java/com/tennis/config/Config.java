package com.tennis.config;

import com.tennis.persistent.UserDAO;
import com.tennis.persistent.UserDAOjdbcImpl;
import com.tennis.vaidation.UserValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/WebSite");
		dataSource.setUsername("postgres");
		dataSource.setPassword("solka1627");
		return dataSource;
	}

	@Bean
	public UserDAO userDAO() {
		return new UserDAOjdbcImpl();
	}
	
	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}
}