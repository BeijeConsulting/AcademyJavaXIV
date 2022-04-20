package it.beije.turing.rubrica;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibInsert {

	public static void insert(Session session) {
		//INSERT
		//Transaction transaction = session.beginTransaction();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
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
		s.close();
			
		session.save(newContatto);
		System.out.println("Contact correctly inserted:");
		System.out.println(newContatto);
	}
	
}
