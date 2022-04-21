package it.beije.turing.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
	static EntityManager em;
	
	public static EntityManager createEntityManager() {
		if(em == null || !em.isOpen()) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			em = entityManagerFactory.createEntityManager();
		}
		return em;
	}
}
