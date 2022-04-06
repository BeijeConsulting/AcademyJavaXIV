package src.it.beije.xiv.esercizi.eserciziCompleti;

public class Persistence {
public static void main(String...args)
{
	final int n = 39;
	System.out.println(persistence(n));
}
private static int persistence(int n)
{
	int count=0;
	String literal = Integer.valueOf(n).toString();
	if(literal.length()>1)
	{
		count++;
		int newNumber=1;
		for(int i = 0; i<literal.length();i++)
		{
			newNumber*=Integer.valueOf(Character.toString(literal.charAt(i)));;
		}
		count+= persistence(newNumber);
	}
	return count;
}
}
