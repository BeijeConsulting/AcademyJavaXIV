package it.beije.turing.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.turing.rubrica.Contatto;

public class JpaManager {
	
	

	public static void readContatti() {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();

		for (Contatto c : contatti) {
			System.out.println(c);
		}
//		entityManager.close();
	}
	

	public static void addContatti(Contatto c) {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(c);
		entityTransaction.commit();
//		entityManager.close();
		System.out.print("CONTATTO INSERITO JPA");
		
	}
	
	

	public static void addContatti(List<Contatto> contatti) {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		for (Contatto c : contatti) {
			entityManager.persist(c);
		}
		entityTransaction.commit();
//		entityManager.close();
	}
	
//	public static void deleteContatto(List<Contatto> contatti, EntityManager em) {
//		em.getTransaction().begin();
//		em.getTransaction().commit();
//		em.close();
//		System.out.println("Contatto " + contatto + " eliminato");
//	}
	
	public static void deleteContatto(Contatto contatto, EntityManager em) {
		em.getTransaction().begin();
		em.remove(em.contains(contatto) ? contatto : em.merge(contatto));
		em.getTransaction().commit();
//		em.close();
		System.out.println("Contatto " + contatto + " eliminato");
	}
	
	public static void modifyContatto(Contatto contatto, EntityManager em) {
		em.getTransaction().begin();
		em.persist(contatto);
		em.getTransaction().commit();
//		em.close();
	}

	public static void updateJpa() {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Contatto contatto = entityManager.find(Contatto.class, 5978);
		contatto.setNote("HO MODIFICATO QUESTO CAMPO");
		entityManager.persist(contatto);
		entityTransaction.commit();
//		entityManager.close();
	}

	public static void main(String[] args) {
		// Per prima cosa serve un EntityManagerFactory per darci un'istanza di
		// EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("turing");
		EntityManager entityManager = emf.createEntityManager();

		// Inizio la transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

//		// INSERT
//		StringBuilder sb = new StringBuilder();
//		int i = 0;
//		while (i < 10) {
//			sb.append(i);
//			String s = sb.toString();
//			Contatto newContatto = new Contatto(s, s, s, s, s);
//			entityManager.persist(newContatto);
//			i++;
//		}
//		entityTransaction.commit();

		// Crea una query (usando JPQL) attraverso l'entityManager, l'oggetto query
		// ritornato è di tipo javax.persistence
//		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
//		List<Contatto> contatti = query.getResultList();
//
//		for (Contatto c : contatti) {
//			System.out.println(c);
//		}
//		entityManager.close();
	}
}
