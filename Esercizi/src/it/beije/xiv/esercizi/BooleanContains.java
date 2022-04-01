package it.beije.xiv.esercizi;

public class BooleanContains {
	public static boolean contains(int e, int[]array) {
		int count = 0;
		for(int i=0;i<array.length;i++) {
			if(e == array[i]) count++;
		}
		if(count<1) return false;
		else return true;
	}
	public static void main(String[]args) {
		int[]array = {1,2,3,4,5,6,7,8,9};
		int e = 1;
		boolean verify = contains(e,array);
		System.out.println(verify);
	}
}
