package com.db.dao.implementation;

import com.dao.model.User;
import com.db.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOjdbc implements UserDAO {
	@Autowired
	DataSource dataSource;
	PreparedStatement preparedStatement;
	User user;

	public User getById(int id) {
		String query = "select userName from Users where userID = ?";
		user = null;
		Connection connection = null;
		preparedStatement = null;
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
	
	public void insertUser(User user) {
		String query = "insert into Users (userName, password, email, birthdate, sex) " +
				"values (?, ?, ?, ?, ?)";
		Connection connection = null;
		preparedStatement = null;
		int numberOfInsertedRows = 0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getBirthDate());
			preparedStatement.setLong(5, user.getSex());
			numberOfInsertedRows = preparedStatement.executeUpdate();
			if (numberOfInsertedRows == 0) {
				System.out.println("Rows did not inserted!");
			} else {
				System.out.println("Inserted::" + numberOfInsertedRows + " rows");
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
