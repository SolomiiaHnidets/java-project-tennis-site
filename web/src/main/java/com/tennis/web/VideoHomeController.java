package com.tennis.web;

import com.tennis.configuration.Config;
import com.tennis.domain.VideoCatalog;
import com.tennis.persistance.video.VideoCatalogDAO;
import com.tennis.persistance.video.VideoCatalogJdbcImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tennis.authentication.BaseAuthentication.*;

@RestController
@ContextConfiguration(classes = Config.class)
@RequestMapping("/video")
public class VideoHomeController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private VideoCatalogDAO videos;

	@ResponseBody
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ResponseEntity<List<VideoCatalog>> getAllUsers(
			@RequestHeader(name = "token") String userToken) {
		logger.info("Calling video controller");
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
