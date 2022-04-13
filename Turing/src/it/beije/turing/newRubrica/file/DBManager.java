package it.beije.turing.newRubrica.file;

import java.util.List;
import java.util.Scanner;

import it.beije.turing.newRubrica.rubrica.Contatto;

public class DBManager {
	
	private RubricaManager rm;
	
	public DBManager() {
		
	}
	
	public DBManager(RubricaManager rm) {
		this.rm = rm;
	}

	public List<Contatto> leggiDaDB(Scanner s) {
		System.out.println("Inserire db: ");
		String dbName = s.nextLine();
		System.out.println("Inserire username: ");
		String username = s.nextLine();
		System.out.println("Inserire password: ");
		String password = s.nextLine();
		return rm.loadRubricaFromJDBC(dbName, username, password);
		
	}

	public void scriviSuDB(List<Contatto> allContact, Scanner s) {
		// TODO Auto-generated method stub
		System.out.println("Inserire db: ");
		String dbName = s.nextLine();
		System.out.println("Inserire username: ");
		String username = s.nextLine();
		System.out.println("Inserire password: ");
		String password = s.nextLine();
		rm.writeRubricaOnJDBC(allContact, username, password, dbName);
	}
	
	
}
