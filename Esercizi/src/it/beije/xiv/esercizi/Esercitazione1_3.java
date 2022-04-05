package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione1_3 {

	public static void main(String[] args) {
		// Scrivere un programma che stampi le tabellina del numero dato come argomento
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("Inserisci numero :");
		String numero = in.nextLine();
		if(numero.equals("")) { 
			System.out.println("numero non valido");
		}	
		int n = Integer.parseInt(numero);

		for(int i=0; i<=10; i++) {
			
			System.out.println(" "+ numero + " x " + i + " = "+ (i*n));
			
		}
	}

}
