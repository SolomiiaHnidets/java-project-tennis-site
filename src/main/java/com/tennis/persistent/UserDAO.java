package com.tennis.persistent;

import com.tennis.domain.User;

public interface UserDAO {

	void save(User user);

	User getById(int id);
}