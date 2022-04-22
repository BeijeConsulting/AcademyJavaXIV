package it.beije.turing.challenge.rubrica;

import java.util.Scanner;

public class TestApp {
	public static void main(String[] args) {
		RubricaManager rubricaManager = new RubricaManager();
		Scanner s = new Scanner(System.in);
		String command = null;
		LOOP:while(true) {
			command = null;
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Gestore Rubrica, inserire uno dei comandi elencati (numero).");
			System.out.println("1: Importa\n"
					+ "2: Esporta\n"
					+ "3: Stampa\n"
					+ "4: Altro\n"
					+ "0: Esci");
			command = s.nextLine();
			if(command == null || command.length() == 0 || command.isEmpty()) {
				System.out.println("Inserire comando!");
				continue;
			}
			switch(command) {
				case "1":
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("  Menù Importa");
					System.out.println("1: File .csv\n"
							+ "2: File .xml\n"
							+ "3: Database\n"
							+ "0: Indietro");
					command = s.nextLine();
					if(command == null || command.length() == 0 || command.isEmpty()) {
						System.out.println("Inserire comando!");
						continue;
					}
/**********************************************************************************************************************************************/					
					switch(command) {
						case "1":
							rubricaManager.setAllContatti(RubricaCSV.readRubricaFromFile(s));
							break;
						case "2":
							rubricaManager.setAllContatti(RubricaXML.readRubricaFromFile(s));
							break;
						case "3":
							rubricaManager.setAllContatti(RubricaJPA.readRubricaFromDB());
							break;
						default:
							System.out.println("Quitting...");
							continue;
					}
					break;
/**********************************************************************************************************************************************/					
				case "2":
					if(rubricaManager.getAllContatti() == null) {
						System.out.println("Impossibile fare la Export se non si fa prima almeno una Import!");
						continue;
					}
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("  Menù Esporta");
					System.out.println("1: File .csv\n"
							+ "2: File .xml\n"
							+ "3: Database\n"
							+ "0: Indietro");
					command = s.nextLine();
					if(command == null || command.length() == 0 || command.isEmpty()) {
						System.out.println("Inserire comando!");
						continue;
					}
					switch(command) {
						case "1":
							rubricaManager.setAllContatti(RubricaCSV.writeRubricaOnFile(rubricaManager.getAllContatti(),s));
							break;
						case "2":
							rubricaManager.setAllContatti(RubricaXML.writeRubricaOnFile(rubricaManager.getAllContatti(),s));
							break;
						case "3":
							rubricaManager.setAllContatti(RubricaJPA.writeRubricaOnDB(rubricaManager.getAllContatti()));
							break;
						default:
							System.out.println("Quitting...");
							continue;
					}
					break;
/**********************************************************************************************************************************************/
				case "3":
					if(rubricaManager.getAllContatti() == null) {
						System.out.println("Impossibile fare la Print se non si fa prima almeno una Import!");
						continue;
					}
					if(!rubricaManager.sort(s)) {
						break;
					}
					rubricaManager.printAllContatti();
					break;
/**********************************************************************************************************************************************/
				case "4":
					if(rubricaManager.getAllContatti() == null) {
						System.out.println("Impossibile fare Altro se non si fa prima almeno una Import!");
						continue;
					}
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("  Menù Funzioni Varie");
					System.out.println("1: Aggiungi Contatto\n"
							+ "2: Modifica Contatto\n"
							+ "3: Elimina Contatto\n"
							+ "4: Elimina Tutti i Contatti\n"
							+ "5: Trova Contatti Duplicati\n"
							+ "6: Unisci Contatti Duplicati\n"
							+ "7: Ricerca Contatto\n"
							+ "0: Indietro");
					command = s.nextLine();
					if(command == null || command.length() == 0 || command.isEmpty()) {
						System.out.println("Inserire comando!");
						continue;
					}
					switch(command) {
						case "1":
							rubricaManager.AggiungiContatto(s);
							break;
						case "2":
							rubricaManager.ModificaContatto(s);
							break;
						case "3":
							rubricaManager.EliminaContatto(s);
							break;
						case "4":
							rubricaManager.EliminaTuttiContatti();
							break;
						case "5":
							for(Contatto c : rubricaManager.TrovaContattiDuplicati(s)) {
								System.out.println(c);
							}
							break;
						case "6":
							rubricaManager.UnisciContattiDuplicati(s);
							break;
						case "7":
							rubricaManager.cercaContatto(s);
							break;
						default:
							System.out.println("Quitting...");
							continue;
					}
					break;
/**********************************************************************************************************************************************/
				case "0":
					System.out.println("Quitting Program...");
					break LOOP;
				default:
					System.out.println("Inserire comando valido! "+command+" non riconosciuto come comando!");
			}
		}
		

	}

}
