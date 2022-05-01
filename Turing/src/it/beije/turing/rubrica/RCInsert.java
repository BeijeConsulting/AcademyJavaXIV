package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RCInsert {

	public static void insert(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		//INSERT
		System.out.println("Inserting new Contact: ");
		Contatto newContatto = new Contatto();
		Scanner s = new Scanner(System.in);
		String st = null;

		System.out.println("Please insert Contact Surname: ");
		st = s.nextLine().trim();
		if (!st.equals("")) {newContatto.setCognome(st);}
		System.out.println("Please insert Contact Name: ");
		st = s.nextLine().trim();
		if (!st.equals("")) {newContatto.setNome(st);}
		System.out.println("Please insert Contact Email: ");
		st = s.nextLine().trim();
		if (!st.equals("")) {newContatto.setEmail(st);}
		System.out.println("Please insert Contact Phone: ");
		st = s.nextLine().trim();
		if (!st.equals("")) {newContatto.setTelefono(st);}
		System.out.println("Please insert Contact Notes: ");
		st = s.nextLine().trim();
		if (!st.equals("")) {newContatto.setNote(st);}
		

		entityManager.persist(newContatto);
		entityTransaction.commit();
		System.out.println("Contact correctly inserted:");
		System.out.println(newContatto);
	}

	public static void insert(EntityManager entityManager, Contatto c) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		//INSERT
		System.out.println("Inserting new Contact...");

		entityManager.persist(c);
		entityTransaction.commit();
		System.out.println("Contact correctly inserted:");
		System.out.println(c);
	}

	public static void importCSVtoDB(EntityManager entityManager, String csvPath, String separator){
		ArrayList<Contatto> newContacts = RCimportCSV.getCSVContacts(csvPath, separator);
		for (Contatto c : newContacts) {
			insert(entityManager , c);
		}
	}

	public static void importXMLtoDB(EntityManager entityManager, String xmlPath) {
		ArrayList<Contatto> newContacts = RCimportXML.getXMLContacts(xmlPath);
		System.out.println(newContacts);
		for (Contatto c : newContacts) {
			insert(entityManager , c);
		}
	}
}
