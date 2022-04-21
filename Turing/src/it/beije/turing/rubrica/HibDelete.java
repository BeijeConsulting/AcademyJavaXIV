package it.beije.turing.rubrica;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibDelete {
	public static void delete (Session session, Contatto contatto) {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you sure (Y/n) you want to delete Contact?:");
		System.out.println(contatto);
		String st = s.next();
		while (!(st.equals("Y")|st.equals("n"))) {
			System.out.println("Please enter Y (delete) or n (don't delete)");
			st = s.next();
		}
		if (st.equals("Y")) {
			Transaction transaction = session.beginTransaction();	
			session.remove(contatto);
			transaction.commit();
			System.out.println("Contact removed.");

			s.close();
		} else { 
			System.out.println("Contact not removed.");
			s.close();
		}
	}
}
