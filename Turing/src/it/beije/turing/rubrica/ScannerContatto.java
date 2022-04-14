package it.beije.turing.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import it.beije.turing.rubrica.Contatto;

public class ScannerContatto {
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\aless_in4zoow\\eclipse-workspace\\ESERCIZI_PROVA\\src\\ciao.txt");
		System.out.println("file exists? " + file.exists());
		
		System.out.println("avvio scanner...");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Inserire nome...");
		String st = s.next();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			
			
			fileWriter.write(st);
		
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
		
			System.out.println("done");
			

		}
		System.out.println("BYE!!");
		s.close();
		
		
	}
		
}
