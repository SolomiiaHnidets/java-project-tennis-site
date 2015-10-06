package com.tennis;

import com.tennis.configuration.Config;
import com.tennis.domain.User;
import com.tennis.persistence.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class UserDaoTest {

	@Autowired
	@InjectMocks
	private UserDAO userDAO;

	// @Autowired
	@Mock
	private DataSource mockDataSource;

	@Mock
	private Connection mockConnection;

	@Mock
	private PreparedStatement mockPreparedStatement;

	@Mock
	private ResultSet mockResultSet;

	@Mock
	private User user;

	@Before
	public void init() throws SQLException {
		// Important! Mocks need to be initialized.
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockDataSource.getConnection()).thenReturn(mockConnection);
		Mockito.doNothing().when(mockConnection).commit();
		Mockito.doNothing().when(mockPreparedStatement)
				.setString(Mockito.anyInt(), Mockito.anyString());
		// user = new User("uranfgh21", "passwfgord");
	}
	@Test
	public void testGetById() throws Exception {
		String query = "select * from Users where userID = ?";
		Mockito.when(mockConnection.prepareStatement(query)).thenReturn(
				mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(
				mockResultSet);
		Mockito.when(mockResultSet.next()).thenReturn(true);
		user = userDAO.getById(1);
		assertEquals(1, user.getUserID());
		// check the method was called, with the expected query string and
		// parameter values
		Mockito.verify(mockPreparedStatement).executeQuery();
	}

	@Test
	public void testInsertUser() throws Exception {
		user = new User("uranfgh21", "passwfgord");
		user.setBirthDate("768976");
		user.setEmail("ghjk");
		user.setSex("M");
		String query = "insert into Users (userName, password, email, birthdate, sex) "
				+ "values (?, ?, ?, ?, ?)";
		Mockito.when(mockConnection.prepareStatement(query)).thenReturn(
				mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
		userDAO.create(user);
		Mockito.verify(mockPreparedStatement).executeUpdate();
	}

	@Test
	public void testDeleteUser() throws Exception {
		String query = "delete from Users where userID = ?";
		Mockito.when(mockConnection.prepareStatement(query)).thenReturn(
				mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
		userDAO.delete(1);
		Mockito.verify(mockPreparedStatement).executeUpdate();
	}
}
