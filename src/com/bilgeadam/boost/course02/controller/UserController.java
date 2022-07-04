package com.bilgeadam.boost.course02.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.boost.course02.hibernate.CRUDable;
import com.bilgeadam.boost.course02.model.UserEntity;

public class UserController implements CRUDable<UserEntity> {

	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionViaHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Başarılı oldum");
		}
		catch (Exception ex) {
			System.err.println("Başarısız oldum");
		}
	}

	@Override
	public ArrayList<UserEntity> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserEntity entity) {
		// TODO Auto-generated method stub

	}

}
