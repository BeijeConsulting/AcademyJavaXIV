package it.beije.xiv.eserciziCOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Sommariga {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		/* Dato il seguente triangolo di numeri dispari:                   
		1
		3       5
		7       9     11
		13     15     17       19
		21     23     25       27     29
		….
		si scriva la funzione rowSumOddNumbers(int n) che calcola la somma dei numeri nella riga n-esima. Per esempio:
		rowSumOddNumbers(1) = 1
		rowSumOddNumbers(3) = 7 + 9 + 11 = 27
		ecc.
		*/
		
		
		System.out.print(rowSumOddNumbers(251));
		
	}
		
	public static int partenza(int num ) {
		int partenza = 1; 
		for(int i = 0; i<num ; i++) {
			partenza += 2*i;
		}
		return partenza;
	}
	
	public static int rowSumOddNumbers(int num) {
		
		int inizio = partenza(num);
		int somma = partenza(num);
		for(int i = 1; i<num ; i++) {
			
			inizio += 2;
			somma += inizio; 
			
		}
		return somma;
	}
	
}
