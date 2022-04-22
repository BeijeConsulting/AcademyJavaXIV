package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.criteria.JPACriteria;
import it.beije.turing.file.RubricaCSV;
import it.beije.turing.file.RubricaXML;
import it.beije.turing.jdbc.JDBCmanager;
import it.beije.turing.jpa.EntityManagerSingleton;
import it.beije.turing.jpa.JpaManager;

//import it.beije.turing.file.*;

public class RubricaManager {
	public static String path = "C:\\Users\\Marco\\Desktop\\tmp\\rubrica.csv";
	public static ArrayList<Contatto> contatti = RubricaCSV.leggiRubrica(path);
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		mainMenu();
		// JpaManager.addContatti(contatti);

//		JpaManager.updateJpa();
//		JpaManager.readContatti();
//		JDBCmanager.addContatti(contatti);
//		JDBCmanager.readContatti();
//		scanner.close();
//		try {
//			RubricaXML.writeXML(contatti, path);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	// Prende un qualsiasi input dell'utente
	public static String prendiInput() {
		String input = scanner.nextLine();
		return input;

	}

	// Prende un input dall'utente finché non viene inserito un numero nel range di
	// valori min-max
	public static int prendiInput(int min, int max) {
		int input;
		do {
			System.out.println("Inserisci un numero da " + min + " a " + max);
			input = Integer.parseInt(scanner.nextLine());
		} while (input < min || input > max);

		return input;
	}

	// Mostra a schermo le varie opzioni possibili nella rubrica
	public static void mainMenu() {
		int input;
		do {
			System.out.println("0 - Aggiungi contatto");
			System.out.println("1 - Mostra contatti");
			System.out.println("2 - Modifica contatti");
			System.out.println("3 - Cancella contatti");
			System.out.println("4 - Cerca contatto");
			System.out.println("5 - Salva modifiche");
			System.out.println("6 - Trova duplicati");
			input = prendiInput(0, 6);
			smistaScelte(input);
		} while (input != 0);
	}

	public static void salvaFile() {
		// Salvo il file XML
		try {
			RubricaXML.writeXML(contatti, path);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Salvo il file csv
		RubricaCSV.scriviFile(contatti);

	}

	public static void aggiungiContatto() {
		Contatto c = new Contatto();
		c = creaContatto();
		contatti.add(c);
		salvaFile();
		JpaManager.addContatti(c);
		System.out.println("CONTATTO INSERITO !!!");
		mainMenu();
	}

	public static void smistaScelte(int input) {
		switch (input) {
		case 0:
			aggiungiContatto();
		case 1:
			mostraContatti();
			break;
		case 2:
			modificaContatto();
			break;
		case 3:
			cancellaContatti();
		case 4:
			List<Contatto> list = trovaContatti();
			for (Contatto c : list)
				System.out.println(c);
		case 5:
			salvaFile();
			break;
		case 6:
			trovaDuplicati();
			break;
		}
	}

	public static void cancellaContatti() {
		List<Contatto> list = trovaContatti();

		if (!list.isEmpty()) {
			JpaManager.deleteContatto(list.get(0), EntityManagerSingleton.createEntityManager());
			System.out.println("Contatto eliminato con successo.");
		} else {
			System.out.println("Contatto inesistente.");
		}
	}

	public static void modificaContatto() {
		List<Contatto> list = trovaContatti();

		if (!list.isEmpty()) {
			Contatto contatto = creaContatto();
			list.get(0).setCognome(contatto.getCognome());
			list.get(0).setNome(contatto.getNome());
			list.get(0).setEmail(contatto.getEmail());
			list.get(0).setTelefono(contatto.getTelefono());
			list.get(0).setNote(contatto.getNote());
			JpaManager.modifyContatto(list.get(0), EntityManagerSingleton.createEntityManager());
			System.out.println("Contatto modificato con successo.");
		} else {
			System.out.println("Contatto non trovato");
		}
	}

	public static List<Contatto> trovaContatti() {
		System.out.println("Inserisci id contatto: ");
		String input = scanner.nextLine();
		int id = Integer.parseInt(input);
		List<Contatto> list = JPACriteria.findContatto(id, EntityManagerSingleton.createEntityManager());
		return list;
	}

	public static void modificaContatti() {

//		Contatto c = new Contatto();
//		int index = trovaContatti();
//
//		if (index == -1) {
//			System.out.println("Contatto non trovato.");
//		} else {
//			c = creaContatto();
//			contatti.set(index, c);
//		}

	}

	public static Contatto creaContatto() {
		Contatto c = new Contatto();
		System.out.println("Inserire nome: ");
		c.setNome(scanner.nextLine());
		System.out.println("Inserire cognome: ");
		c.setCognome(scanner.nextLine());
		System.out.println("Inserire email: ");
		c.setEmail(scanner.nextLine());
		System.out.println("Inserire telefono: ");
		c.setTelefono(scanner.nextLine());
		System.out.println("Inserire note: ");
		c.setNote(scanner.nextLine());
		return c;
	}

	public static void mostraContatti() {
		System.out.println("Desideri ordinare i contatti?");
		System.out.println("1 - Ordine alfabetico (cognome)");
		System.out.println("2 - Ordine alfabetico (nome)");
		System.out.println("3 - No");
		List<Contatto> list = null;

		int input = prendiInput(1, 3);
		if (input == 1)
			list = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), input);
		else if (input == 2)
			list = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), input);
		else
			list = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), input);

		for (Contatto c : list) {
			System.out.println(c.toString());
		}
	}

	public static void trovaDuplicati() {
		List<Contatto> contatti = JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 1);
		List<Contatto> contattiCercati = new ArrayList<>();
		List<Contatto> doppi = new ArrayList<>();

		for (Contatto contatto : contatti) {
			if (isDoppio(contatto, contattiCercati)) {
				doppi.add(contatto);
				System.out.println("Doppio trovato.");
			} else {
				contattiCercati.add(contatto);
			}
		}
		for (Contatto c : doppi)
			System.out.println(c);
		if (doppi.isEmpty())
			System.out.println("Nessun doppio trovato.");
		else
			for(Contatto contatto : doppi)
				JpaManager.deleteContatto(contatto, EntityManagerSingleton.createEntityManager());

	}

	public static boolean isDoppio(Contatto contatto, List<Contatto> cerca) {
		for (Contatto c : cerca) {
			if (isContattoEqual(contatto, c))
				return true;
		}
		return false;
	}

	public static boolean isContattoEqual(Contatto c1, Contatto c2) {
		if (c1.getCognome().equals(c2.getCognome()) && c1.getNome().equals(c2.getNome())
				&& c1.getEmail().equals(c2.getEmail()) && c1.getTelefono().equals(c2.getTelefono())
				&& c1.getNote().equals(c2.getNote())) {
			return true;
		} else
			return false;
	}

}
