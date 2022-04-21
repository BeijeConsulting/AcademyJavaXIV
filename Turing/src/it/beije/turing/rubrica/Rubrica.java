package it.beije.turing.rubrica;


import it.beije.turing.file.XMLmanager;

import java.util.*;

public class Rubrica {

	public List<Contatto> contacts = new ArrayList<>();

	public Rubrica() {
		init();
	}

	private void init () {
		System.out.println("Init rubrica...");

		boolean repeat = true;

		Scanner scanner = new Scanner(System.in);

		do {

			Ask.genericsOperation();

			String answer = ScanAnswer.isValidAnswer(scanner, 0, 4);

			switch (Integer.parseInt(answer)) {
				case 0: {
					System.out.println("Closing program...");
					repeat = false;
					break;
				}
				case 1: {
					importOption(scanner);
					break;
				}
				case 2: {
					exportOption(scanner);
					break;
				}
				case 3: {
					searchOption(scanner);
					break;
				}
				case 4: {
					addOption(scanner);
					break;
				}
			}
		} while (repeat);

		scanner.close();
 	}

	public void importOption(Scanner scanner) {
		Ask.importOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				System.out.println("Type file path");
				String filePath = scanner.next();
				System.out.println("Type separator");
				String separator = scanner.next();

				contacts = MyCSVManager.loadRubricaFromCSV(filePath, separator);
			}
			case 2: {
				System.out.println("Type file path");
				String filePath = scanner.next();

				contacts = MyXMLManager.loadRubricaFromXML(filePath);
			}
			case 3: {

			}
		}
	}

	public void exportOption(Scanner scanner) {
		Ask.exportOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				System.out.println("Type file path to write new file");
				String filePath = scanner.next();

				MyCSVManager.writeRubricaCSV(contacts, filePath);
			}
			case 2: {
				System.out.println("Type file path to write new file");
				String filePath = scanner.next();

				MyXMLManager.writeRubricaXML(contacts, filePath);
			}
			case 3: {

			}
		}
	}

	public void searchOption(Scanner scanner) {
		Ask.searchOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 2);

		switch (Integer.parseInt(answer)) {
			case 1: {
				/*contacts = */
			}
			case 2: {

			}
			case 3: {

			}
		}
	}

	public void addOption(Scanner scanner) {
		Ask.addOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {

			}
			case 2: {

			}
			case 3: {

			}
		}
	}

	public void contactFoundOperation(Scanner scanner) {
		Ask.TODOWithContactFound();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 2);

		switch (Integer.parseInt(answer)) {
			case 1: {

			}
			case 2: {

			}
		}
	}

	public static void main(String[] args) {

		Rubrica rubrica = new Rubrica();
		/*rubrica.contacts = MyH8Manager.loadRubricaFromH8();

		for (Contatto contact : rubrica.contacts) {
			System.out.println(contact);
		}*/


	}
}
