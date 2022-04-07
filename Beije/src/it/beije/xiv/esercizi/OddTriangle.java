package it.beije.xiv.esercizi;

public class OddTriangle
{
	public static void main(String[] args)
	{
		OddTriangle ot = new OddTriangle();
		int lines = 9;
		
		System.out.println("Somma: " + ot.rowSumOddNumbers(lines));
	}
	
	
	public int rowSumOddNumbers(int n)
	{
		int sum = 0;
		int[][] triangle = generateOddTriangle(n);
		
		for(int i = 0; i < triangle[n-1].length; i++)
		{
			sum += triangle[n-1][i];
		}
		
		return sum;
	}
	
	public int[][] generateOddTriangle(int lines)
	{
		int[][] triangle = new int[lines][];
		int line = 1;
		int lastNumber = 1;
		
		for(int i = 0; i < triangle.length; i++, line++)
		{
			triangle[i] = new int[line];
			
			for(int j = 0; j < triangle[i].length; j++)
			{
				triangle[i][j] = lastNumber;
				lastNumber +=2;
				
				System.out.print(triangle[i][j] + " ");
			}
			
			System.out.println();
		}
		
		
		return triangle;
	}
}