package it.beije.turing.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.turing.jpa.EntityManagerSingleton;
import it.beije.turing.rubrica.Contatto;

public class Jpa_Ecommerce {
	
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerSingleton.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Customer as c");
		List<Customer> customers = query.getResultList();

		for (Customer c : customers) {
			System.out.println(c);
		}
		entityManager.close();
	}
}
