package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione2_6 {

	public static void main(String[] args) {
	//Scrivere un metodo che, data una stringa in input, 
	//assuma questa come un nome di variabile e stampi per questa variabile il suo metodo “setter”

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Inserisci parola:");
		String parola = in.nextLine();
		if(parola.equals("")) { 
			System.out.println("non valido");
		}	
		
		printSetter(parola);
		
	}

	public static void printSetter(String parola) {
		
		System.out.println("public void set"+parola+"(String s){");
		System.out.println("	this.parola = s; \n }");
		
	}
}
