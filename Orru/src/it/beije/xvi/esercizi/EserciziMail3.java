package it.beije.xvi.esercizi;

import java.util.ArrayList;
import java.util.Arrays;

public class EserciziMail3 {

	//Trovare il massimo elemento in un array (o il minimo)
	public int findMax(int[] array) {
		
		int j = array.length - 1;
		int max = 0;
		for(int i= 0; i<array.length; i++) {
			if(i < j) {
				if(array[i] >= array[j]) {
					if(array[i] > max) max = array[i];
				} else {
					if(array[j] > max) max = array[j];
				}
			} else if (i == j) {
				if(array[i] > max) max = array[i];
			} else {
				break;
			}
			j--;
		}
		return max;
	}
	
	public int findMin(int[] array) {
		
		int j = array.length - 1;
		int min = array[0];
		for(int i= 0; i<array.length; i++) {
			if(i < j) {
				if(array[i] >= array[j]) {
					if(array[j] < min) min = array[j];
				} else {
					if(array[i] < min) min = array[i];
				}
			} else if (i == j) {
				if(array[i] < min) min = array[i];
			} else {
				break;
			}
			j--;
		}
		return min;
	}
	
	//Trovare l’indice del massimo elemento in un array (o il minimo)
	public int indexMax(int[] array) {
		EserciziMail3 esercizi = new EserciziMail3();
		int max = esercizi.findMax(array);
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(max == array[i]) index = i;
		}
		return index;
	}
	
	public int indexMin(int[] array) {
		EserciziMail3 esercizi = new EserciziMail3();
		int min = esercizi.findMin(array);
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(min == array[i]) index = i;
		}
		return index;
	}
	
	//scrivere un metodo “boolean contains(int e, int[] array)” che restituisca true se l’elemento e è presente nell’array, false altrimenti. Ripetere l’esercizio con “boolean contains(Object e, Object[] array)”, quali differenze ci sono?
	public boolean contains(int e, int[] array) {
		boolean c = false;
		
		for(int x : array) {
			if(e == x) c = true;
		}
		return c;
	}
	
	public boolean contains(Object e, Object[] array) {
		boolean c = false;
		
		for(Object x : array) {
			if(e == x) c = true;
		}
		return c;
	}
	
	
	//Verificare la sequenza crescente di un array. Il metodo “boolean isCrescente(int [] array)” restituisce true se tutti gli elementi dell’array passato sono in ordine crescente, false altrimenti.
	public boolean isGrowing(int[] array) {
		boolean c = false;
		
		for(int i = 1; i < array.length; i++) {
			if(array[i-1] <= array[i]) {
				c = true;
			} else {
				c = false;
			}
		}
		return c;
	}
	
	//Scrivere il metodo: “public int mostRecurrent(int [] array)” , che trova l’elemento più ricorrente in un array. Il metodo restituisce l’elemento trovato.
	public int mostRecurrent(int [] array) {
		int m = array[0];
		int count = 0;
		
		for(int i = 0; i<array.length; i++) {
			int countS = 0;
			for(int j = 0; j<array.length; j++) {
				if(j != i) {
					if(array[i] == array[j]) countS++;
				}
			}
			if(countS >= count) m = array[i];
		}
		return m;
	}
	
	//Scrivere un programma MediaMultipliDiTre che calcoli la media di un array di numeri interi, considerando i soli numeri divisibili per tre.
	public double averageMultiplesThree(int[] array) {
		double average = 0;
		int sum = 0;
		int n = 0;
		
		for(int x : array) {
			if(x % 3 == 0) {
				sum += x;
				n++;
			}
		}
		if (n > 0) average = sum / n;
		return average;
	}
	
	//Scrivere un programma StampaZigZag che, dato un array di 10 numeri interi contenente valori a piacere, ne stampa gli elementi secondo il seguente ordine: il primo, l’ultimo, il secondo, il penultimo, il terzo, il terz’ultimo, ecc…
	public void printZigZag(int[] array) {
		int j = array.length - 1;
		
		for(int i= 0; i < array.length; i++) {
			if (i < j) {				
				System.out.print(array[i] +" "+ array[j] +" ");
			} else if (i == j){
				System.out.print(array[i]);
			}
			j--;
		}
	}
	
	//Scrivere un programma Media che calcoli la media di un array di numeri interi
	public double average(int[] array) {
		int sum = 0;
		for(int x : array) sum += x;
		return sum / array.length;
	}
	
	//Scrivere il metodo: “public String [] addString(String s, String[] a)”, che accetta come parametri una stringa ed un array di stringhe. Restituisce un nuovo array, identico ad array, aggiungendo però, come ultimo elemento, la stringa s.
	public String[] addString(String s, String[] a) {
		ArrayList<String> newStr = new ArrayList<>();
		for(String str : a) {
			newStr.add(str);
		}
		newStr.add(s);
		return newStr.toArray(new String[newStr.size()]);
	}
	
	public static void main(String[] args) {
		EserciziMail3 esercizi = new EserciziMail3();
		
		//Call findMax and findMin
		int[] a = {22, 2, 46, 35, 34, 49, 1, 23};
		System.out.println("L'elemento maggiore e' :" +esercizi.findMax(a));
		System.out.println("L'elemento minore e' :" +esercizi.findMin(a));
		
		//Call indexMax and indexMin
		System.out.println("L'indice dell'elemento maggiore e' :" +esercizi.indexMax(a));
		System.out.println("L'indice dell'elemento minore e' :" +esercizi.indexMin(a));
		
		//Call contains
		System.out.println("Il numero 3 e' presente nell' array? " +esercizi.contains(3, a));
		System.out.println("Il numero 3 e' presente nell' array? " +esercizi.contains(3, a));
		
		//Call isGrowing
		System.out.println("L' array e' crescente? " +esercizi.isGrowing(a));
		
		//Call mostCurrent
		System.out.println("Il numero con piu' ricorrenza e': " +esercizi.mostRecurrent(a));
		
		//Call averageMultiplesThree
		System.out.println("La media dei numeri divisibili per tre e': " +esercizi.averageMultiplesThree(a));
		
		//Call printZigZag
		System.out.println("L'array stampato a zig zag viene vizualizzato cosi: ");
		esercizi.printZigZag(a);
		System.out.println();
		
		//Call average
		System.out.println("La media dell' array e': " +esercizi.average(a));
		
		//Call addString
		String[] s = {"ciao", "beije"};
		System.out.println("Array con l'aggiunta della stringa: ");
		for(String str : esercizi.addString("help", s)) System.out.print(str + " ");
	}
}
