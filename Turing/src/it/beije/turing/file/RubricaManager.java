package it.beije.turing.file;

import java.util.ArrayList;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;

//import it.beije.turing.file.*;

public class RubricaManager {
	public static String path = "C:\\Users\\Marco\\Desktop\\tmp\\rubrica.csv";
	public static ArrayList<Contatto> contatti = RubricaCSV.leggiRubrica(path);
	public static void main(String[] args) {
		mainMenu();
		try {
			RubricaXML.writeXML(contatti, path);
		}catch(Exception e) {e.printStackTrace();}
		
		
		
		
		
		
	}
	
	public static String prendiInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
		
	}
	
	public static void mainMenu() {
		int input;
		do {
			do {
				System.out.println("Inserisci un numero da 1");
				input = Integer.parseInt(prendiInput());
			}while(input < -1 || input > 5);
			
		}while(input != -1);
	}
	
	public static void smistaScelte(int input) {
		switch(input) {
		case 1:
			mostraContatti();
			
		}
	}
	public static void mostraContatti() {
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
	}
	
}
