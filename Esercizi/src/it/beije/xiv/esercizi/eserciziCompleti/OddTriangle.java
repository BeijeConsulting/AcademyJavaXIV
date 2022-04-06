package src.it.beije.xiv.esercizi.eserciziCompleti;
public class OddTriangle {
	
	final static int[][] triangle = {{1},{3,5},{7,9,11},{13,15,17,19},{21,23,25,27,29}};
	public static void main(String...args)
	{
		int n = 2;
		System.out.println(rowSummOddNumbers(n));
	}
	private static int rowSummOddNumbers(int n)
	{
		int sum=0;
		for(int i: triangle[n])
		{
			sum+=i;
		}
		return sum;
	}
}
