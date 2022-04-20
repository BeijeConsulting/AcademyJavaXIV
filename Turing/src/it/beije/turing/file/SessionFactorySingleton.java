package it.beije.turing.file;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.rubrica.Contatto;

public class SessionFactorySingleton {
	private static SessionFactory singleton;

	private SessionFactorySingleton() {
	};

	public Session getInstance() {
		if (singleton == null) {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
			singleton = configuration.buildSessionFactory();
		}
		return singleton.openSession();
	}

}
