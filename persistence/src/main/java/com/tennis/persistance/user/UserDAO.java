package com.tennis.persistance.user;

import com.tennis.domain.User;

import java.util.List;

public interface UserDAO {

	void create(User user);

	List<User> getAll();

	User getById(int id);

	void delete(int id);

	User getByName(String name);

	// void updateToken(String name, String token);

	User getByEmail(String email);

	User getByEmailAndPassword(String email, String password);

	User getByNameAndPassword(String name, String password);
}