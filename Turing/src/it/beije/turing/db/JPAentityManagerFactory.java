package it.beije.turing.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAentityManagerFactory {

	private JPAentityManagerFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager openEntityManager() {
		if (entityManagerFactory == null) {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			
		}
		
		return entityManagerFactory.createEntityManager();
	}
}
