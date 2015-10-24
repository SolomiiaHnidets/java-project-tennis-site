package com.tennis.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tennis.configuration.Config;
import com.tennis.domain.AuthorizationToken;
import com.tennis.domain.User;
import com.tennis.persistance.login.LoginRecordDao;
import com.tennis.persistance.user.UserDAO;
import com.tennis.util.*;

@Service
@Component
@Transactional
@ContextConfiguration(classes = Config.class)
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final String AT_CHARACTER = "@";

	@Autowired
	private UserDAO userDAO;

	@Autowired
	public LoginRecordDao loginRecord;

	@Override
	public String authentication(String username, String password)
			throws Exception {
		User user = loadUser(username, password);
		String authToken = TokenUtil.generateRandomToken();
		loginRecord.saveToken(user.getUserID(), authToken);
		return authToken;
	}

	// Loads user by userName/password or email/password credentials.
	private User loadUser(String username, String password) throws Exception {
		User user = null;
		// check if user typed email address
		if (username.contains(AT_CHARACTER)) {
			user = userDAO.getByEmail(username.toLowerCase());
			if (user != null) {
				if (!PasswordEncoder.isMatchPassword(password,
						user.getPassword())) {
					throw new Exception("Bad password");
				}
			} else {
				throw new Exception("Bad credentials");
			}
			// check if user typed login
		} else {
			user = userDAO.getByName(username.toLowerCase());
			if (user != null) {
				if (!PasswordEncoder.isMatchPassword(password,
						user.getPassword())) {
					throw new Exception("Bad password");
				}
			} else {
				throw new Exception("Bad credentials");
			}
		}
		// if (user.isLocked() || user.isDeleted()) {
		// throw new UserLockedException("User account is locked");
		// }
		return user;
	}

	@Override
	public void logoutUser(String authToken) {
		AuthorizationToken login = loginRecord.getLoginRecord(authToken);
		if (login != null) {
			loginRecord.deleteToken(login);
		}
		// else {
		// throw new NotLoggedinUserException();
		// }
	}
}
