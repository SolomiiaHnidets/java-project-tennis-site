package com.tennis.persistence;

import com.tennis.domain.User;

import java.util.List;

public interface UserDAO {

	void create(User user);

	List<User> getAll();

	User getById(int id);

	void delete(int id);

	User getByName(String name);
}