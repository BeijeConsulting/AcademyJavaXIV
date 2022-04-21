package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class PERSDuplicate {
	public static List<Contatto> findDuplicates(EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
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
	
	public static void mergeDuplicates(EntityManager entityManager) {
		List<Contatto> duplicates = findDuplicates(entityManager);
		Scanner s = new Scanner(System.in);
		while (duplicates.size()>0) {

			System.out.println("Here are the duplicate contacts:");
			System.out.println(duplicates);
			System.out.println("Enter the id of the contact to merge (type exit to leave):");
			String st = s.next();
			if (st.equals("exit")) { break;}
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
			PERSDelete.delete(entityManager, dup);
			
			duplicates = findDuplicates(entityManager);
		}
		s.close();
		
	}
}
