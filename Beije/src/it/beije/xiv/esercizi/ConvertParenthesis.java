package it.beije.xiv.esercizi;

public class ConvertParenthesis
{
	public static void main(String[] args)
	{
		ConvertParenthesis cp = new ConvertParenthesis();
		String s = "Success";
		System.out.println(cp.convert(s));
	}
	
	public String convert(String str)
	{
		str = str.toLowerCase();
		String converted = str;
		
		for(int i = 0; i < str.length(); i++)
		{
			if (str.substring(i+1).contains(str.charAt(i) + ""))
			{
				converted = converted.replace(str.charAt(i), ')');
			}
			else converted = converted.replace(str.charAt(i), '(');
		}
		
		return converted;
	}
}