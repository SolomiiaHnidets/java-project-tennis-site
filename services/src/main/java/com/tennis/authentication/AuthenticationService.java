package com.tennis.authentication;

import com.tennis.domain.AuthorizationToken;

public interface AuthenticationService {

	AuthorizationToken authentication(String username, String password)
			throws Exception;

	void logoutUser(String authToken);
}
