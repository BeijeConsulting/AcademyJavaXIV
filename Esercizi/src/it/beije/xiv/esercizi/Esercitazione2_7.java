package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione2_7 {

	public static void main(String[] args) {
		//Scrivere un metodo che, data una stringa in input,
		//assuma questa come un nome di variabile e stampi 
		//per questa variabile il suo metodo “getter”
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci parola:");
		String parola = in.nextLine();
		if(parola.equals("")) { 
			System.out.println("non valida");
}	
		
		dGetter(parola);
		
	}

	public static void dGetter(String parola) {
		
		System.out.println("public void get"+parola+"(){");
		System.out.println("	return " + parola+ "; \n }");
		
	}
}
