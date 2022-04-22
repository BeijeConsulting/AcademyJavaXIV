package it.beije.turing.gestorerubrica;

import java.util.Scanner;

import javax.persistence.EntityManager;

import it.beije.turing.db.GestoreRubrica;
import it.beije.turing.db.JPAentityManagerFactory;

public class HomeGestoreRubrica {
	
	public static void stampaMenu() {
		System.out.print("\n<<<Menu Rubrica>>>\n");
		System.out.println("1- Stampa contatti (print)");
		System.out.println("2- Cerca contatto (find)");
		System.out.println("3- Inserisci nuovo contatto (insert)");
		System.out.println("4- Modifica contatto (modify)");
		System.out.println("5- Cancella contatto (delete)");
		System.out.println("6- Trova contatti duplicati (findDup)");
		System.out.println("7- Unisci contatti duplicati (mergeDup)");
		System.out.println("8- Export Database (export)");
		System.out.println("9- Import to Database (import)");
		System.out.println("10- Esci dal gestore della rubrica (exit)");
		System.out.print("Scrivi la parola tra parentesi per la funzione che vuoi avviare sulla rubrica inserita: ");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		
		GestoreRubrica.stampaMenu();

		String st = s.next();
		do {
			st = st.toLowerCase();
			if(st.equalsIgnoreCase("exit")) {				
				System.out.println("\n\n<<Gestore rubrica chiuso.>>");
			} else {				
				switch(st) {
					case "print":
						GestoreFunction.stampaRubrica(s);
						break;
					case "find":
						GestoreFunction.trovaContatto(s);
						break;
					case "insert":
						GestoreFunction.inserisciContatto(s);
						break;
					case "modify":
						GestoreFunction.modificaContatto(s);
						break;
					case "delete":
						GestoreFunction.eliminaContatto(s);
						break;
					case "finddup":
						GestoreFunction.trovaContattiDuplicati();
						break;
					case "mergedup":
						GestoreFunction.unisciContattiDuplicati(s);
						break;
					case "export":
						GestoreFunction.exportDatabase(s);
						break;
					case "import":
						GestoreFunction.importDatabase(s);
						break;
					default:
						System.out.println("\n<<Scrivi un input valido per il gestore.>>");
				}
				GestoreRubrica.stampaMenu();
				st = s.next();
			}
		} while (!st.equalsIgnoreCase("exit"));
		entityManager.close();
		s.close();

	}

}
