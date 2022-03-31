package it.beije.xvi.esercizi;

public class EserciziMail {
	// Scrivere un programma che stampi a video i primi dieci numeri interi
	public void intNumbers() {
		System.out.print("Primi 10 numeri interi: ");
		
		for(int i=1; i <= 10; i++) {
			
			if(i < 10) {
				System.out.print(i + ",");
			} else {
				System.out.print(i);
			}
		}
		
	}
	
	//Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.
	public void oddNumbersBetween(int nMax, int nMin) {
		System.out.print("I primi 10 numeri pari tra " +nMax+ " e " +nMin+ " partendo da " +nMax+ " sono : ");
		
		for(int i = 0; i < 10 ; i++) {
			if(nMax % 2 == 1) nMax--;
			
			if(i < 9) {
				System.out.print(nMax + ",");
			} else {
				System.out.print(nMax);
			}
			
			nMax = nMax - 2;
		}
	}
	
	//Scrivere un programma che stampi le tabellina del numero dato come argomento
	public void tabsNumber(int n) {
		System.out.print("La tabellina del " +n+ " e' : ");
		
		for(int i=1; i <= 10; i++) {
			
			if(i < 10) {
				System.out.print(n + "*" +i+ "=" +(i * n)+ " , ");
			} else {
				System.out.print(n + "*" +i+ "=" +(i * n));
			}
		}
	}
	
	/*Stampare a video la seguente figura:
		******
		*****
		****
		***
		**
		*
	*/
	public void printAsterisks() {
		System.out.print("Print asterisks: ");
		System.out.println();
		int numberAsterisks = 6;
		
		while(numberAsterisks >= 1) {
			for(int i=0; i<numberAsterisks; i++) System.out.print("*");
			System.out.println();
			numberAsterisks--;
		}
	}
	
	/*Stampare a video la seguente figura:
		#
		##
		###
		####
		#####
		######
	*/
	public void printHashtag() {
		System.out.print("Print hashtags: ");
		System.out.println();
		int numberHashtags = 1;
		
		while(numberHashtags <= 6) {
			for(int i=1; i<=numberHashtags; i++) System.out.print("#");
			System.out.println();
			numberHashtags++;
		}
	}
	
	/*Stampare a video la seguente figura:
		1      654321
		12      54321
		123      4321
		1234      321
		12345      21
		123456      1
	*/
	public void printFigureNumbers(int sizeFigure) {
		System.out.print("Print figure numbers: ");
		System.out.println();
		int firstRow = 1;
		int secondRow = sizeFigure;
		
		for(int i = 0; i<sizeFigure; i++) {
			for(int j = 1; j <= firstRow; j++) {
				System.out.print(j);
			}
			firstRow++;
			System.out.print("     ");
			for(int x = secondRow; x >= 1; x--) {
				System.out.print(x);
			}
			secondRow--;
			System.out.println();
		}
		
	}
	
	// Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci. 
	public void fibonacciNumbers(int n) {
		System.out.print("I primi N numeri della successione di Fibonacci: ");
		long n1 = 0L;
		long n2 = 1L;
		
		for(int i = 0; i<n; i++) {
			if(i < n-1) {
				System.out.print(n2 + ", ");
				long x = n2;
				n2 += n1;
				n1 = x;
			} else {
				System.out.print(n2);
				long x = n2;
				n2 += n1;
				n1 = x;
			}
		}
	}
	
	/* Scrivere un programma che stampi le n righe della successione di Fibonacci in questo modo:
		1
		1, 1
		1, 1, 2
		1, 1, 2, 3
		1, 1, 2, 3, 5
		1, 1, 2, 3, 5, 8
		1, 1, 2, 3, 5, 8, 13
	*/
	public void fibonacciNumbersFigure(int n) {
		System.out.print("N numeri della successione di Fibonacci: ");
		System.out.println();
		int z = 1;
		
		for(int j = n; j >= 1; j--) {
			long n1 = 0L;
			long n2 = 1L;
			
			for(int i = 0; i<z; i++) {
				if(i < z - 1) {
					System.out.print(n2 + ", ");
					long x = n2;
					n2 += n1;
					n1 = x;
				} else {
					System.out.print(n2);
					long x = n2;
					n2 += n1;
					n1 = x;
				}
			}
			z++;
			n--;
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		EserciziMail esercizi = new EserciziMail();
		
		//Call intNumbers
		esercizi.intNumbers();
		System.out.println();
		
		//Call oddNambursBetween
		esercizi.oddNumbersBetween(41, 0);
		System.out.println();
		
		//Call tabsNumber
		esercizi.tabsNumber(3);
		System.out.println();
		
		//Call printAsterisks
		esercizi.printAsterisks();
		System.out.println();
		
		//Call printHashtags
		esercizi.printHashtag();
		System.out.println();
		
		//Call printFiguresNumbers
		esercizi.printFigureNumbers(9);
		System.out.println();
		
		//Call fibonacciNumbers
		esercizi.fibonacciNumbers(7);
		System.out.println();
		
		//Call fibonacciNumbersFigure
		esercizi.fibonacciNumbersFigure(7);
		System.out.println();
	}

}
