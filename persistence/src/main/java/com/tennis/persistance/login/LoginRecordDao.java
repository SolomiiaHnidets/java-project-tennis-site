package com.tennis.persistance.login;

import com.tennis.domain.AuthorizationToken;

public interface LoginRecordDao {

	void saveToken(Integer userID, String authToken);

	AuthorizationToken getLoginRecord(String authToken);

	void deleteToken(AuthorizationToken token);

}
