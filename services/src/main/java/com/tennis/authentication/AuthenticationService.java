package com.tennis.authentication;

public interface AuthenticationService {

	String authentication(String username, String password) throws Exception;
	void logoutUser(String authToken);
}
