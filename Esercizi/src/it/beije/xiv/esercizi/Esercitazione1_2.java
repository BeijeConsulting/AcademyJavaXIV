package it.beije.xiv.esercizi;

public class Esercitazione1_2 {

	public static void main(String[] args) {
		// Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.
		int partenza = 20; 
		
		for(int i=0; i < 10; i++) {
			 System.out.print(partenza+ "   ");
			 partenza = partenza -2;
		}

	}

}
