package it.beije.turing.rubrica;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.file.CSVmanager;

public class ScannerExample {
	
	public static List<Contatto> addScanner(String csvPath, String separatore, boolean virgolette, int nContatti) {
		List<Contatto> contatti = null;
		
		try {			
			contatti = CSVmanager.loadRubricaFromCSV(csvPath, separatore, virgolette);
		} catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
		
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < nContatti; i++) {
			Contatto contatto = new Contatto();
			System.out.print("\nInserisci nome: ");
			contatto.setNome(s.nextLine());
			System.out.print("Inserisci cognome: ");
			contatto.setCognome(s.nextLine());
			System.out.print("Inserisci telefono: ");
			contatto.setTelefono(s.nextLine());
			System.out.print("Inserisci email: ");
			contatto.setEmail(s.nextLine());
			System.out.print("Inserisci note: ");
			contatto.setNote(s.nextLine());
			contatti.add(contatto);
		}
		s.close();
		
		return contatti;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//List<Contatto> contatti = RubricaCsvController.readCSV("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.csv", false);
		//System.out.println(contatti);
		//RubricaCsvController.writeCSV(contatti, "/Users/lorenzoorru0/Desktop/CSVjava/rubricaNew.csv");
		//RubricaCsvController.scannerCSV("/Users/lorenzoorru0/Desktop/CSVjava/rubricaNew.csv", false, 1);
		
		//System.out.println(RubricaController.loadRubricaFromXML("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"));
		//RubricaController.writeRubricaXML(RubricaController.loadRubricaFromXML("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"), "/Users/lorenzoorru0/Desktop/CSVjava/newRubrica.xml");
	}

}
