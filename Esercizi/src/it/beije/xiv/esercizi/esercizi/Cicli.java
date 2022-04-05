package esercizi;

import java.util.Scanner;
public class Cicli {

	public static void main(String[] args) {
		/*
		//* Scrivere un programma che stampi a video i primi dieci numeri interi
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		//crivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, 
		//partendo da 20.
		for (int i = 20; i > 0; i--) {
			if (i % 2 == 0) {
				System.out.println(i);
				
			}
		}
		
		//Scrivere un programma che stampi le tabellina del numero dato come argomento
		System.out.println("inserisci un numero");
		Scanner tst = new Scanner(System.in);
		int i = tst.nextInt();
		tabellina(i);+/
		
		/*esercizio *stampare a video la figura 1
		for (int i = 6; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		//stampare figura 2
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print('+');
				
			}
			System.out.println();
		}*/
		
		//stampa figura 3 
		
		//fibonacci
		int cur = 0;
		int next = 1;
		
		for(int i = 0; cur < 100; i++)
		{	
			System.out.println(cur);
			int temp = cur;
			cur = next;
			next += temp;
			
			        }
	
		}

	private static void tabellina(int i) {
		for (int j = 0; j < 11; j++) {
			System.out.println(j*i);
			
		}
		
	}

}
