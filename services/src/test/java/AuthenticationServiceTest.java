import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tennis.authentication.AuthenticationServiceImpl;
import com.tennis.configuration.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AuthenticationServiceTest {

	// @Autowired
	AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();

}
