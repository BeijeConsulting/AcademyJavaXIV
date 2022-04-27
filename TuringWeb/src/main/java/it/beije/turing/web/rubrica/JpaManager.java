package it.beije.turing.web.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaManager {
	
	public static void readContatti() {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();

		for (Contatto c : contatti) {
			System.out.println(c);
		}
	}

	public static void addContatti(Contatto c) {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(c);
		entityTransaction.commit();	
	}
	
	public static void addContatti(List<Contatto> contatti) {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		for (Contatto c : contatti) {
			entityManager.persist(c);
		}
		entityTransaction.commit();
	}
	
	public static void deleteContatto(Contatto contatto, EntityManager em) {
		em.getTransaction().begin();
		em.remove(em.contains(contatto) ? contatto : em.merge(contatto));
		em.getTransaction().commit();
	}
	
	public static void modifyContatto(Contatto contatto, EntityManager em) {
		em.getTransaction().begin();
		em.persist(contatto);
		em.getTransaction().commit();
	}

	public static void updateJpa() {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Contatto contatto = entityManager.find(Contatto.class, 5978);
		contatto.setNote("HO MODIFICATO QUESTO CAMPO");
		entityManager.persist(contatto);
		entityTransaction.commit();
	}
}
