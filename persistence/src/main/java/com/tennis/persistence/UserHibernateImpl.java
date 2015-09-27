package com.tennis.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.tennis.domain.User;

public class UserHibernateImpl implements UserDAO {

	private Session currentSession;

	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session User() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void openCurrentSessionwithTransaction() {
		currentTransaction.begin();
		currentSession = getSessionFactory().openSession();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(User user) {
		getCurrentSession().save(user);
	}

	public void update(User user) {
		getCurrentSession().update(user);
	}

	public User findById(String id) {
		User book = (User) getCurrentSession().get(User.class, id);
		return book;
	}

	public void delete(User user) {
		getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> books = getCurrentSession().createQuery("from Users").list();
		return books;
	}

	public void deleteAll() {
		List<User> entityList = findAll();
		for (User entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public void create(User user) {
		getCurrentSession().save(user);
		// user = new User();
		// user.setUserName("Arpit");
		// Session ss = sf.openSession();
		// ss.beginTransaction();
		// // saving objects to session
		// ss.save(user);
		// ss.getTransaction().commit();
		// ss.close();
	};

	@Override
	public List<User> getAll() {
		// TODO Add implementation
		return new ArrayList<User>();
	};
	@Override
	public User getById(int id) {
		// TODO Add implementation
		return new User();
	};
	@Override
	public void delete(int id) {
		// TODO Add implementation
	};
	@Override
	public User getByName(String name) {
		// TODO Add implementation
		return new User();
	};

}
