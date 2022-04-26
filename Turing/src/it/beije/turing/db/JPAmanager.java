package it.beije.turing.db;

import it.beije.turing.beanecommerce.Prodotto;
import it.beije.turing.beanecommerce.Utente;

import javax.persistence.*;
import java.util.List;


public class JPAmanager {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peppeshop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Utente contatto = entityManager.find(Utente.class, 1);//SELECT c FROM Contatto as c WHERE id = 1
		System.out.println(contatto);
		
/*		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();*/
		
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

/*		entityTransaction.commit();*/
		//entityTransaction.rollback();


		EntityManager entityManagerP = entityManagerFactory.createEntityManager();

		Prodotto prodotto = entityManagerP.find(Prodotto.class, 1);//SELECT c FROM Contatto as c WHERE id = 1
		System.out.println(prodotto);


		Query query = entityManagerP.createQuery("SELECT p FROM Prodotto as p");
		List<Prodotto> prodotto2 = query.getResultList();

		for (Prodotto c : prodotto2) {
			System.out.println(c);
		}

		entityManagerP.close();

	}

}
