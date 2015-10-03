package com.tennis.configuration;

import com.tennis.persistence.UserDAO;
import com.tennis.persistence.UserDAOjdbcImpl;
import com.tennis.persistence.UserHibernateImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
	@Bean
	public DataSource dataSource() {
		return  new DriverManagerDataSource();
	}

	@Bean
	public UserDAO userDAO() {
		return new UserDAOjdbcImpl();
	}
}