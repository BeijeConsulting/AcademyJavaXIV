package it.beije.turing.rubrica;

import java.util.Scanner;


public class ScannerExample {
	
	public static void main(String[] args) {
		System.out.println("Inserire il percorso della rubrica da leggere: ");
		Scanner s = new Scanner(System.in);
		String st = s.next();
		CSVRubricaReader.readCSV(st);
		CSVRubricaWriter.writeCsv("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Turing\\src\\it\\beije\\turing\\rubrica\\Prova2");
		s.close();
	}
}
