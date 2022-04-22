package it.beije.turing.rubrica;

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

			String answer = ScanAnswer.isValidAnswer(scanner, 0, 6);

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
				case 5: {
					showOption(scanner);
					break;
				}
				case 6: {
					duplicateOption(scanner);
					break;
				}
			}
		} while (repeat);

		scanner.close();
 	}

	public void showOption(Scanner scanner) {
		Ask.fromOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				readContactsCVS(scanner);
				print(contacts);
				break;
			}
			case 2: {
				readContactsXML(scanner);
				print(contacts);
				break;
			}
			case 3: {
				JPAOperation(scanner, "import");
				print(contacts);
				contactFoundOperation(scanner, contacts);
				break;
			}
		}
	}

	public void importOption(Scanner scanner) {
		Ask.fromOperation();
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
				JPAOperation(scanner, "import");
				break;
			}
		}
	}

	public void exportOption(Scanner scanner) {
		Ask.toOperation();
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
				JPAOperation(scanner, "export");
			}
		}
	}

	/*public void DBOption(Scanner scanner, String operation) {
		Ask.DBOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				JDBCOperation(scanner, operation);
				break;
			}
			case 2: {
				H8Operation(scanner, operation);
				break;
			}
			case 3: {
				JPAOperation(scanner, operation);
				break;
			}
		}
	}*/

	public void searchOption(Scanner scanner) {
		Ask.inOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

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
				JPAOperation(scanner, "search");
				break;
			}
		}
	}

	public void addOption(Scanner scanner) {
		Ask.toOperation();
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
				JPAOperation(scanner, "add");
				break;
			}
		}
	}

	public void duplicateOption(Scanner scanner) {
		Ask.fromOperation();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				readContactsCVS(scanner);

				findDuplicates();
				break;
			}
			case 2: {
				readContactsXML(scanner);

				findDuplicates();
				break;
			}
			case 3: {
				List<Contatto> duplicates = new ArrayList<>();
				List<Object[]> objects = MyJPAManager.findDuplicates();
				for (Object[] arrObj : objects) {
					Contatto contact = (Contatto)arrObj[0];
					Long times = (Long)arrObj[1];
					duplicates.add(contact);
					print(contact, times);
				}
				if (!duplicates.isEmpty()) {
					duplicateOperation(scanner, duplicates);
				}
				break;
			}
		}

	}

	public void duplicateOperation(Scanner scanner, List<Contatto> contacts) {
		Ask.TODOWithDuplicate();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 2);

		switch (Integer.parseInt(answer)) {
			case 1: {
				MyJPAManager.deleteDuplicates(contacts);
				break;
			}
			case 2: {
				System.out.println("Okay, nothing.");
				break;
			}
		}
	}

	public void findDuplicates() {
		List<Contatto> duplicates = null;

		if ((contacts.size() > 1) && !collectDuplicates().isEmpty()) {
			duplicates = collectDuplicates();
			print(duplicates);
		} else {
			System.out.println("No contact duplicates found.");
		}
	}

	public List<Contatto> collectDuplicates() {
		List<Contatto> duplicates = new ArrayList<>();

		for (int i = 0; i < contacts.size(); i++) {
			if (duplicates.contains(contacts.get(i))) continue;

			List<Contatto> tempDuplicates = new ArrayList<>();
			tempDuplicates.add(contacts.get(i));

			for (int j = i + 1; j < contacts.size(); j++) {
				Contatto currentContact = contacts.get(i);
				String phone = contacts.get(j).getTelefono();

				if (currentContact.getTelefono().equalsIgnoreCase(phone)) {
					tempDuplicates.add(contacts.get(j));
				}
			}

			if (tempDuplicates.size() > 1) {
				duplicates.addAll(tempDuplicates);
			}
		}

		return duplicates;
	}

	public void contactFoundOperation(Scanner scanner, List<Contatto> contacts) {
		Ask.TODOWithContactFound();
		String answer = ScanAnswer.isValidAnswer(scanner, 1, 3);

		switch (Integer.parseInt(answer)) {
			case 1: {
				System.out.println("Select contact id:");
				String id = ScanAnswer.isValidAnswer(scanner, 1, contacts.size());
				for (Contatto c : contacts) {
					if (Integer.parseInt(id) == c.getId()){
						MyJPAManager.updateContact(scanner, Integer.parseInt(id));
					} else {
						System.out.println("Invalid contact");
					}
				}

				break;
			}
			case 2: {
				System.out.println("Select contact id:");
				String id = ScanAnswer.isValidAnswer(scanner, 1, contacts.size());
				Contatto contact = null;

				for (Contatto c: contacts) {
					if (Integer.parseInt(id) == c.getId()) contact = c;
				}
				if (contact != null) {
					MyJPAManager.deleteContacts(contact);
				} else {
					System.out.println("Invalid contact");
				}

				break;
			}
			case 3: {
				System.out.println("Okay, nothing.");
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
		if (contacts.isEmpty()) {
			System.out.println("Need to load contacts first");
		} else {
			String filePath = takeInput(scanner, "Type file path to write new file");

			MyCSVManager.writeRubricaCSV(contacts, filePath);
		}

	}

	public void exportToXML(Scanner scanner) {
		if (contacts.isEmpty()) {
			System.out.println("Need to load contacts first");
		} else {
			String filePath = takeInput(scanner, "Type file path to write new file");

			MyXMLManager.writeRubricaXML(contacts, filePath);
		}

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
		if ((contacts != null) && !contacts.isEmpty()) {
			System.out.println("Contacts found: ");
			for (Contatto c : contacts) {
				System.out.println(c);
			}
		} else {
			System.out.println("Contacts NOT found");
		}

	}

	public void print(Contatto contact, Long duplicates) {
		if (contact != null) {
			System.out.println("Duplicate contact found " + duplicates + ":");
			System.out.println(contact);
		} else {
			System.out.println("Contacts NOT found");
		}

	}

	public Contatto createContact(Scanner scanner) {
		Contatto contact = null;
		contact = Ask.newContact(scanner);

		return contact;
	}

	public static String takeInput(Scanner scanner, String ask) {
		System.out.println(ask);
		return scanner.next();
	}

	/*public void JDBCOperation(Scanner scanner, String operation) {
		if (operation.equalsIgnoreCase("import")) {
			contacts = MyJDBCManager.importRubrica();
		} else if (operation.equalsIgnoreCase("export")) {

			if (contacts.size() == 0) {
				System.out.println("Need to load contacts first");
			} else {
				MyJDBCManager.exportRubrica(contacts);
			}
		} else if (operation.equalsIgnoreCase("search")) {
			String word = takeInput(scanner, "Type word or number to search:");

			List<Contatto> contacts = MyJDBCManager.searchContactBy(word);
			print(contacts);
		} else {
			//add contact with JDBC
		}
	}*/

	/*public void H8Operation(Scanner scanner, String operation) {
		if (operation.equalsIgnoreCase("import")) {
			//TODO import contact with Hibernate
		} else if (operation.equalsIgnoreCase("export")) {
			//TODO export contact with Hibernate
		} else if (operation.equalsIgnoreCase("search")) {
			//TODO search contact with Hibernate
		} else {
			//TODO add contact with Hibernate
		}
	}*/

	public void JPAOperation(Scanner scanner, String operation) {
		if (operation.equalsIgnoreCase("import")) {

			contacts = MyJPAManager.importRubrica();
		} else if (operation.equalsIgnoreCase("export")) {

			if (contacts.isEmpty()) {
				System.out.println("Need to load contacts first");
			} else {
				MyJPAManager.exportRubrica(contacts);
			}
		} else if (operation.equalsIgnoreCase("search")) {
			String word = takeInput(scanner, "Type word or number to search:");

			List<Contatto> contacts = MyJPAManager.searchContactBy(word);
			print(contacts);
			if (contacts != null && !contacts.isEmpty()) {
				contactFoundOperation(scanner, contacts);
			}

		} else if (operation.equalsIgnoreCase("add")) {
			Contatto newContact = createContact(scanner);
			if (newContact != null) {
				MyJPAManager.addContact(newContact);
			} else {
				System.err.println("Invalid contact");
			}
		} else {
			//TODO duplicate contact with JPA
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
