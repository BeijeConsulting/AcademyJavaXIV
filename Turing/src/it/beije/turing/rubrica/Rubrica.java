package it.beije.turing.rubrica;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.file.CSVreader;

public class Rubrica {
	private List<Contatto> allContact;
	private Path path;
	public Rubrica(Path path) {
		this.path = path;
		allContact = CSVreader.readStaticCSV(path.toAbsolutePath().toString());
	}
	
	
	public Contatto creaContatto(Scanner s) {
		

		
		return null;
	}
	public void showRubrica() {
		for(Contatto c : allContact) {
			System.out.println(c);
		}
	}
	public void showContatto(String search, String type) {
		switch(type.toUpperCase()) {
			case "C":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getCognome().equals(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "N":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getNome().equals(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "T":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getTelefono().equals(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "E":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getEmail().equals(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			default:
				System.out.println("Illegal search type!");
		}
	}
	public static void main(String[] args) {
		Rubrica r = new Rubrica(Paths.get("File","rubrica.csv"));
		System.out.println("Selezionare programma da eseguire:\n"
		+ "1: Mostra tutta la rubrica\n"
		+ "2: Cerca un contatto\n"
		+ "3: Aggiungi un contatto\n"
		+ "4: Esci");
		
		Scanner s = new Scanner(System.in);
		String st = s.next();
		while (!st.equalsIgnoreCase("esci") && !st.equals("4")) {
			st = s.next();
			switch(st) {
				case "1":
					r.showRubrica();
					break;
				case "2":
					System.out.println("Inserire tipo ricerca ((N)ome,(C)ognome,(T)elefono,(E)mail):");
					String type = s.next();
					System.out.println("Inserire dato da ricercare:");
					String data = s.next();
					r.showContatto(data, type);
					break;
				case "3":
					r.creaContatto(s);
					break;
				case "4":
					continue;
				default:
					break;
			}
			
		}
		
		System.out.println("BYE!!");
		s.close();
	}
}
