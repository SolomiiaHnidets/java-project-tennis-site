package com.tennis.web;

import static com.tennis.authentication.BaseAuthentication.AUTH_TOKEN_HEADER_NAME;

import com.tennis.authentication.AuthenticationService;
import com.tennis.configuration.Config;
import com.tennis.domain.AuthorizationToken;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@ContextConfiguration(classes = Config.class)
public class LoginController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<AuthorizationToken> authentication(
			@RequestParam("password") String password,
			@RequestParam("login") String login) {
		AuthorizationToken token = null;
		HttpStatus code;
		HttpHeaders headers = new HttpHeaders();
		logger.info("Calling loger controller");
		try {
			token = authenticationService.authentication(login, password);
			logger.info("Log in");
			code = HttpStatus.CREATED;
			headers.add(AUTH_TOKEN_HEADER_NAME, token.getToken());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Authentification failed");
			code = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
		}
		return new ResponseEntity<AuthorizationToken>(token, headers, code);
	}
}
