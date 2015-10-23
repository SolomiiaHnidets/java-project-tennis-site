package com.tennis.user;

import java.util.List;

import com.tennis.Service;
import com.tennis.domain.User;

public interface UserService extends Service<User> {

	@Override
	List<User> getAll();
}
