package com.tennis.persistance.user;

import com.tennis.domain.User;
import com.tennis.util.PasswordEncoder;

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
		String query = "select * from Users where userName = ?";
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
					user.setEmail(resultSet.getString("email"));
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
	public User getByEmail(String email) {
		String query = "select * from Users where email = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(resultSet.getInt("userID"));
					user.setEmail(email);
					logger.info("User Found:" + user);
				} else {
					logger.info("No User found with email=" + email);
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
	public User getByEmailAndPassword(String email, String password) {
		String query = "select * from Users where email = ? and password = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(resultSet.getInt("userID"));
					user.setEmail(email);
					logger.info("User Found:" + user);
				} else {
					logger.info("No User found");
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
	public User getByNameAndPassword(String name, String password) {
		String query = "select * from Users where userName = ? and password = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					user = new User(resultSet.getString("userName"),
							resultSet.getString("password"));
					user.setUserID(resultSet.getInt("userID"));
					user.setEmail(resultSet.getString("email"));
					logger.info("User Found:" + user);
				} else {
					logger.info("No User found");
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
			String hashedPassword = PasswordEncoder.encrypt(user
					.getPassword());
			preparedStatement.setString(2, hashedPassword);
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

	// @Override
	// public void updateToken(String name, String token) {
	// String query = "UPDATE Users SET authToken = ? where userName = ? ";
	// Connection connection = null;
	// PreparedStatement preparedStatement = null;
	// try {
	// connection = dataSource.getConnection();
	// preparedStatement = connection.prepareStatement(query);
	// preparedStatement.setString(1, token);
	// preparedStatement.setString(2, name);
	// // call executeUpdate to execute our sql update statement
	// preparedStatement.executeUpdate();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// preparedStatement.close();
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }

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
