package it.beije.xiv.esercizi;

public class Esercitazione3_7 {

	public static void main(String[] args) {
		
		//Scrivere un programma StampaZigZag che, dato un array di 10 numeri interi contenente valori a piacere,
		//ne stampa gli elementi secondo il seguente ordine: 
		//il primo, l’ultimo, il secondo, il penultimo, il terzo, il terz’ultimo, ecc…
		
		int[] ciao = {1,3,2,4,5,5,4,3,4,1};
		
		StampaZigZag(ciao);
		
		
	}

	private static void StampaZigZag(int[] array) {	
		
		int lunghezza = (array.length);
		
		for (int i = 0, j=lunghezza-1 ; i < lunghezza/2; i++, j--) {
			
            System.out.println(array[i]);
            System.out.println(array[j]);
    
        }
	}

}
