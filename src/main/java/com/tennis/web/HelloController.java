package com.tennis.web;


import com.tennis.domain.User;
import com.tennis.persistent.UserDAOjdbcImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public ResponseEntity<String> rest() {
		return new ResponseEntity<String>("Some data", HttpStatus.OK);
	}

	@RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;

	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ResponseEntity<String> show(
			@RequestParam(value = "id", required = true) int id) {
		UserDAOjdbcImpl userDAO = new UserDAOjdbcImpl();
		User user = userDAO.getById(id);
		return new ResponseEntity<String>(user.getUserName(), HttpStatus.OK);

	}

}