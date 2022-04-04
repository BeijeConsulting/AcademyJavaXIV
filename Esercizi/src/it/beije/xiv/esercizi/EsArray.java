package it.beije.xiv.esercizi;

import java.util.Arrays;

public class EsArray {
	public static void main(String[]args) {
		EsArray s = new EsArray();
		int[]array = {1,2,9,2,3,3,4,5,7,8};
		
		EsArray.maxArray(array);
		System.out.println();
		System.out.println("");
		
		EsArray.indiceMax(array);
		System.out.println();
		System.out.println("");
		
		System.out.println(s.isCrescente(array));
		System.out.println("");
		
		System.out.println(s.mostRecurrent(array));
		System.out.println("");
		
		System.out.println(s.mediaInteri(array));
		System.out.println("");
		
		System.out.println(s.mediaMultipliDiTre(array));
		System.out.println("");
		
		EsArray.stampaZigZag(array);
		System.out.println();
		System.out.println("");
		
		
	}
	
	public static void maxArray(int[] array) {
		int max = 0, min = array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				max = array[i];
			}
			if(array[i]<min) {
				min = array[i];
			}
		}
		System.out.print("massimo: "+max+"; minimo: "+min);
	}
	
	public static void indiceMax(int[]array) {
		int max=0, min=array[0];
		int indiceMax=0, indiceMin=0;
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
		System.out.println("massimo: "+max+" con indice "+indiceMax+"; minimo: "+min+" con indice "+indiceMin);
	}
	
	boolean isCrescente(int[]array) {
		boolean b = true;
		for(int i=0; i<array.length-1;i++) {
			if(array[i] > array[i+1]) {
				b = false;
				break;
			}
		}
		return b;
	}
	
	int mostRecurrent(int[]array) {
		Arrays.sort(array);        
        int max_count = 1, res = array[0];
        int curr_count = 1;
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] == array[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = array[i - 1];
                }
                curr_count = 1;
            }
        }
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = array[array.length - 1];
        }
        return res;
	}
	
	float mediaMultipliDiTre(int[]array) {
		float somma = 0;
		int count = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]%3==0) {
				somma+=array[i];
				count++;
			}
		}
		return (float)(somma/count);
	}
	
	public static void stampaZigZag(int[]array) {
		for(int i=0;i<array.length/2;i++) {
			System.out.println(array[i]+" ");
			System.out.println(array[array.length-1-i]+" ");
		}
	}
	float mediaInteri(int[]array) {
		float somma=0;
		for(int i=0;i<array.length;i++) {
			somma+= array[i];
		}
		return (float)(somma/array.length);
	}
}
