package it.beije.turing.db;

import it.beije.turing.beanecommerce.Utente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HBsessionFactory {

	private HBsessionFactory() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session openSession() {
		if (sessionFactory == null) {
			System.out.println("creo SessionFactory...");

			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Utente.class);

			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory.openSession();
	}

}
