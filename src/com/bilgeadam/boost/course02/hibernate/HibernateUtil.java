package com.bilgeadam.boost.course02.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.boost.course02.model.UserEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate(); 
	
	private static SessionFactory sessionFactoryHibernate() {
		SessionFactory factory = null;
		try {
			Configuration config = new Configuration(); // instance oluşturduk
			
			config.addAnnotatedClass(UserEntity.class); //entity sınıflarımızı burada hibernate'e tanıtmamız gerekli
														// bu işin java jargonunda adı "register etmek"tir
			
			factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Exception ex) {
			// TODO: handle exception
			// buraya logger gelecek
			System.err.println("Someting went terribly wrong: " + ex.getMessage());
		}
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
