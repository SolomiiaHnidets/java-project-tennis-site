package com.tennis.web;

import com.tennis.domain.User;
import com.tennis.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	// Tells the application context to inject an instance of UserService here
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		System.out.println("New request");
		logger.info("Calling user controller");
		return new ResponseEntity<String>("Some data", HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		// The UserServiceImpl is already injected and we can use it
		return userService.getAll();
	}

}