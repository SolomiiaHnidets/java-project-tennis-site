package com.db.dao;

import com.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	@Autowired
	DataSource dataSource;

	public User getById(int id) {
		String query = "select userName from Users where id = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setUserID(id);
				user.setUserName(resultSet.getString("userName"));
				//user.setRole(rs.getString("role"));
				System.out.println("User Found::" + user);
			} else {
				System.out.println("No User found with id=" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
