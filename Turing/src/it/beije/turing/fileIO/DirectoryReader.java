package it.beije.turing.fileIO;

import java.io.File;
import java.util.Scanner;

public class DirectoryReader {

	public static void main(String[] args) {

		/*File file = new File("C:\\Users\\luigi\\OneDrive\\Documenti\\GitHub\\AcademyJavaXIV\\Turing\\src\\it\\beije\\turing\\fileIO\\dati.txt");
			System.out.println("file exists? " + file.exists());
			System.out.println("file is file? " + file.isFile());
			System.out.println("file is dir? " + file.isDirectory());
			*/
		
				Scanner in = new Scanner(System.in);
				
				System.out.println("Inserisci la directory del file: ");
				String nome = in.nextLine();
				if(nome.equals("")) { 
				System.out.println("nome non valido");
				}
				
				File file = new File(nome);
				System.out.println("E' un file esistente ? :" + file.exists());
				System.out.println("E' un file ? :" + file.isFile());
				System.out.println("E' una directory? : " + file.isDirectory());
				
				findAllFilesInFolder(file);
				
				
				
				
	}
	
				public static void findAllFilesInFolder(File folder) {
					int i = 0;
					for (File file : folder.listFiles()) {
						
						if (!file.isDirectory()) {
							
							System.out.println("dir " + i++);
							System.out.println(file.getName());
						} else {
							
							findAllFilesInFolder(file);
						}
					}
	}
}
