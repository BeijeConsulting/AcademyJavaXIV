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
				readContactsCVS(scanner);
				break;
			}
			case 2: {
				readContactsXML(scanner);
				break;
			}
			case 3: {
				DBOption(scanner);
				break;
			}
		}
	}

	public void exportOption(Scanner scanner) {
		Ask.exportOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				exportToCSV(scanner);
				break;
			}
			case 2: {
				exportToXML(scanner);
				break;
			}
			case 3: {
				DBOption(scanner);
			}
		}
	}

	public void DBOption(Scanner scanner) {
		Ask.DBOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
		}
	}

	public void searchOption(Scanner scanner) {
		Ask.searchOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 2);

		switch (Integer.parseInt(answer)) {
			case 1: {
				readContactsCVS(scanner);

				List<Contatto> contactsFound = initSearch(scanner);
				print(contactsFound);
				break;
			}
			case 2: {
				readContactsXML(scanner);

				List<Contatto> contactsFound = initSearch(scanner);
				print(contactsFound);
				break;
			}
			case 3: {
				DBOption(scanner);
				break;
			}
		}
	}

	public void addOption(Scanner scanner) {
		Ask.addOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				Contatto newContact = createContact(scanner);
				if (newContact != null) {
					String filePath = takeInput(scanner, "Type file path where to add new contact:");
					MyCSVManager.addContactCSV(newContact, filePath);
				} else {
					System.err.println("Invalid contact");
				}
				break;
			}
			case 2: {
				Contatto newContact = createContact(scanner);
				if (newContact != null) {
					String filePath = takeInput(scanner, "Type file path where to add new contact:");
					MyXMLManager.addContactXML(newContact, filePath);
				} else {
					System.err.println("Invalid contact");
				}
				break;
			}
			case 3: {
				break;
			}
		}
	}

	public void contactFoundOperation(Scanner scanner) {
		Ask.TODOWithContactFound();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 2);

		switch (Integer.parseInt(answer)) {
			case 1: {

				break;
			}
			case 2: {
				break;
			}
		}
	}

	public void readContactsCVS(Scanner scanner) {
		String filePath = takeInput(scanner, "Type file path");
		String separator = takeInput(scanner, "Type separator");

		contacts = MyCSVManager.loadRubricaFromCSV(filePath, separator);
	}

	public void readContactsXML(Scanner scanner) {
		String filePath = takeInput(scanner, "Type file path");

		contacts = MyXMLManager.loadRubricaFromXML(filePath);
	}

	public void exportToCSV(Scanner scanner) {
		String filePath = takeInput(scanner, "Type file path to write new file");

		MyCSVManager.writeRubricaCSV(contacts, filePath);
	}

	public void exportToXML(Scanner scanner) {
		String filePath = takeInput(scanner, "Type file path to write new file");

		MyXMLManager.writeRubricaXML(contacts, filePath);
	}

	public List<Contatto> initSearch(Scanner scanner) {
		String word = takeInput(scanner, "Type word or number to search:");

		return SearchContactsBy(word);
	}

	public List<Contatto> SearchContactsBy(String word) {
		List<Contatto> contactsFound = new ArrayList<>();

		for (Contatto c : contacts) {
			if (c.getNome() != null && c.getNome().contains(word)) {
				contactsFound.add(c);
			} else if (c.getCognome() != null && c.getCognome().contains(word)) {
				contactsFound.add(c);
			} else if (c.getTelefono() != null && c.getTelefono().contains(word)) {
				contactsFound.add(c);
			} else if (c.getEmail() != null && c.getEmail().contains(word)) {
				contactsFound.add(c);
			} else if (c.getNote() != null && c.getNote().contains(word)) {
				contactsFound.add(c);
			}
		}

		return contactsFound;
	}

	public void print(List<Contatto> contacts) {
		if (contacts.size() > 0) {
			System.out.println("Contacts found: ");
			for (Contatto c : contacts) {
				System.out.println(c);
			}
		} else {
			System.out.println("Contacts NOT found");
		}

	}

	public Contatto createContact(Scanner scanner) {
		Contatto contact = null;
		contact = Ask.newContact(scanner);

		return contact;
	}

	public String takeInput(Scanner scanner, String ask) {
		System.out.println(ask);
		return scanner.next();
	}

	public static void main(String[] args) {

		Rubrica rubrica = new Rubrica();
		/*rubrica.contacts = MyH8Manager.loadRubricaFromH8();

		for (Contatto contact : rubrica.contacts) {
			System.out.println(contact);
		}*/


	}
}
