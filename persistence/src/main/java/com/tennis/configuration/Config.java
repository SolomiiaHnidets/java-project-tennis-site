package com.tennis.configuration;

import com.tennis.persistance.*;
import com.tennis.persistance.user.UserDAO;
import com.tennis.persistance.user.UserDAOjdbcImpl;
import com.tennis.persistance.user.UserHibernateImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/user.properties")
public class Config {

	@Autowired
	private Environment environment;

	public static final String DB_DRIVER_CLASSNAME = "database.driverClassName";
	public static final String DB_URL = "database.url";
	public static final String DB_USERNAME = "database.username";
	public static final String DB_PASSWORD = "database.password";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getProperty(DB_DRIVER_CLASSNAME));
		dataSource.setUrl(environment.getProperty(DB_URL));
		dataSource.setUsername(environment.getProperty(DB_USERNAME));
		dataSource.setPassword(environment.getProperty(DB_PASSWORD));
		return dataSource;
	}

	@Bean
	public UserDAO userDAO() {
		return new UserDAOjdbcImpl();
	}

	@Bean
	public UserDAO userHibernate() {
		return new UserHibernateImpl();
	}
}