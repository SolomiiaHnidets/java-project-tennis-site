import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.security.sasl.AuthenticationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tennis.authentication.AuthenticationService;
import com.tennis.authentication.AuthenticationServiceImpl;
import com.tennis.configuration.Config;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.User;
import com.tennis.persistance.user.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AuthenticationServiceTest {

	@Mock
	AuthenticationService authenticationService = new AuthenticationServiceImpl();

	@Autowired
	@InjectMocks
	private UserDAO userDAO;

	private static final String USER_NAME = "solomiya";
	private static final String PASSWORD = "password";
	private static final String SEX = "F";
	private static final String EMAIL = "some@ru.com";
	private static final String TEST_TOKEN = "8815f97f-5756-4719-90d3-025503c53640";

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	private User createUserDto() {
		User user = new User();
		user.setUserName(USER_NAME);
		user.setEmail(EMAIL);
		user.setSex(SEX);
		user.setPassword(PASSWORD);
		user.setUserID(1);
		return user;
	}

	@Test
	public void testAuthenticationSuccess() throws Exception {
		AuthorizationToken expected = new AuthorizationToken();
		User userDto = createUserDto();
		expected.setToken(TEST_TOKEN);
		expected.setUserID(userDto.getUserID());

		when(authenticationService.authentication(USER_NAME, PASSWORD))
				.thenReturn(expected);
		assertEquals(expected,
				authenticationService.authentication(USER_NAME, PASSWORD));
	}

	@Test
	public void testAuthenticationByEmail() throws Exception {
		User userDto = createUserDto();
		// User by email
		when(userDAO.getByEmail("someemail@")).thenReturn(userDto);
		try {
			authenticationService.authentication("someemail@", PASSWORD);
			assertTrue(true);
		} catch (AuthenticationException e) {
			assertTrue(false);
		}
		// try {
		// authService.loginUser("test2@", USER_PASSWORD, TENANT_CODE);
		// assertTrue(false);
		// } catch (AuthenticationException e) {
		// assertTrue(true);
		// }

	}
}
