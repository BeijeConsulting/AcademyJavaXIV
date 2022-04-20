package it.beije.turing.newRubrica.file;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.newRubrica.rubrica.Contatto;

public class SessionFactorySingleton {
	
	private static SessionFactory sessionFactory;
	
	private SessionFactorySingleton() {
		
	}
	
	public static Session openSession() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);	
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory.openSession();
	}
}
