package com.bilgeadam.boost.course02.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;

/**
 * C ==> CREATE (insert) R ==> RETRIEVE U ==> UPDATE D ==> DELETE
 *
 */
public interface CRUDable<T> {
	void create(T entity);

	ArrayList<T> retrieve();

	void update(T entity);

	void delete(T entity);
	
	default Session databaseConnectionViaHibernate() {
		return HibernateUtil.getSessionFactory().openSession();
	}
}