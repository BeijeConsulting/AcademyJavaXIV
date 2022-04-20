package it.beije.turing.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;

//import it.beije.turing.file.*;

public class RubricaManager {
	public static String path = "C:\\Users\\Marco\\Desktop\\tmp\\rubrica.csv";
	public static ArrayList<Contatto> contatti = RubricaCSV.leggiRubrica(path);
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//JDBCmanager.addContatti(contatti);
		JDBCmanager.readContatti();
		mainMenu();
		scanner.close();
		try {
			RubricaXML.writeXML(contatti, path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String prendiInput() {
		String input = scanner.nextLine();
		return input;

	}

	public static int prendiInput(int min, int max) {

		int input;
		do {
			System.out.println("Inserisci un numero da " + min + " a " + max);
			input = Integer.parseInt(scanner.nextLine());
		} while (input < min || input > max);

		return input;
	}

	public static void mainMenu() {
		int input;
		do {
			System.out.println("0 - Aggiungi contatto");
			System.out.println("1 - Mostra contatti");
			System.out.println("2 - Modifica contatti");
			System.out.println("3 - Cancella contatti");
			System.out.println("4 - Trova contatti duplicati");
			System.out.println("5 - Salva modifiche");
			input = prendiInput(0, 5);
			smistaScelte(input);
		} while (input != 0);
	}

	public static void salvaFile() {
		try {
			RubricaXML.writeXML(contatti, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RubricaCSV.scriviFile(contatti);
	}

	public static void aggiungiContatto() {
		Contatto c = new Contatto();
		c = creaContatto();
		contatti.add(c);
		System.out.println("CONTATTO INSERITO !!!");
	}

	public static void smistaScelte(int input) {
		switch (input) {
		case 0:
			aggiungiContatto();
		case 1:
			mostraContatti();
			break;
		case 2:
			modificaContatti();
			break;
		case 3:
			cancellaContatti();
		case 5:
			salvaFile();
			break;
		}
	}

	public static void cancellaContatti() {
		int index = trovaContatti();

		if (index == -1) {
			System.out.println("Contatto non trovato.");
		} else {
			System.out.println("Contatto rimosso");
			contatti.remove(index);
		}
	}

	public static int trovaContatti() {
		System.out.println("Cercare il contatto da modificare inserendo la sua email: ");
		String input = scanner.nextLine();
		int index = -1;
		Contatto c = null;
		for (int i = 0; i < contatti.size(); i++) {
			if (contatti.get(i).equals(input)) {
				c = contatti.get(i);
				index = i;
			}
		}

		return index;
	}

	public static void modificaContatti() {

		Contatto c = new Contatto();
		int index = trovaContatti();

		if (index == -1) {
			System.out.println("Contatto non trovato.");
		} else {
			c = creaContatto();
			contatti.set(index, c);
		}

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
		return c;
	}

	public static void mostraContatti() {
		System.out.println("Desideri ordinare i contatti?");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		int input = prendiInput(1, 2);
		if (input == 1)
			// Collections.sort(contatti);
			for (Contatto c : contatti) {
				System.out.println(c.toString());
			}

	}

}
