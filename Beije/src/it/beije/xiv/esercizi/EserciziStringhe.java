package it.beije.xiv.esercizi;

public class EserciziStringhe
{
	public static void main(String[] args)
	{
		String[] strings = new String[] {"Ciao", "ciao", "CIaone", "ciaissImo"};
		
		System.out.println("ES1: Stringa -> vocali: " + soloVocali(args[0]));
		
		stampaMaiuscole(strings);
		
		System.out.print(contaLettera('p', args[0]));
		
		System.out.print("\nES4: Stringa al contrario -> " + contrario(args[0]));
		
		concatena(args[0], args[1], args[2]);
		
		createSetter(args[0]);
		
		createGetter(args[0]);
	}
	
	public static String soloVocali(String stringa)
	{
		if (stringa == null) return "Stringa vuota";
		
		StringBuilder vocali = new StringBuilder();
		
		for(char c : stringa.toCharArray())
		{
			switch (c)
			{
				case 'a':
					vocali.append(c);
					break;
					
				case 'e':
					vocali.append(c);
					break;
					
				case 'i':
					vocali.append(c);
					break;
				
				case 'o':
					vocali.append(c);
					break;
					
				case 'u':
					vocali.append(c);
					break;
					
				case 'A':
					vocali.append(c);
					break;
					
				case 'E':
					vocali.append(c);
					break;
					
				case 'I':
					vocali.append(c);
					break;
				
				case 'O':
					vocali.append(c);
					break;
					
				case 'U':
					vocali.append(c);
					break;
					
				default:
					break;
			}
					
		}
		
		return vocali.toString();
	}
	
	public static void stampaMaiuscole(String[] stringhe)
	{
		System.out.print("ES2: Stampa stringhe con maiuscola -> ");
		
		for(String s : stringhe)
		{
			if (s.charAt(0) == s.toUpperCase().charAt(0)) System.out.print(s + " ");
		}
	}
	
	public static int contaLettera(char c, String str)
	{
		int counter = 0;
		
		System.out.print("\nES3: Occorrenze di \"" + c + "\" in \"" + str + "\" -> ");
		
		for(char ch : str.toCharArray())
		{
			if (ch == c) counter++;
		}
		
		return counter;
	}
	
	public static String contrario(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		
		return sb.reverse().toString();
	}
	
	public static void concatena(String s1, String s2, String s3)
	{
		StringBuilder conc = new StringBuilder(s1 + "*" + s2 + "*" + s3);
		
		System.out.print("\nES5: Concatena stringhe -> " + conc);
	}
	
	public static void createSetter(String s)
	{
		StringBuilder sb = new StringBuilder(s.toLowerCase());
		sb.setCharAt(0, s.toUpperCase().charAt(0));
		
		System.out.print("\nES6: Setter per var -> ");
		
		System.out.print("\n\npublic void set" + sb + "(Type " + s + ", Type value)\n"
				+ "{\n"
				+ "   " + s + " = value;\n"
				+ "}");
	}
	
	public static void createGetter(String s)
	{
		StringBuilder sb = new StringBuilder(s.toLowerCase());
		sb.setCharAt(0, s.toUpperCase().charAt(0));
		
		System.out.print("\n\nES7: Getter per var -> ");
		
		System.out.print("\n\npublic Type get" + sb + "(Type " + s + ")\n"
				+ "{\n"
				+ "   return " + s + ";\n"
				+ "}");
		
	}
}
