package it.beije.xiv.esercizi;

import java.util.Scanner;

public class MorraCinese
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
				
		String mossa1 = null;
		int int1 = 0;
		int int2 = 0;
		
		do
		{
			System.out.print("Inserire mossa 1: ");
			
			mossa1 = kb.next();
			mossa1 = mossa1.toLowerCase();
			
			if (mossa1.equals("carta")) int1 = 0;
			else if (mossa1.equals("forbice")) int1 = 1;
			else if (mossa1.equals("sasso")) int1 = 2;
			else mossa1 = null;
			
		} while(mossa1 == null);
				
		String mossa2 = null;
		
		do
		{
			System.out.print("\nInserire mossa 2: ");
			
			mossa2 = kb.next();
			mossa2 = mossa2.toLowerCase();
			
			if (mossa2.equals("carta")) int2 = 0;
			else if (mossa2.equals("forbice")) int2 = 1;
			else if (mossa2.equals("sasso")) int2 = 2;
			else mossa2 = null;
			
		} while(mossa2 == null);
		
		kb.close();
		
		System.out.print("\n" + calculateWinner(int1, int2));		
	}

	public static String calculateWinner(int mossa1, int mossa2)
	{
		if (mossa1 == mossa2) return "Pareggio";
		return (mossa2 == (mossa1 + 1) % 3) ? "Vincitore: Player 2" : "Vincitore: Player 1";		
	}
}