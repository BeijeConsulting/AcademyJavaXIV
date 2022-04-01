package it.beije.xiv.esercizi;

public class indiceMax {
	public static void main(String[]args) {
		int[]array = {0,5,3,90,209,4,-8,34};
		int max=0;
		int min = array[0];
		int indiceMax=0;
		int indiceMin=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				max = array[i];
				indiceMax = i;
			}
			if(array[i]<min) {
				min = array[i];
				indiceMin = i;
			}
		}
		System.out.println("massimo: "+max+" con indice: "+indiceMax);
		System.out.println("minimo: "+min+" con indice: "+indiceMin);
}
}
