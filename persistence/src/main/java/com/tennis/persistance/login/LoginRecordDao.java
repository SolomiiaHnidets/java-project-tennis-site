package com.tennis.persistance.login;

public interface LoginRecordDao {

	void updateToken(String name, String token);

	void saveToken(Integer userID, String authToken);

}
