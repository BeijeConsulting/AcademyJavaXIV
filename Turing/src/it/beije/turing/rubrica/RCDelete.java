package it.beije.turing.rubrica;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class RCDelete {
	public static void delete (EntityManager entityManager, Contatto contatto) {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you sure (Y/n) you want to delete Contact?:");
		System.out.println(contatto);
		String st = s.next();
		while (!(st.equals("Y")|st.equals("n"))) {
			System.out.println("Please enter Y (delete) or n (don't delete)");
			st = s.next();
		}
		if (st.equals("Y")){
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(contatto);
			entityTransaction.commit();
			System.out.println("Contact removed.");
		} else { 
			System.out.println("Contact not removed.");
		}
	}
}
