//package com.tennis.user;
//
//import java.util.List;
//
//import com.tennis.domain.User;
//import com.tennis.persistence.UserHibernateImpl;
//
//public class UserHibernateServise {
//	private static UserHibernateImpl userDAO;
//
//	public UserHibernateServise() {
//		userDAO = new UserHibernateImpl();
//	}
//
//	public void persist(User entity) {
//		// userDAO.openCurrentSessionwithTransaction();
//		userDAO.persist(entity);
//		// userDAO.closeCurrentSessionwithTransaction();
//	}
//
//	public void update(User entity) {
//		// userDAO.openCurrentSessionwithTransaction();
//		userDAO.update(entity);
//		// userDAO.closeCurrentSessionwithTransaction();
//	}
//
//	public User findById(String id) {
//		userDAO.openCurrentSession();
//		User book = userDAO.findById(id);
//		userDAO.closeCurrentSession();
//		return book;
//	}
//
//	public void delete(String id) {
//		// userDAO.openCurrentSessionwithTransaction();
//		User book = userDAO.findById(id);
//		userDAO.delete(book);
//		// userDAO.closeCurrentSessionwithTransaction();
//	}
//
//	public List<User> findAll() {
//		userDAO.openCurrentSession();
//		List<User> books = userDAO.findAll();
//		userDAO.closeCurrentSession();
//		return books;
//	}
//
//	public void deleteAll() {
//		// userDAO.openCurrentSessionwithTransaction();
//		userDAO.deleteAll();
//		// userDAO.closeCurrentSessionwithTransaction();
//	}
//
//	public UserHibernateImpl userDAO() {
//		return userDAO;
//	}
//
// }
