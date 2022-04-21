package it.beije.turing.newRubrica.file;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.newRubrica.rubrica.Contatto;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory entityManagerFactory;
	private EntityManagerFactorySingleton() {
		
	}
	
	public static EntityManager createEntityManager() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			
		}
		return entityManagerFactory.createEntityManager();
	}
}
