package it.beije.xiv.esercizi;

public class StampaZigZag {
public static void stampaZigZag(int[]array) {
		
		for(int i=0;i<array.length/2;i++) {
			System.out.println(array[i]);
			System.out.println(array[array.length-1-i]);
		}
	}
	public static void main(String[]args) {
		int[]array = {1,2,3,4,5,6,7,8,9,10};
		stampaZigZag(array);
	}
}
