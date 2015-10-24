package com.tennis.web;

import com.tennis.authentication.AuthenticationService;
import com.tennis.configuration.Config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@ContextConfiguration(classes = Config.class)
public class LoginController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	// Tells the application context to inject an instance of UserService here
	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		System.out.println("New request");
		logger.info("Calling user controller");
		return new ResponseEntity<String>("Some data", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> authentication(
			@RequestParam("password") String password,
			@RequestParam("login") String login) {
		String token = null;
		HttpStatus code;
		logger.info("Calling loger controller");
		try {
			token = authenticationService.authentication(login, password);
			logger.info("Log in");
			code = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Authentification failed");
			code = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
		}
		return new ResponseEntity<String>(token, code);
	}
}
