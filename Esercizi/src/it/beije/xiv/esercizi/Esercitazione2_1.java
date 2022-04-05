package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione2_1 {

	public static void main(String[] args) {
		// Scrivere un programma SoloVocali che, 
		//data una stringa, ne stampa le sole vocali
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Inserisci parola:");
		String parola = in.nextLine();
		if(parola.equals("")) { 
			System.out.println("non valido");
		}	
		
		
		soloVocali(parola);

	}
	
	private static void soloVocali(String parola) {
	
		for(int i=0; i<parola.length();i++ ) {
			
			if(parola.charAt(i) == 'a' || parola.charAt(i) == 'e'|| parola.charAt(i) == 'i'|| parola.charAt(i) == 'o'|| parola.charAt(i) == 'u') {
				
				System.out.print(parola.charAt(i)+ "  ");
			}
		}
		
		
	}


}
