package com.gtm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilForOracle {

	private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration().configure("oracle-ds.cfg.xml");
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if(sessionFactory != null)
		{
			sessionFactory.close();
		}
	}
	
	
}
