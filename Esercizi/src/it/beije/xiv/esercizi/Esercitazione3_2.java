package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercitazione3_2 {
	
		public static void main(String[] args) {
			//Trovare l’indice del massimo elemento in un array (o il minimo)
		
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			
			
			System.out.println("Inserisci numero di elementi deve contenere l'array :");
			String numero = in.nextLine();
			if(numero.equals("")) { 
				System.out.println("numero non valido");
			}	
			int n = Integer.parseInt(numero);
			
			
			int massimo = 0, indiceMassimo = 0; 
			int minimo = 1000000000 , indiceMinimo = 0; 
			int[] mioArray = new int[n]; 
			
			for(int i=0; i< n;i++) {
				
			
				System.out.println("Inserisci il "+ (i+1) + "° numero dell'array ");
				String corrente = in.nextLine();
				int corr = Integer.parseInt(corrente);
				mioArray[i] = corr;
				
				if(corr>massimo) {
					massimo = corr;
					indiceMassimo = (i+1); 
				}
				if(corr<minimo) {
					minimo = corr; 
					indiceMinimo = (i+1); 
				}else {}
				
			}
			
			System.out.println("Il massimo è " + massimo + " con indice "+ indiceMassimo);
			System.out.println("Il minimo è " + minimo + " con indice "+ indiceMinimo);

		}

		}




