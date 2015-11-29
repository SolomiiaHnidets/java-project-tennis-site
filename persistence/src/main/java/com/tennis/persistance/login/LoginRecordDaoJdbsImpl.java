package com.tennis.persistance.login;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tennis.domain.AuthorizationToken;
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
	public void saveToken(AuthorizationToken authToken) {
		String query = "insert into athorization_token (userID, token) "
				+ "values (?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int numberOfInsertedRows = 0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, authToken.getUserID());
			preparedStatement.setString(2, authToken.getToken());
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
	public AuthorizationToken getLoginRecord(String authToken) {
		String query = "select * from athorization_token where token = ?";
		AuthorizationToken loginRecord = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, authToken);
			ResultSet resultSet = preparedStatement.executeQuery();
			try {
				if (resultSet.next()) {
					loginRecord = new AuthorizationToken();
					loginRecord.setToken(authToken);
					loginRecord.setUserID(resultSet.getInt("userID"));
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
		return loginRecord;
	}

	@Override
	public void deleteToken(AuthorizationToken authToken) {
		String query = "delete from athorization_token where userID = ? and token = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, authToken.getUserID());
			preparedStatement.setString(2, authToken.getToken());
			preparedStatement.executeUpdate();
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
