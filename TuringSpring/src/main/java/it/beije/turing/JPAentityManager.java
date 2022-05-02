package it.beije.turing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAentityManager
{
	private JPAentityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager createEntityManager() {
		if (entityManagerFactory == null)
		{
			System.out.println("creo EntityManager...");
			
			entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			
		}
		
		return entityManagerFactory.createEntityManager();
	}
}