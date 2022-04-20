package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibDuplicate {
	
	public static List<Contatto> findDuplicates(Session session) {
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
		List<Contatto> contatti = query.getResultList();
		String s1;
		String s2;
		List<Contatto> duplicates = new ArrayList<>();
		for (int i = 0; i < contatti.size(); i++){
			for (int j = 0; j < contatti.size(); j++) {
				if (j<=i) {continue;}
				s1 = contatti.get(i).toString();
				s2 = contatti.get(j).toString();
				if(s1.substring(s1.indexOf(',')).equals(s2.substring(s1.indexOf(',')))) {
					duplicates.add(contatti.get(i));
				}
			}
		}
		if (duplicates.size()==0) {
			System.out.println("No duplicate contacts!");
		} else {
			System.out.println("Found "+duplicates.size()+" duplicate contacts.");
			System.out.println(duplicates);
		}
		return duplicates;
	}
	
	public static void mergeDuplicates(Session session) {
		List<Contatto> duplicates = findDuplicates(session);
		Scanner s = new Scanner(System.in);
		while (duplicates.size()>0) {
			Transaction transaction = session.beginTransaction();
			System.out.println("Here are the duplicate contacts:");
			System.out.println(duplicates);
			System.out.println("Enter the id of the contact to merge (type exit to leave):");
			String st = s.next();
			if (st.equals("exit")) {transaction.commit(); break;}
			Contatto dup = null;
			for (Contatto c:duplicates) {
				if(st.equals(String.valueOf(c.getId()))) {
					dup = c;
					break;
				}
			}
			if (dup==null) {
				System.out.println("Invalid id");
				continue;
			}
			HibDelete.delete(session, dup);
			transaction.commit();
			duplicates = findDuplicates(session);
		}
		s.close();
		
	}
}
