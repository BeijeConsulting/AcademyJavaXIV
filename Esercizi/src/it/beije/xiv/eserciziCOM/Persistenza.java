package it.beije.xiv.eserciziCOM;

import java.util.Scanner;

public class Persistenza {

	public static void main(String[] args) {
		// Scrivere la funzione “persistenza”, che prende un parametro intero positivo e ritorna la sua 
		//“persistenza moltiplicativa”, che è il numero di volte per cui 
		//bisogna moltiplicare le cifre fra loro fino ad avere un unico carattere.
		//Per esempio:persistence(39) == 3 // perché 3*9 = 27, 2*7 = 14, 1*4=4
		// e 4 è diuna cifra solapersistence(999) == 4 // perché 9*9*9 = 729, 7*2*9 = 126,
		// 1*2*6 = 12, e 1*2 = 2
		//persistence(4) == 0 // perché 4 è già una cifra singola

			Scanner in = new Scanner(System.in);
		
			System.out.println("Inserisci Numero:");
			String numero = in.nextLine();
			if(numero.equals("")) { 
			System.out.println("Non valido");
			}
			
			int intero = Integer.parseInt(numero);
			int dim = numero.length();
			int count=0;
		
			while(dim > 1) {
				
				System.out.print(persistenza(intero)+ " ");
				intero = persistenza(intero);
				dim = Integer.toString(intero).length();
				count++;
			}
			
			System.out.println("Le interazioni sono "+count);
		
	}
	
	
	public static int persistenza(int intero) {
		
		int dim = (Integer.toString(intero)).length();
		int mol = 1;
		
		for (int i=0; i< dim; i++ ) {      
			
			int numero = intero % 10;
			mol *= numero;
			intero /= 10;
			
		}
		return mol;
	}

}
