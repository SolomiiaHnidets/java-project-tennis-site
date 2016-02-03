package com.tennis.web;

import static com.tennis.authentication.BaseAuthentication.AUTH_TOKEN_HEADER_NAME;

import com.tennis.configuration.Config;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.VideoCatalog;
import com.tennis.persistance.video.VideoCatalogHibernateImpl;
import com.tennis.persistance.video.VideoCatalogJdbcImpl;
import com.tennis.user.UserService;
import com.tennis.user.UserServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ContextConfiguration(classes = Config.class)
@RequestMapping("/video")
public class VideoHomeController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@ResponseBody
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ResponseEntity<List<VideoCatalog>> getAllUsers(
			@RequestParam("token") String userToken) {
		logger.info("Calling video controller");
		VideoCatalogJdbcImpl videos = new VideoCatalogJdbcImpl();
		HttpStatus code;
		HttpHeaders headers = new HttpHeaders();
		List<VideoCatalog> catalog = videos.getAll();
		code = HttpStatus.CREATED;
		headers.add(AUTH_TOKEN_HEADER_NAME, userToken);
		// UserService userService = new UserServiceImpl();
		// The UserServiceImpl is already injected and we can use it
		return new ResponseEntity<List<VideoCatalog>>(catalog, headers, code);
	}
}
