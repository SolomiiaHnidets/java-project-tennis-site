package com.tennis.persistance.login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tennis.domain.User;
import com.tennis.persistance.user.UserDAOjdbcImpl;

@Component
public class LoginRecordDaoJdbsImpl implements LoginRecordDao {

	private static final Logger logger = Logger
			.getLogger(UserDAOjdbcImpl.class);

	@Autowired
	private DataSource dataSource;
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
	public void saveToken(Integer userID, String authToken) {
		String query = "insert into athorization_token (userID, token) "
				+ "values (?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int numberOfInsertedRows = 0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, authToken);
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
	public void updateToken(String name, String token) {
		// TODO Auto-generated method stub

	}

}
