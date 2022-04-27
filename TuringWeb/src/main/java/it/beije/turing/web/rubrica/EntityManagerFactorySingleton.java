package it.beije.turing.web.rubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory entityManagerFactory;
	private EntityManagerFactorySingleton() {
		
	}
	
	public static EntityManager createEntityManager() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("TuringWeb");
			
		}
		return entityManagerFactory.createEntityManager();
	}
}
