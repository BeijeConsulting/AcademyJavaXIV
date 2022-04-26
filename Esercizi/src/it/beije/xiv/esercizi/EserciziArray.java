package it.beije.xiv.esercizi;

import java.util.Arrays;

public class EserciziArray {
	
	public static void main(String args[]) {
		maxValueArray(new int[] {542, -235, 150});
		minValueIndexArray(new int[] {542, -235, 150});
		System.out.println(contains(150, new int[] {542, -235, 150}));
		StringBuilder sb = new StringBuilder("No");
		StringBuilder sb1 = new StringBuilder("No");
		System.out.println(contains(sb, new Object[] {sb1}));
		System.out.println(isCrescente(new int[] {-235, 150, 542}));
		System.out.println(mostRecurrent(new int[] {-235, -235, -235, 150, 150, 150, 150, 542}));
		mediaMultipliDiTre(new int[] {-135, -135, -235, 150, 150, 150, 150, 543});
		stampaZigZag(new int[] {-135, -135, -235, 150, 150, 75, 75, 543, 543, 543});
		media(new int[] {-135, -135, -235, 150, 150, 150, 150, 543});
		String[] b = addString("Aggiunta", new String[] {"1", "2", "3", "4"});
		System.out.println(b[4]);
	}
	
	public static void maxValueArray(int[] ar) {
		if(ar.length != 0) {
			int i = ar[0];
			
			for(int value : ar) {
				if(i < value) {
					i = value;
				}
			}
			
			System.out.println("Il massimo elemento dell'array è: " + i);
		}
	}
	
	public static void minValueIndexArray(int[] ar) {
		if(ar.length != 0) {
			
			int x = ar[0];
			int y = 0;
			
			for(int value : ar) {
				if(x > value) {
					x = value;
					y = Arrays.binarySearch(ar, x);
				}
			}
			
			System.out.println("L'indice del minimo elemento dell'array è: " + y);
		}
	}
	
	public static boolean contains(int e, int[] array) {
		/* if(Arrays.binarySearch(array, e) != -1) {
			return true;
		}
		
		return false; */
		
		for(int value : array) {
			if(e == value) {
				return true;
			}
		} 
		
		return false;
	}
	
	public static boolean contains(Object e, Object[] array) {
		for(Object value : array) {
			if(value.equals(e)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isCrescente(int[] array) {
		if(array.length != 0) {
			int x = array[0];
			
			for(int value: array) {
				if(x <= value) {
					x = value;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int mostRecurrent(int[] array) {
		int z = 0;
		
		if(array.length != 0) {
			int x = array[0];
			int y = 0;
			
			Arrays.sort(array);
			for(int value: array) {
				if(x == value) {
					y++;
				} else {
					x = value;
					y = 1;
				}
				
				if(z < y) {
					z = y;
				}
			}
		}
		
		return z;
		
	}
	
	public static void mediaMultipliDiTre(int[] array) {
		int x = 0;
		int y = 0;
		
		if(array.length != 0) {
			for(int value: array) {
				if(value % 3 == 0) {
					x += value;
					y++;
				}
			}
		}
		
		System.out.println("La media dei numeri divisibili per tre è: " + x/y);
	}
	
	public static void stampaZigZag(int[] array) {
		if(array.length == 10) {
			for(int i = 0; i < 5; i++) {
				System.out.print(array[i] + " ");
				System.out.print(array[array.length - 1 - i] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void media(int[] array) {
		int x = 0;
		int y = 0;
		
		if(array.length != 0) {
			for(int value: array) {
					x += value;
					y++;
			}
		}
		
		System.out.println("La media degli elementi dell'array è: " + x/y);
	}
	
	public static String[] addString(String s, String[] a) {
		String[] b = Arrays.copyOf(a, a.length + 1);
		b[b.length - 1] = s;
		return b;
	}
}
