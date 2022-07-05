package com.bilgeadam.boost.course02.controller.model;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.boost.course02.hibernate.HibernateUtil;
import com.bilgeadam.boost.course02.model.BilgeAdamAble;

/**
 * C ==> CREATE (insert) R ==> RETRIEVE U ==> UPDATE D ==> DELETE
 *
 */
public interface CRUDable<T extends BilgeAdamAble> {
	
	void create(T entity);

	ArrayList<T> retrieve();
	
	void update(T oldOne, T newOne);

	void delete(T entity);
	
	default Session databaseConnectionViaHibernate() {
		return HibernateUtil.getSessionFactory().openSession();
	}
}