package com.tennis.web;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getAll() {
		logger.info("Calling user controller");
		return new ResponseEntity<String>("Some data", HttpStatus.OK);
	}

}