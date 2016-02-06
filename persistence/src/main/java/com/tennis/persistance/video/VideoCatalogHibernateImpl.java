package com.tennis.persistance.video;

import java.util.List;

import org.hibernate.Query;

import com.tennis.domain.VideoCatalog;
import com.tennis.persistance.AbstractHibernateDaoImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class VideoCatalogHibernateImpl extends AbstractHibernateDaoImpl
		implements
			VideoCatalogDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoCatalog> getAll() {
		List<VideoCatalog> videos = null;
		try {
			openCurrentSessionWithTransaction();
			// In the HQL , you should use the java class name
			// and property name of the mapped @Entity instead of the actual
			// table name and column name
			Query query = session.createQuery("from VideoCatalog");
			videos = query.list();
		} catch (Exception e) {
			handleException(e);
		} finally {
			closeCurrentSessionWithTransaction();
		}
		return videos;
	}
}
