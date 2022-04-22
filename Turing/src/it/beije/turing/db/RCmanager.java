package it.beije.turing.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.beije.turing.rubrica.*;

public class RCmanager {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("Per uscire, digitare \"exit\".");
		Scanner s = new Scanner(System.in);
		String command = new String();
		String st = new String();
		while (!command.equalsIgnoreCase("exit")) {

			System.out.println("\n\n"
					+"1: View contacts\n"
					+"2: Insert new contact manually\n"
					+"3: Import/Export CSV\n"
					+"4: Import/Export XML\n"
					+"5: Search contact\n"
					+"6: Update contact\n"
					+"7: Delete contact\n"
					+"8: Find/Merge duplicates\n"
					+"exit: leave the program");
			command = s.nextLine();

			switch (command) {
			case("1"):
				RCViewer.view(entityManager);
			break;
			case("2"):
				RCInsert.insert(entityManager);
			break;	
			case("3"):
				System.out.println("Do you want to Import (I) or Export (E) (exit to leave)?");
			st = s.nextLine();
			while(!st.equals("exit")) {
				if(st.equals("I")) {
					System.out.println("Insert CSV file path:");
					String csvPath = s.nextLine();
					System.out.println("Insert CSV separator:");
					String separator = s.nextLine();
					RCInsert.importCSVtoDB(entityManager, csvPath, separator);
				} else if (st.equals("E")){
					System.out.println("Insert CSV file path:");
					String csvPath = s.nextLine();
					System.out.println("Insert CSV separator:");
					String separator = s.nextLine();
					CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
					CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
					Root<Contatto> con = q.from(Contatto.class);
					q.select(con);
					Query query = entityManager.createQuery(q);
					List<Contatto> contatti = query.getResultList();
					RCexport.writeCSVfile(contatti, new File(csvPath), separator);
				}
			}
			break;
			case("4"):
				System.out.println("Do you want to Import (I) or Export (E) (exit to leave)?");
				st = s.nextLine();
				while(!st.equals("exit")) {
					if(st.equals("I")) {
						System.out.println("Insert XML file path:");
						String csvPath = s.nextLine();
						System.out.println("Insert XML separator:");
						String separator = s.nextLine();
						RCInsert.importXMLtoDB(entityManager, csvPath);
					} else if (st.equals("E")){
						System.out.println("Insert XML file path:");
						String csvPath = s.nextLine();
						System.out.println("Insert XML separator:");
						String separator = s.nextLine();
						CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
						CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
						Root<Contatto> con = q.from(Contatto.class);
						q.select(con);
						Query query = entityManager.createQuery(q);
						List<Contatto> contatti = query.getResultList();
						RCexport.writeXMLfile(contatti, new File(csvPath));
					}
				}
			break;
			case("5"):
				List<Contatto> results = RCSearch.search(entityManager);
				for (Contatto c : results) {
					System.out.println(c);
				}
			break;
			case("6"):
				RCViewer.view(entityManager);
			System.out.println("enter id of the contact to update:");
			st = s.nextLine();
			Contatto resultUp = RCSearch.search(entityManager, st);
			RCUpdate.update(entityManager, resultUp);
			break;
			case("7"):
				RCViewer.view(entityManager);
			System.out.println("enter id of the contact to update:");
			st = s.nextLine();
			Contatto resultDel = RCSearch.search(entityManager, st);
			RCDelete.delete(entityManager, resultDel);
			break;
			case("8"):
				System.out.println("Do you want to See duplicates (S) or Merge duplicates (M) (exit to leave)?");
				st = s.nextLine();
				while(!st.equals("exit")) {
					if(st.equals("S")) {
						List<Contatto> contatti = RCDuplicate.findDuplicates(entityManager);
						for (Contatto c : contatti) {
							System.out.println(c);
						}
					} else if (st.equals("M")){
						RCDuplicate.mergeDuplicates(entityManager);
					}
				}
			break;
			case("exit"):
				System.out.println("Leaving program.");
			st = command;
			continue;
			default:
				System.out.println("Invalid input");
				continue;
			}
			entityManager.close();

		}
	}

}
