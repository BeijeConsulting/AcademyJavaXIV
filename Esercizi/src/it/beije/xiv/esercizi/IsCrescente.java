package it.beije.xiv.esercizi;

public class IsCrescente {
	public static boolean isCrescente(int[]array) {
		boolean b = true;
		for(int i=0; i<array.length-1;i++) {
			if(array[i] > array[i+1]) {
				b = false;
				break;
			}
		}
		return b;
	}
	public static void main(String[]args) {
		int[]array = {1,2,4,3,4,5};
		boolean isSorted = isCrescente(array);
		if(isSorted == true) System.out.println("ordine crescente");
		else System.out.println("non sono in ordine crescente");
	}
}
