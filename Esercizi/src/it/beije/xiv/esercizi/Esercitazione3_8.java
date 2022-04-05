package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione3_8 {
	public static void main(String[] args) {
		//Scrivere un programma Media che calcoli la media di un array di numeri interi
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("Inserisci numero di elementi deve contenere l'array : ");
		String numero = in.nextLine();
		if(numero.equals("")) { 
			System.out.println("Numero non valido");
		}	
		int n = Integer.parseInt(numero);
		
		
		int sum = 0; 
		int[] mioArray = new int[n]; 
		
		for(int i=0; i< n;i++) {
			
			System.out.print("Inserisci il "+ (i) + "° numero dell'array : ");
			String corrente = in.nextLine();
			int corr = Integer.parseInt(corrente);
			mioArray[i] = corr;
			sum = (sum + corr); 
			
		}
		
	
		
		System.out.println("la media dei valori dell'arrey è : " + (float) sum/n );
	}

}
