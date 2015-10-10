package com.tennis.persistence;

import com.tennis.domain.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOjdbcImpl implements UserDAO {

	private static final Logger logger = Logger
			.getLogger(UserDAOjdbcImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public User getById(int id) {
		String query = "select * from Users where userID = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(id);
					user.setUserName(resultSet.getString("userName"));
					logger.info("User Found:" + user);
				} else {
					logger.info("No User found with id=" + id);
				}
			} finally {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		String query = "select * from Users";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			try {
				while (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(resultSet.getInt("userID"));
					user.setUserName(resultSet.getString("userName"));
				}
				users.add(user);
			} finally {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	@Override
	public User getByName(String name) {
		String query = "select userName from Users where userName = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(resultSet.getInt("userID"));
					user.setUserName(name);
					logger.info("User Found:" + user);
				} else {
					logger.info("No User found with name=" + name);
				}
			} finally {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void create(User user) {
		String query = "insert into Users (userName, password, email, birthdate, sex) "
				+ "values (?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int numberOfInsertedRows = 0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setDate(4, (Date) user.getBirthDate());
			preparedStatement.setString(5, user.getSex());
			numberOfInsertedRows = preparedStatement.executeUpdate();
			if (numberOfInsertedRows == 0) {
				logger.info("Rows did not inserted!");
			} else {
				logger.info("Inserted:" + numberOfInsertedRows + " rows");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int id) {
		String query = "delete from Users where userID = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int numberOfInsertedRows = 0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			numberOfInsertedRows = preparedStatement.executeUpdate();
			if (numberOfInsertedRows == 0) {
				logger.info("Rows did not deleted!");
			} else {
				logger.info("Deleted Record with ID = " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
