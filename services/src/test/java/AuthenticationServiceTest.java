import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennis.authentication.AuthenticationServiceImpl;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = Config.class)
public class AuthenticationServiceTest {

	@Mock
	AuthenticationServiceImpl authenticationService;

	// @InjectMocks
	// private LoginController controller = new LoginController();

	private MockMvc mvc;

	private static final String USER_NAME = "solomiya";
	private static final String PASSWORD = "password";
	private static final String SEX = "F";
	private static final String EMAIL = "some@ru.com";
	private static final String TEST_TOKEN = "8815f97f-5756-4719-90d3-025503c53640";

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		// mvc = MockMvcBuilders.standaloneSetup(controller)
		// .setHandlerExceptionResolvers(createExceptionResolver())
		// .build();
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

		mvc.perform(
				MockMvcRequestBuilders.get("/login").content(getJson(userDto))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().string(equalTo(expectedStr)))
				.andExpect(header().string("User-Token", TEST_TOKEN));
	}
}
