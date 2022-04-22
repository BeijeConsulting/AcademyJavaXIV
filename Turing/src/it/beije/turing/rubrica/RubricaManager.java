package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import it.beije.turing.criteria.JPACriteria;
import it.beije.turing.file.RubricaCSV;
import it.beije.turing.file.RubricaXML;
import it.beije.turing.jpa.EntityManagerSingleton;
import it.beije.turing.jpa.JpaManager;

public class RubricaManager {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		mainMenu();
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
			System.out.println("______________________________");
			System.out.println("0 - Aggiungi contatto");
			System.out.println("1 - Mostra contatti");
			System.out.println("2 - Modifica contatti");
			System.out.println("3 - Cancella contatti");
			System.out.println("4 - Cerca contatto");
			System.out.println("5 - Elimina contatti doppi");
			System.out.println("6 - Import da file .xml");
			System.out.println("7 - Export in file .xml");
			System.out.println("8 - Import da file .csv");
			System.out.println("9 - Export in file .csv");
			System.out.println("______________________________");
			input = prendiInput(0, 10);
			smistaScelte(input);
		} while (input != 0);
	}

	public static void aggiungiContatto() {
		Contatto c = new Contatto();
		c = creaContatto();
		JpaManager.addContatti(c);
		System.out.println("Contatto inserito.");
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
			break;
		case 4:
			List<Contatto> list = trovaContatti();
			if (list.isEmpty())
				System.out.println("Contatto non trovato");
			else {
				System.out.println("[RISULTATI]");
				for (Contatto c : list)
					System.out.println(c);
			}
			break;
		case 5:
			trovaDuplicati();
			break;
		case 6:
			importFromXml();
			break;
		case 7:
			exportInXml(JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 0));
			break;
		case 8:
			importFromCsv();
			break;
		case 9:
			exportInCsv(JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 0));
			break;
		}
	}

	public static void exportInXml(List<Contatto> c) {
		String path;

		do {
			System.out.println("Inserire percorso in cui salvare il file: ");
			path = prendiInput();
		} while (!path.endsWith(".xml"));

		RubricaXML.writeXML(c, path);
	}

	public static void exportInCsv(List<Contatto> c) {
		String path;

		do {
			System.out.println("Inserire percorso in cui salvare il file: ");
			path = prendiInput();
		} while (!path.endsWith(".csv"));

		RubricaCSV.scriviFile(c, path);
	}

	public static void importFromXml() {
		String path;

		do {
			System.out.println("Inserire il percorso del file da importare: ");
			path = prendiInput();
		} while (!path.endsWith(".xml"));

		List<Contatto> xmlContatti = RubricaXML.readXML(path);
		JpaManager.addContatti(xmlContatti);
		System.out.println("Finito");

	}

	public static void importFromCsv() {
		String path;

		do {
			System.out.println("Inserire il percorso del file da importare: ");
			path = prendiInput();
		} while (!path.endsWith(".csv"));

		List<Contatto> csvContatti = RubricaCSV.leggiRubrica(path);
		JpaManager.addContatti(csvContatti);
		System.out.println("Finito");

	}

	public static void cancellaContatti() {
		List<Contatto> list = trovaContatti();

		if (!list.isEmpty()) {
			for (Contatto contatto : list)
				JpaManager.deleteContatto(contatto, EntityManagerSingleton.createEntityManager());
			System.out.println("Contatti eliminati con successo.");
		} else {
			System.out.println("Contatto inesistente.");
		}
	}

	public static void modificaContatto() {
		System.out.println("Inserisci id contatto: ");
		int id = Integer.parseInt(scanner.nextLine());
		List<Contatto> list = JPACriteria.findContatto(id, EntityManagerSingleton.createEntityManager());
		
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
		System.out.println("0 - Cerca per id");
		System.out.println("1 - Cerca per cognome");
		System.out.println("2 - Cerca per nome");
		System.out.println("3 - Cerca per email");
		int x = prendiInput(0, 3);
		String input;
		List<Contatto> list = null;
		switch (x) {
		case 0:
			System.out.println("Inserisci id contatto: ");
			input = scanner.nextLine();
			int id = Integer.parseInt(input);
			list = JPACriteria.findContatto(id, EntityManagerSingleton.createEntityManager());
			break;
		case 1:
			System.out.println("Inserisci cognome contatto: ");
			input = scanner.nextLine();
			System.out.println(input);
			list = JPACriteria.findContatto(input, EntityManagerSingleton.createEntityManager(), x);
			break;
		case 2:
			System.out.println("Inserisci nome contatto: ");
			input = scanner.nextLine();
			list = JPACriteria.findContatto(input, EntityManagerSingleton.createEntityManager(), x);
			break;
		case 3:
			System.out.println("Inserisci email contatto: ");
			input = scanner.nextLine();
			list = JPACriteria.findContatto(input, EntityManagerSingleton.createEntityManager(), x);
			break;

		}

		return list;
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
			for (Contatto contatto : doppi)
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
