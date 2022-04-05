package it.beije.xiv.esercizi;

public class Caffeina
{
	public static void main(String[] args)
	{
		Caffeina c = new Caffeina();
		System.out.println(c.caffeina(12));
	}
	
	String caffeina(int n)
	{
		if (n < 0) return "N NON POSITIVO";
		
		String str = ((n % 3) == 0) ? "Java" : "";
		str += ((n % 3) == 0 && (n % 4) == 0) ? "Coffee" : "";
		str += ((n % 2) == 0 && !str.equals("")) ? "Script" : "";
		str += (str.equals("")) ? "match_missed" : "";
		
		return str;
	}
}