package esercizi;
import java.util.Random;
import java.util.* ;
import java.util.Arrays;

public class Array {
	
	public static boolean contains(int e, int[] array) {
		boolean cont = false;
		for(int i = 0; i < array.length;i++) {
			if(array[i] == e) 
				cont = true;
		}
		
		return cont;
		
	}
	
	public static boolean isCrescente(int [] array) {
		boolean cres = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				cres = false;
			}
		}
		return cres;
	}
	
	/*public static int mostRecurrent(int [] array) {
		
		
	}*/
	
	public static double mediaMultipliDiTre(int[] array) {
		double media = 0;
		double somma = 0, count = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 3 == 0) {
				somma += array[i];
				count++;
			}
		}
		media = somma / count;;
		if(count == 0 ) return 0;
		return media;
	}
	
	public static void stampaZigZag(int[] array) {
		int j = array.length - 1, cont = 0; 
		for(int i = 0 ;i < array.length; i++) {
			if(i < j) {
				System.out.print(array[i]);	
				System.out.print(array[j]);
				j--;
			}
			else {
				break;
			}
		}
	}
	
	public static double media(int[] array) {
		double sum = 0, media = 0;
		if(array.length != 0 ) {
			for(int i = 0; i < array.length; i++) {
				sum += array[i];
			}
		}
		media = sum / array.length;
		return  media;
		
	}
	
	/*public String [] addString(String s, String[] a) {
		
	}*/

	public static void main(String[] args) {
		
		int[] array = new int[5];
	
		
		Random r = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10);
		}
		
		int[] arraySorted = new int[5];
		for(int i = 0; i < array.length; i++) {
			arraySorted[i] = array[i];
		}
		Arrays.sort(arraySorted);
		System.out.println("normale");
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("\nsorted");
		for(int i : arraySorted) {
			System.out.print(i + " ");
		}
		
		/*	* Trovare il massimo elemento in un array (o il minimo)
		 	* Trovare l’indice del massimo elemento in un array (o il minimo)*/
		int max = -1, min = 11, indiceMax = 0, indiceMin = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				indiceMax = i;
			}
			if(array[i] < min ) {
				min = array[i];
				indiceMin = i;
			}
		}
		System.out.println("\n" + "max = " + max + " min = " + min);
		System.out.println("indeice max = " + indiceMax + " indice min = " + indiceMin);
		
		/* scrivere un metodo “boolean contains(int e, int[] array)” che restituisca true 
		   se l’elemento e è presente nell’array, false altrimenti. Ripetere l’esercizio con 
		  “boolean contains(Object e, Object[] array)”, quali differenze ci sono?
		*/
		System.out.println("contains 8: "+ contains(8, array));
		
		/** Verificare la sequenza crescente di un array. 
		  Il metodo “boolean isCrescente(int [] array)” restituisce true se tutti gli elementi 
		  dell’array passato sono in ordine crescente, false altrimenti.*/
		System.out.println("non sorted " + isCrescente(array));
		System.out.println("non sorted " + isCrescente(arraySorted));
		
		/** Scrivere il metodo: “public int mostRecurrent(int [] array)” , che trova l’elemento 
		 	più ricorrente in un array. Il metodo restituisce l’elemento trovato.*/
		
		System.out.println("elemento più ricorrente =  TODO" );
		
		/* Scrivere un programma MediaMultipliDiTre che calcoli la media di un array di numeri interi,
		 *  considerando i soli numeri divisibili per tre.*/
		
		System.out.println("media elem. divisibili 3 = " + mediaMultipliDiTre(array));
		
		/** Scrivere un programma StampaZigZag che, dato un array di 10 numeri interi contenente 
			alori a piacere, ne stampa gli elementi secondo il seguente ordine: il primo, l’ultimo, 
			il secondo, il penultimo, il terzo, il terz’ultimo, ecc… */
		
		System.out.println("stampa zig zag = ");
		stampaZigZag(arraySorted); //controllare condizioni di uscita
		
		/** Scrivere un programma Media che calcoli la media di un array di numeri interi*/
		System.out.println("\nmedia = " + media(array));
		
		/** Scrivere il metodo: “public String [] addString(String s, String[] a)”, 
		 * che accetta come parametri una stringa ed un array di stringhe. Restituisce un nuovo array,
		 *  identico ad array, aggiungendo però, come ultimo elemento, la stringa s.*/
		
		
		
	
		
		
			
	}


}
