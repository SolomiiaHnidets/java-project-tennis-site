package com.db.dao;

import com.dao.model.User;

public interface UserDAO {
	
	public User getById(int id);
	public void insertUser(User user);
}
