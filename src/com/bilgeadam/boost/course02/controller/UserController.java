package com.bilgeadam.boost.course02.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.boost.course02.controller.model.CRUDable;
import com.bilgeadam.boost.course02.logging.MyLogger;
import com.bilgeadam.boost.course02.model.UserEntity;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class UserController implements CRUDable<UserEntity> {
	private static MyLogger logger = MyLogger.getInstance();

	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionViaHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.debug("Başarılı oldum");
		}
		catch (Exception ex) {
			logger.error("Başarısız oldum");
		}
	}

	@Override
	public ArrayList<UserEntity> retrieve() {
		Session session = databaseConnectionViaHibernate();
		String hql = "SELECT user FROM UserEntity as user";
		TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
		
		ArrayList<UserEntity> users = (ArrayList<UserEntity>) typedQuery.getResultList();
		return users;
	}

	@Override
	public void update(UserEntity oldOne, UserEntity newOne) {
		Session session = databaseConnectionViaHibernate();
		session.getTransaction().begin();

		String hql = "UPDATE UserEntity SET email = :newEmail, firstName = :newFirstName, lastName = :newLastName WHERE oid = :id";
		Query query = session.createQuery(hql);
		query.setParameter("newEmail", newOne.getEmail());
		query.setParameter("newFirstName", newOne.getFirstName());
		query.setParameter("newLastName", newOne.getLastName());
		query.setParameter("id", oldOne.getOid());
		int status = query.executeUpdate();
		logger.debug("Sonuç: " + status);
		
		session.getTransaction().commit();
	}

	@Override
	public void delete(UserEntity entity) {
		Session session = databaseConnectionViaHibernate();
		session.getTransaction().begin();
		Query query = session.createQuery("delete UserEntity where oid = :id");
		query.setParameter("id", entity.getOid());
		int status = query.executeUpdate();
		logger.debug("Sonuç: " + status);
		session.getTransaction().commit();
	}

	public ArrayList<UserEntity> findByEmail(String email) {
		Session session = databaseConnectionViaHibernate();
		String hql = "SELECT user FROM UserEntity as user where email = :key";
		TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
		typedQuery.setParameter("key", email);
		
		ArrayList<UserEntity> users = (ArrayList<UserEntity>) typedQuery.getResultList();
		return users;
	}

}
