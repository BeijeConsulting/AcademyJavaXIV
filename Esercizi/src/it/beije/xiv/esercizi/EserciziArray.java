package src.it.beije.xiv.esercizi;
import java.util.Arrays;
public class EserciziArray {
		public static void main(String[] args) {
			int[] array = {6,10,2,8,9,12,5,8};
			for(int i : array)
			{
				System.out.print(" " + i + " ");
			}
			System.out.println();
			System.out.println(trovaMax(array));
			System.out.println(trovaMaxIndex(array));
			//Arrays.sort(array);
			System.out.println(isCrescente(array));
			//System.out.println(mostRecurrent(array));
			System.out.println(mediaMultipli3(array));
			zigZagPrint(array);
		}
		
		
		static int trovaMax(int[] array)
		{
			int max=array[0];
			for(int i : array)
			{
				if(i>max)
				{
					max=i;
				}
			}
			return max;
		}
		static int trovaMaxIndex(int[] array)
		{
			int index=0;
			for(int i=0;i<array.length;i++)
			{
				if(array[i]>array[index])
				{
					index = i;
				}
			}
			return index;
		}
		static boolean isCrescente(int[] array)
		{
			boolean crescente = true;
			for(int i=0;i<array.length-1;i++)
			{
				if(array[i]>=array[i+1])
				{
					crescente=false;
					break;
				}
			}
			return crescente;
		}		
		static int mostRecurrent(int[] array)
		{
			int [] newArray = array;
			Arrays.sort(newArray);
			int topCount=0;
			int recordOwner=-1;
			for(int i=0;i<newArray.length;)
			{
				int count=0;
				int tested = newArray[i];
				while(tested==newArray[i])
				{
					if(i==newArray.length-1) 
					{
					i++;
					break;
					}
					count++;
					i++;
				}
				if(count>topCount)
				{
					topCount=count;
					recordOwner=tested;
				}
			}
			return recordOwner;
		}
		static int mediaMultipli3(int[] array)
		{
			int media=0;
			int count=0;
			for(int i:array)
			{
				if(i%3==0)
				{
					media+=i;
					count++;
				}
			}
			media/=count;
			return media;
		}
		static void zigZagPrint(int[]array)
		{
			int[] zigzag=new int[array.length];
			int half = array.length/2;
			for(int i=0,k=0;k<half;i+=2,k++)
			{
				zigzag[i]=array[k];
			}
			for(int i=1,k=array.length-1;k>half;i+=2,k--)
			{
				zigzag[i]=array[k];
			}
			
				zigzag[zigzag.length-1]=array[half];
			
			for(int i : zigzag)
			{
				System.out.print(" "+ i+ " ");
			}
			System.out.println();
		}
		
}

