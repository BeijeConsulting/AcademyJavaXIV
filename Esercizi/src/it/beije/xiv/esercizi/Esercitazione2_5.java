package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione2_5 {

	public static void main(String[] args) {
		// Scrivere un programma Concatena che chiede all’utente
		//di inserire tre singole parole e le ristampa interponendovi un asterisco.
		//Per esempio, se l’utente inserisce “gatto”, “cane” e “topo” il programma stamperà “gatto*cane*topo”.
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		StringBuilder s = new StringBuilder(); 
		char c = '"';
		s.append(c);
		for(int i=0; i<3; i++ ) {
		
		System.out.println("Inserisci parola:");
		String parola = in.nextLine();
		if(parola.equals("")) { 
			System.out.println("Non valida");
		}
		
		s.append(parola);
		if(i<2) s.append("*");
		if(i == 2) s.append(c);
		}
		
		System.out.println(s);

	}

}
