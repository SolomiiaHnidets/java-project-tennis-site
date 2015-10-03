package com.tennis;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
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
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
		String query = "select userName from Users where userID = ?";
		Mockito.when(mockConnection.prepareStatement(query)).thenReturn(
				mockPreparedStatement);
		Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(
				mockResultSet);
		Mockito.when(mockResultSet.next()).thenReturn(true);
		user = userDAO.getById(1);
		assertEquals(1, user.getUserID());
		Mockito.verify(mockPreparedStatement).executeQuery();
	}

	//
	// @Test
	// public void testDeleteUser() {
	// userDAO.delete(1);
	// }
}
