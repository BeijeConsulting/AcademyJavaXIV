package it.beije.turing.db;

import it.beije.turing.beanecommerce.Utenti;
import it.beije.turing.manger.UtentiManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPAmanager {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peppeshop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Utenti contatto = entityManager.find(Utenti.class, 1);//SELECT c FROM Contatto as c WHERE id = 1
		System.out.println("contatto : " + contatto);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		//INSERT
//		Contatto newContatto = new Contatto();
//		//newContatto.setId(3);
//		newContatto.setCognome("Corraro");
//		newContatto.setNome("Mattia");
//		newContatto.setEmail("m.corraro@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//		
//		entityManager.persist(newContatto);
//		
//		System.out.println("contatto POST : " + newContatto);
		
		//UPDATE
//		System.out.println("modifico : " + contatto);
//		//contatto.setId(20);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		entityManager.persist(contatto);
//		System.out.println("contatto POST update : " + contatto);
		
//		//DELETE
//		entityManager.remove(contatto);

		entityTransaction.commit();
		//entityTransaction.rollback();
		
		//SELECT JPQL
		/*Query query = entityManager.createQuery("SELECT c FROM Utenti as c");
		List<Utenti> contatti = query.getResultList();

		for (Utenti c : contatti) {
			System.out.println(c);
		}

		entityManager.close();*/

	}

}
