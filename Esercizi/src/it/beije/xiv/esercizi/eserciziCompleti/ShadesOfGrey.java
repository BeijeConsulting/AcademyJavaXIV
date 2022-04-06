package src.it.beije.xiv.esercizi.eserciziCompleti;

import java.util.Random;

public class ShadesOfGrey{
	String shade;
	ShadesOfGrey(String shade)
	{
		this.shade = shade;
	}
	public static void main(String...args)
	{
		int n = 3;
		ShadesOfGrey[] shades = populateArray(n);
		for(ShadesOfGrey s : shades)
		{
			System.out.println(s.shade);
		}

	}
	
	static ShadesOfGrey[] populateArray(int n)
	{
		ShadesOfGrey[] shades = new ShadesOfGrey[n];
		for(int i = 0;i<n;i++)
		{
			Random random = new Random();
			int value = random.nextInt(100);
			String hex = Integer.toHexString(value);
			StringBuilder fullshade = new StringBuilder();
			fullshade.append("#"+hex+hex+hex);
			shades[i]=new ShadesOfGrey(fullshade.toString());
		}
		return shades;
	}
}
