package it.beije.xvi.esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class EserciziMail2 {
	//Scrivere un programma SoloVocali che, data una stringa, ne stampa le sole vocali
	public void findVowels(String str) {
		System.out.print("La stringa " +str+ " con solo le vocali: ");
		
		char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
		Arrays.sort(vowels);
		
		for(int i = 0; i < str.length(); i++) {
			
			if(Arrays.binarySearch(vowels, str.charAt(i)) >= 0) {
				System.out.print(str.charAt(i) + " ");
			}
		}
	}
	
	//Scrivere un programma StampaMaiuscole che, dato un array di stringhe, ne stampa solo quelle con la prima lettera maiuscola
	public void printUppercase(String[] words) {
		System.out.print("Le parole che iniziano con una maiuscola sono: ");
		
		for(int i = 0; i < words.length; i++) {

			int x = (int) words[i].charAt(0);

			if(65 >= x || x <= 90) {
				if(i < words.length - 1) {
					System.out.print(words[i] + "-");
				} else {
					System.out.print(words[i]);
				}	
			} 
		}
	}
	
	/*	Scrivere il metodo
		1 public int contaLettera(char c, String str)
		che conta le occorrenze della lettera c nella stringa str
	*/
	public int countLetter(char c, String str) {
		int x = 0;
		
		for(int i = 0; i < str.length(); i++) {	
			if(str.charAt(i) == c) {
				x++;
			}
		}
		
		return x;
	}
	
	//Scrivere un programma Contrario che, data una stringa, la stampa al contrario. Per esempio, la stringa “Viva Java!” verrà “!avaJ aviV”
	public void printReverse(String str) {
		StringBuilder supportStr = new StringBuilder();
		int j = 0;
		
		for(int i = str.length() - 1; i >= 0; i--) {
			  supportStr.append(str.charAt(i));
		}
		
		System.out.print("La stringa " +str+ " al contrario viene stampata: " +supportStr.toString());
	}
	
	//Scrivere un programma Concatena che chiede all’utente di inserire tre singole parole e le ristampa interponendovi un asterisco. Per esempio, se l’utente inserisce “gatto”, “cane” e “topo” il programma stamperà “gatto*cane*topo”.
	public void concatenate() {
		System.out.print("Inserisci tre parole: \n");
		Scanner kb = new Scanner(System.in);
		StringBuilder conc = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			conc.append(kb.next()).append('*');
		}
        //String s = reader.readLine();
		System.out.print("Le parole copncatenate sono: " +conc.toString());
	}
	
	//Scrivere un metodo che, data una stringa in input, assuma questa come un nome di variabile e stampi per questa variabile il suo metodo “setter”
	
	
	//Scrivere un metodo che, data una stringa in input, assuma questa come un nome di variabile e stampi per questa variabile il suo metodo “getter”

	public static void main(String[] args) {
		EserciziMail2 esercizi = new EserciziMail2();
		
		//Call findVowels
		esercizi.findVowels("vocaboli");
		System.out.println();
		
		//Call printUppercase
		String[] string = {"Persona", "persona", "Caffe"};
		esercizi.printUppercase(string);
		System.out.println();
		
		//Call countLetter
		System.out.println("La lettera a e' prente " +esercizi.countLetter('a', "alfabeto")+ " volte dentro alfabeto");
		
		//Call printReverse
		esercizi.printReverse("Viva Java!");
		System.out.println();
		
		//Call concatenate
		esercizi.concatenate();
		System.out.println();
	}
}
