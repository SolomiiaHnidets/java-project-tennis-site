package com.tennis.user;

import com.tennis.domain.User;
import com.tennis.persistance.user.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityExistsException;

@Service
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getAll() {
		// User user = new User("solka", "password");
		// user.setBirthDate(java.sql.Date.valueOf("2013-05-06"));
		// user.setEmail("email@com");
		// user.setSex("M");
		// userDAO.create(user);
		return userDAO.getAll();
	}

	@Override
	public void add(User user) {
		checkUserUniqueness(user);
		userDAO.create(user);
	}

	private void checkUserUniqueness(User userData) {
		User user;
		user = userDAO.getByName(userData.getUserName());
		if (user != null) {
			throw new EntityExistsException(String.format(
					"User with the same name [%s] already exists.",
					userData.getUserName()));
		}
		user = userDAO.getByName(userData.getEmail());
		if (user != null) {
			throw new EntityExistsException(String.format(
					"Email with the same name [%s] already exists.",
					userData.getEmail()));
		}
	}

	// public String createAuthorizationToken(User user) {
	// if(user.getAuthorizationToken() == null ||
	// user.getAuthorizationToken().hasExpired()) {
	// user.setAuthorizationToken(new AuthorizationToken(user,
	// applicationConfig.getAuthorizationExpiryTimeInSeconds()));
	// userRepository.save(user);
	// }
	// return user.getAuthorizationToken();
	// }

}
