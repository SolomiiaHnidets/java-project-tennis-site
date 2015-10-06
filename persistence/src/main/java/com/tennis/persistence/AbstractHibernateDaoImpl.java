package com.tennis.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractHibernateDaoImpl {

	private SessionFactory sessionFactory;

	protected Session session;

	public AbstractHibernateDaoImpl() {
		sessionFactory = getSessionFactory();
	}

	protected void openCurrentSessionWithTransaction() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	protected void closeCurrentSessionWithTransaction() {
		if (session != null) {
			if (session.isOpen()) {
				session.getTransaction().commit();
				session.close();
			}
		}
	}

	protected void handleException(Exception e) {
		e.printStackTrace();
		if (session != null) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			session.close();
		}
	}

	private SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}