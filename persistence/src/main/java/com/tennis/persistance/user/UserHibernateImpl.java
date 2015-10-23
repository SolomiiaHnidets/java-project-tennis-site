package com.tennis.persistance.user;

import com.tennis.domain.User;
import com.tennis.persistance.AbstractHibernateDaoImpl;

import org.hibernate.Query;

import java.util.List;

public class UserHibernateImpl extends AbstractHibernateDaoImpl
		implements
			UserDAO {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		List<User> users = null;
		try {
			openCurrentSessionWithTransaction();
			// In the HQL , you should use the java class name
			// and property name of the mapped @Entity instead of the actual
			// table name and column name
			Query query = session.createQuery("from User");
			users = query.list();
		} catch (Exception e) {
			handleException(e);
		} finally {
			closeCurrentSessionWithTransaction();
		}
		return users;
	}

	@Override
	public User getById(int id) {
		User user = null;
		try {
			openCurrentSessionWithTransaction();
			user = (User) session.load(User.class, id);
		} catch (Exception e) {
			handleException(e);
		} finally {
			closeCurrentSessionWithTransaction();
		}
		return user;
	}

	@Override
	public void delete(int id) {
		User user;
		try {
			openCurrentSessionWithTransaction();
			user = (User) session.get(User.class, id);
			session.delete(user);
		} catch (Exception e) {
			handleException(e);
		} finally {
			closeCurrentSessionWithTransaction();
		}
	}

	@Override
	public User getByName(String name) {
		return null;
	}

	// @Override
	// public void updateToken(String name, String token) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	// public static void main(String[] args) {
	// UserDAO userDAO = new UserHibernateImpl();
	// User user = new User("solya", "some");
	// // user.setUserID(3);
	// user.setBirthDate("768976");
	// user.setEmail("ghjk");
	// user.setSex('F');
	// userDAO.create(user);
	// user = new User("yura", "some-some");
	// // user.setUserID(1);
	// user.setBirthDate("08.09.1994");
	// user.setEmail("ghjk");
	// user.setSex('M');
	// userDAO.create(user);
	// user = new User("vasya", "some-some");
	// user.setBirthDate("08.09.1994");
	// user.setEmail("ghjk");
	// user.setSex('M');
	// userDAO.create(user);
	// List<User> users = userDAO.getAll();
	// for (int i = 0; i < users.size(); i++) {
	// System.out.println(users.get(i).getUserName() + " "
	// + users.get(i).getUserID());
	// }
	// user = userDAO.getById(1);
	// System.out.println(user.getUserName());
	// userDAO.delete(1);
	// users = userDAO.getAll();
	// for (int i = 0; i < users.size(); i++) {
	// System.out.println(users.get(i).getUserName() + " "
	// + users.get(i).getUserID());
	// }
	// }
}
