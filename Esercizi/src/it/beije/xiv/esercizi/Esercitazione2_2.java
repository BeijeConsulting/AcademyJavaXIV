package it.beije.xiv.esercizi;

public class Esercitazione2_2 {

	public static void main(String[] args) {
		//Scrivere un programma StampaMaiuscole che, dato un array di stringhe, 
		//ne stampa solo quelle con la prima lettera maiuscola
		
		String[] array = {"ciao", "salve", "arrivederci", "Nicola", "Ennio"};
		StampaMaiuscola(array);
		
	}

	private static void StampaMaiuscola(String[] array) {
		
		for(int i=0; i<array.length ;i++ ) {
		
			if(array[i].charAt(0) == array[i].toUpperCase().charAt(0)) {
				System.out.print(array[i]+ "   ");
			}
					
		}
		
	}
  
}
