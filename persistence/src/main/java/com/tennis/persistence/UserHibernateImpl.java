package com.tennis.persistence;

import com.tennis.domain.User;

import java.util.List;

public class UserHibernateImpl extends AbstractHibernateDaoImpl implements UserDAO {

	@Override
	public void create(User user) {
		try {
			openCurrentSessionWithTransaction();
			session.save(user);
		} catch (Exception e) {
			handleException(e);
		} finally {
			closeCurrentSessionWithTransaction();
		}
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User getById(int id) {
		return null;
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public User getByName(String name) {
		return null;
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserHibernateImpl();
		User user = new User();
		userDAO.create(user);
	}
}
