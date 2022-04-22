package it.beije.turing.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.turing.rubrica.*;

public class RCmanager {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
	//	Contatto contatto = entityManager.find(Contatto.class, 1);//SELECT c FROM Contatto as c WHERE id = 1
	//	System.out.println("contatto : " + contatto);
		
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
		//PERSInsert.insert(entityManager);
		RCDuplicate.mergeDuplicates(entityManager);
		//SELECT JPQL
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		Contatto con = new Contatto();
		for (Contatto c : contatti) {
			System.out.println(c);
			if (c.getId()==6) {
				con = c;
			}
		}
		
		//PERSUpdate.update(entityManager,con);
		entityManager.close();

	}

}
