package it.beije.turing.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAentityManagerFactoryService {
	private JPAentityManagerFactoryService() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager openEntityManager() {
		if (entityManagerFactory == null) {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			
		}
		
		return entityManagerFactory.createEntityManager();
	}
}
