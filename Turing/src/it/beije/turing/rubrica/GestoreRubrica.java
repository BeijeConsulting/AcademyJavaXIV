package it.beije.turing.rubrica;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GestoreRubrica {
	
	public static void stampaMenu() {
		System.out.print("\n\n<<<Menu Rubrica>>>\n");
		System.out.println("1- Stampa contatti (print)");
		System.out.println("2- Cerca contatto (find)");
		System.out.println("3- Inserisci nuovo contatto (insert)");
		System.out.println("4- Modifica contatto (modify)");
		System.out.println("5- Cancella contatto (delete)");
		System.out.println("6- Trova contatti duplicati (findDup)");
		System.out.println("7- Unisci contatti duplicati (mergeDup)");
		System.out.println("8- Esci dal gestore della rubrica (exit)");
		System.out.print("Scrivi la parola tra parentesi per la funzione che vuoi avviare sulla rubrica inserita: ");
	}

	public static void stampaRubrica(List<Contatto> contatti) {
		System.out.println("Rubrica");
	}
	
	public static void trovaContatto(List<Contatto> contatti) {
		System.out.println("Trova contatto");
	}
	
	public static void inserisciContatto(List<Contatto> contatti, String path, String typeFile) {
		System.out.println("Inserisci Contatto");
	}
	
	public static void modificaContatto(List<Contatto> contatti, String path, String typeFile) {
		System.out.println("Modifica Contatto");
	}
	
	public static void eliminaContatto(List<Contatto> contatti, String path, String typeFile) {
		System.out.println("Elimina Contatto");
	}
	
	public static void trovaContattiDuplicati(List<Contatto> contatti) {
		System.out.println("Trova contatti duplicati");
	}
	
	public static void unisciContattiDuplicati(List<Contatto> contatti, String path, String typeFile) {
		System.out.println("Unisci contatti duplicati");
	}
	
	public static void gestoreRubrica() {
		Scanner s = new Scanner(System.in);
		List<Contatto> contatti = null;
		
		String typeFile = "";
		int x = 0;
		do {
			System.out.print("Vuoi leggere un file csv o un file xml? ");
			typeFile = s.next();
			
			if(typeFile.equalsIgnoreCase("csv")) {
				x++;
			} else if(typeFile.equalsIgnoreCase("xml")) {
				x++;
			} else {
				System.out.print("Inserisci un tipo di file valido -> ");
			}
		} while(x == 0);
		
		String path = "";
		String separatore = "";
		boolean virgolette = false;
		int i = 0;
		do {
			System.out.print("Inserisci il path del file che vuoi leggere: ");
			path = s.next();
			if(typeFile.equalsIgnoreCase("csv")) {
				System.out.print("Inserisci il separatore utilizzato: ");
				separatore = s.next();
				System.out.print("Nel file sono state utilizzate le virgolette per scrivere i singoli campi? (input: Si/No) ");
				String v = s.next();
				if(v.equalsIgnoreCase("si")) {
					virgolette = true;
				}
			}
			
			if(typeFile.equalsIgnoreCase("csv")) {
				try {
					contatti = RubricaController.loadRubricaFromCSV(path, separatore, virgolette);
					i++;
				} catch(IOException ioEx) {
					System.out.print("Inserisci dati validi -> ");
				}
			} else if(typeFile.equalsIgnoreCase("xml")) {
				try {
					contatti = RubricaController.loadRubricaFromXML(path);
					i++;
				} catch(Exception Ex) {
					Ex.printStackTrace();
					System.out.print("Inserisci un path valido -> ");
				}
			}
		} while(i == 0);
		
		GestoreRubrica.stampaMenu();
		//System.out.println(contatti);
		
		String st = s.next();
		while (!st.equalsIgnoreCase("exit")) {
			st = st.toLowerCase();
			switch(st) {
				case "print":
					stampaRubrica(contatti);
					break;
				case "find":
					trovaContatto(contatti);
					break;
				case "insert":
					inserisciContatto(contatti, path, typeFile);
					break;
				case "modify":
					modificaContatto(contatti, path, typeFile);
					break;
				case "delete":
					eliminaContatto(contatti, path, typeFile);
					break;
				case "finddup":
					trovaContattiDuplicati(contatti);
					break;
				case "mergedup":
					unisciContattiDuplicati(contatti, path, typeFile);
					break;
				default:
					System.out.println("\n<<Scrivi un input valido per il gestore.>>");
			}
			GestoreRubrica.stampaMenu();
			st = s.next();
			if(st.equalsIgnoreCase("exit")) {				
				System.out.println("\n\n<<Gestore rubrica chiuso.>>");
			}
		}
		s.close();
	}

	public static void main(String[] args) {
		
		gestoreRubrica();

	}

}
