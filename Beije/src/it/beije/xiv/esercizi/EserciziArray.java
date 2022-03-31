package it.beije.xiv.esercizi;

import java.util.Arrays;

public class EserciziArray
{
	public static void main(String[] args)
	{
		String ciao = "Ciao";
		String clone = "Tutto bene";
		int ee = 0;
		
		int[] arr = {1, 2, 5, 0, 6, -5, -3, 65, -5};	
		int[] arrCrescente = {1, 3, 5, 15};
		int[] arrRecurrent = {1, 5, 3, 7, 1, 2, 2, 4, 9, 9, 3, 1, 3, 3};
		int[] arrMedia = {3, 6, 3, 5, 12, 15, 4};
		int[] arrZigZag = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] arrString = {"Ciao", "come", "va?"};
		Object[] objArr = {new Object(), new String("Ciao"), ciao};
		
		
		System.out.println("ES1A: Print max -> " + findMax(arr));
		System.out.println("ES1B: Print min -> " + findMin(arr));
		System.out.println("ES2A: Print max index -> " + indexMax(arr));
		System.out.println("ES2B: Print min index -> " + indexMin(arr));
		System.out.println("ES3A: Array contais 'e' int -> " + contains(ee, arr));
		System.out.println("ES3B: Array contais 'e' object -> " + contains(ciao, objArr));
		System.out.println("ES4:  Array crescente -> " + isCrescente(arrCrescente));
		System.out.println("ES5:  Array elemento ricorrente -> " + mostRecurrent(arrRecurrent));
		System.out.println("ES6:  Array media %3 -> " + mediaMultipliDiTre(arrMedia));
		System.out.print("ES7:  Print zigzag -> ");
		stampaZigZag(arrZigZag);
		System.out.println("ES8:  Array media -> " + media(arrMedia));
		System.out.print("ES9:  Array copia + 's' -> ");
		printArray(addString(clone, arrString));
	}
	
	
	public static int findMax(int[] array)
	{
		if (array == null || array.length == 0) return Integer.MIN_VALUE;
		
		int max = array[0];
		
		for(int i : array)
		{
			if(max < i) max = i;
		}
		
		return max;
	}
	
	public static int findMin(int[] array)
	{
		if (array == null || array.length == 0) return Integer.MAX_VALUE;
		
		int min = array[0];
		
		for(int i : array)
		{
			if(min > i) min = i;
		}
		
		return min;
	}
	
	public static int indexMax(int[] array)
	{
		int index = -1;
		
		int max = findMax(array);
		
		for(int i = 0; i < array.length; i++)
		{
			if (array[i] == max) return i;
		}
		
		return index;
	}
	
	public static int indexMin(int[] array)
	{
		int index = -1;
		
		int max = findMin(array);
		
		for(int i = 0; i < array.length; i++)
		{
			if (array[i] == max) return i;
		}
		
		return index;
	}
	
	public static boolean contains(int e, int[] array)
	{
		if (array == null || array.length == 0) return false;
		
		for(int i = 0; i < array.length; i++)
		{
			if (array[i] == e) return true;
		}
		
		return false;
	}
	
	public static boolean contains(Object e, Object[] array)
	{
		if (array == null || array.length == 0) return false;
		
		for(int i = 0; i < array.length; i++)
		{
			//SE VOGLIO GUARDARE IL VALORE  if (array[i].equals(e)) return true;
			if (array[i] == e) return true;
		}
		
		return false;
	}
	
	public static boolean isCrescente(int[] array)
	{
		if (array == null || array.length == 0) return false;
		
		int temp = array[0];
		
		for(int i : array)
		{
			if (temp > i) return false;
		}
		
		return true;
	}
	
	public static int mostRecurrent(int[] array)
	{
		if (array == null || array.length == 0) return Integer.MAX_VALUE;

		Arrays.sort(array);
		
		int actualValue = array[0];
		int maxValue = array[0];
		int count = 0;
		int maxCount = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if (array[i] == actualValue) count++;
			else
			{
				if (count > maxCount)
				{
					maxCount = count;
					maxValue = array[i-1];
				}
				count = 1;
				actualValue = array[i];
			}			
		}
		
		return count > maxCount ? array[array.length-1] : maxValue;
	}
	
	public static float mediaMultipliDiTre(int[] array)
	{
		if (array == null || array.length == 0) return -1f;
		
		int media = 0;
		int count = 0;
		
		for(int i : array)
		{
			if (i % 3 == 0)
			{
				media += i;
				count++;
			}
		}
		
		return (float) media / count;
	}
	
	public static void stampaZigZag(int[] array)
	{
		if (array == null || array.length == 0) return;
		
		int begin = 0;
		int end = array.length-1;
		
		while(begin < end)
		{
			System.out.print(array[begin] + ", " + array[end] + ", ");
			begin++;
			end--;
		}
		
		System.out.println();
	}
	
	public static float media(int[] array)
	{
		if (array == null || array.length == 0) return -1f;
		
		int media = 0;
		
		for(int i : array)
		{
			media += i;
		}
		
		return (float) media / array.length;
	}
	
	public static String[] addString(String s, String[] a)
	{
		if (a == null || a.length == 0) return null;
		
		String[] newArray = new String[a.length+1];
		
		for(int i = 0; i < a.length; i++)
		{
			newArray[i] = a[i];
		}
		
		newArray[newArray.length-1] = s;
				
		return newArray;
	}
	
	public static void printArray(String[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
			if (i < array.length-1) System.out.print(", ");
		}
	}
}