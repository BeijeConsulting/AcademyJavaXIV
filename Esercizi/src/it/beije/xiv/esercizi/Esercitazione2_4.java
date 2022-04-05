package it.beije.xiv.esercizi;

public class Esercitazione2_4 {

	public static void main(String[] args) {
		// Scrivere un programma Contrario che, 
		//data una stringa, la stampa al contrario.
		//Per esempio, la stringa “Viva Java!” verrà “!avaJ aviV”
		String s = "Viva Java!";
		stringaContrario(s);
		
	}

	private static void stringaContrario(String s) {
	
		for(int i = (s.length()-1); i>=0; i--) {
			
			System.out.print(s.charAt(i));
		}
	}
	
}
