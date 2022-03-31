package it.beije.xiv.esercizi;

public class EserciziCicli
{
	public static void main(String[] args)
	{
		System.out.println("ES1: Stampa primi dieci numeri interi\n");
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i);
		}


		System.out.println("\n\nES2: Stampa primi dieci interi pari tra 20 e 0\n");
		
		for (int i = 20; i > 0; i--)
		{
			if (i%2 == 0) System.out.println(i);
		}
		
		
		System.out.println("\n\nES3: Stampa tabellina del numero in parametro: " + args[0] + "\n");
		
		int n = Integer.parseInt(args[0]);
		for (int i = 1; i <= 10; i++)
		{
			System.out.println(n * i);
		}
		
		
		System.out.println("\n\nES4: Stampa *\n");
		
		for (int i = 0; i < 6; i++)
		{
			for (int j = i; j < 6; j++)
			{
				System.out.print("*");
			}
			
			if (i < 5) System.out.println();
		}
		
		
		System.out.println("\n\nES5: Stampa #\n");
		
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.print("#");
			}
			
			if (i < 5) System.out.println();
		}


		System.out.println("\n\nES6: Stampa 1      654321\n");
		
		for (int i = 0; i < 6; i++)
		{
			for (int j = 1 + i; j > 0; j--)
			{
				System.out.print(j);
			}
			
			System.out.print("      ");
			
			for (int j = 6 - i; j > 0; j--)
			{
				System.out.print(j);
			}
			
			if (i < 6) System.out.println();
		}
		
		
		System.out.println("\n\nES7: Stampa primi 100 elementi di fibonacci\n");

		long first = 0, second = 1;
		for (int i = 0; i <= 100; i++)
		{
			System.out.print(second);
			if (i < 100) System.out.print(", ");
			long temp = second;
			second += first;
			first = temp;
		}
		
		
		System.out.println("\n\nES8: Stampa primi 100 elementi di fibonacci in righe\n");

		
		for (int i = 0; i < 100; i++)
		{
			long f = 0, s = 1;
					
			for (int j = 0; j <= i; j++)
			{
				System.out.print(s);
				if (j < i) System.out.print(", ");
				long temp = s;
				s += f;
				f = temp;
			}
			
			f = s = 1;
			
			System.out.println();
		}
		
	}
}