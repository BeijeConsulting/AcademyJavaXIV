package it.beije.xiv.esercizi;

public class MaxArray {
	public static void main(String[]args) {
		int[]array = {0,209,-8,5,3,90,4,34};
		int max=0;
		int min = array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				max = array[i];
			}
			if(array[i]<min) {
				min = array[i];
			}
		}
		System.out.println("massimo: "+max);
		System.out.println("minimo: "+min);
	}
}
