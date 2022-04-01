package it.beije.xiv.esercizi;

public class MediaInteri {
	public static void main(String[]args) {
		int[]array = {1,2,3,4,5,6,7,8};
		float somma=0;
		for(int i=0;i<array.length;i++) {
			somma+= array[i];
		}
		System.out.println((float)(somma/array.length));
	}
}
