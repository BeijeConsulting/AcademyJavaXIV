package it.beije.xiv.esercizi;

public class Esercitazione3_6 {

	public static void main(String[] args) {
		
		//Scrivere un programma MediaMultipliDiTre che calcoli la media di un array di numeri interi,
		//considerando i soli numeri divisibili per tre.
		
		int[] array = {3,1,5,2,8,45,57,9,1};
		
		System.out.println("La media dei numeri multipli di tre è :" + MediaMultipliDiTre(array));


	}
	
	private static int MediaMultipliDiTre(int[] array) {
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 3 == 0 && array[i] != 0) {
				count++;
				sum = sum + array[i];
				//System.out.println(count + " , " + sum);
			}
		}
		return sum / count;
	}
}
