package it.beije.xiv.esercizi;

import java.util.Arrays;

public class Esercitazione3_9 {

	public static void main(String[] args) {
		// Scrivere il metodo: “public String [] addString(String s, String[] a)”,
		//che accetta come parametri una stringa ed un array di stringhe. 
		//Restituisce un nuovo array, identico ad array, aggiungendo però, come ultimo elemento, la stringa s.
		
		
		String[] arr = new String[] {"ciao", "lino ", "salve" , "mondo"};
		String[] nuovo = new String[arr.length+1];
		nuovo= addString("Weee", arr);
		
		System.out.print(Arrays.toString(nuovo));
		
	}

	
	public static String[] addString(String s, String[] a) {
		
		String[] newArray = new String[(a.length + 1)];
		
		for(int i = 0; i < a.length; i++) {
			newArray[i] = a[i];
		}
		
		newArray[a.length] = s;
		
		return newArray;
		
	}
}
