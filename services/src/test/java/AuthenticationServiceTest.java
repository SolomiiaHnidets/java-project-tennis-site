import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennis.authentication.AuthenticationServiceImpl;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class AuthenticationServiceTest {

	@Mock
	AuthenticationServiceImpl authenticationService;

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

	private String getJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(obj);
		return str;
	}

	@Test
	public void testLoginSuccess() throws Exception {
		AuthorizationToken expected = new AuthorizationToken();
		User userDto = createUserDto();
		expected.setToken(TEST_TOKEN);
		expected.setUserID(userDto.getUserID());
		String expectedStr = getJson(expected);

		when(authenticationService.authentication(USER_NAME, PASSWORD))
				.thenReturn(expected);

		getJson(
				authenticationService.authentication(userDto.getUserName(),
						userDto.getPassword())).equals(expectedStr);
	}
}
