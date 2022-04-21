package it.beije.turing.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.rubrica.Contatto;

public class HBsessionFactory {

	private HBsessionFactory() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session openH8Session() {
		if (sessionFactory == null) {
			System.out.println("creo SessionFactory...");
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}

}
