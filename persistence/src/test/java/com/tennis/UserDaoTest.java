package com.tennis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tennis.configuration.Config;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTest {

	@Autowired
	@InjectMocks
	private UserDAO userDAO;

	@Autowired
	private DataSource dataSource;
//
//	@Mock
//	private Connection connection;
//
//	@Mock
//	private PreparedStatement statement;
//
//	@Mock
//	private ResultSet result;
//
//	@Mock
//	private User user;
//
//	@Before
//	public void init() throws SQLException {
//		MockitoAnnotations.initMocks(this);
//		Mockito.when(connection.createStatement()).thenReturn(statement);
//		user = new User("uranfgh21", "passwfgord");
//	}

	@Test
	public void testGetById() throws Exception{
		String query = "select userName from Users where userID = ?";
		Connection connection = Mockito.mock(Connection.class);
		PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
		ResultSet resultSet = Mockito.mock(ResultSet.class);
		Mockito.when(dataSource.getConnection()).thenReturn(connection);
		Mockito.when(connection.prepareStatement(query)).thenReturn(preparedStatement);
		Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true);

		userDAO.getById(1);

//		try {
//			Mockito.when(
//					connection
//							.prepareStatement("select userName from Users where userID = ? "))
//					.thenReturn(statement);
//			Mockito.when(statement.executeQuery()).thenReturn(result);
//			Mockito.when(result.next()).thenReturn(true);
//			Mockito.when(result.getInt("userID")).thenReturn(1);
//			user = userDAO.getById(1);
//			assertEquals(1, user.getUserID());
//			Mockito.verify(statement).executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// User user = userDAO.getById(12);
//		// System.out.println(user);
	}

//	@Test
//	public void testInsertUser() {
//		try {
//			Mockito.when(
//					connection
//							.prepareStatement("insert into Users (userName, password, email, birthdate, sex) VALUES ( ?, ?, ?, ?, ? )"))
//					.thenReturn(statement);
//			userDAO.create(user);
//			Mockito.verify(statement).executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//
//		// User user = new User();
//		// BindingResult result = mock(BindingResult.class);
//		// user.setUserName("uranfgh21");
//		// user.setPassword("passwfgord");
//		// user.setEmail("some@www.ru");
//		// // Check validation errors
//		// if (result.hasErrors()) {
//		// System.out.println("addUser");
//		// } else {
//		// userDAO.create(user);
//		// }
//	}
//
//	@Test
//	public void testDeleteUser() {
//		userDAO.delete(1);
//	}
}
