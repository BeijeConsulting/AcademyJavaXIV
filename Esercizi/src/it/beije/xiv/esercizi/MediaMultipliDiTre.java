package it.beije.xiv.esercizi;

public class MediaMultipliDiTre {
	public static void main(String[]args) {
		int[]array = {1,2,3,4,5,6,7,9,12,15};
		float somma = 0;
		int count = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]%3==0) {
				somma+=array[i];
				count++;
			}
		}
		System.out.println("media= "+((float)(somma/count)));
		
	}
}
