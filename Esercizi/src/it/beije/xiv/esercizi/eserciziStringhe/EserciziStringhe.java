package it.beije.xiv.esercizi.eserciziStringhe;

public class EserciziStringhe {
	public static void main(String[] args)
	{
		String s="aUdhccwiOadcwhfia";
		System.out.println("Stringa di partenza: "+s);
		System.out.println("le Vocali sono: "+soloVocali(s));
		System.out.println("Le maiuscole sono: "+soloMaiusc(s));
		System.out.println("nella stringa ci sono "+contaLetteraC(s)+" C");
		System.out.println("al contrario è: "+contrario(s));
		System.out.println("*******************");
		String s2= "Treno",s3="Camion",s4="Aereo";
		System.out.println("date le parole " +s2+", " +s3+" e "+s4);
		System.out.println("concatenate: "+concatena(s2,s3,s4));
		System.out.println();
		System.out.println("un metodo getter per "+s2+" è:");
		getter(s2);
		System.out.println();
		System.out.println("un metodo setter per "+s4+" è:");
		setter(s4);
		
	}
	
	private static String soloVocali(String s)
	{
		StringBuilder q = new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if("aeiou".contains(s.substring(i,i+1)))
					{
						q.append(s.charAt(i));
					}
		}
		return q.toString();
	}
	private static String soloMaiusc(String s)
	{
		StringBuilder q = new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
					{
						q.append(s.charAt(i));
					}
		}
		return q.toString();
	}	
	private static int contaLetteraC(String s)
	{
		int count=0;
		int index=-1;
		do
		{
			index++;
			index=s.indexOf('c',index);
			if(index!=-1)
			{
				count++;
				
			}
			
		}while(index != -1);
		return count;
	}
	private static String contrario(String s) 
	{
		StringBuilder b = new StringBuilder(s);
		b.reverse();
		return b.toString();
	}
	private static String concatena(String s,String s2,String s3)
	{
		String concatenata = s+"*"+s2+"*"+s3;
		return concatenata;
	}
	private static void getter(String s)
	{
		System.out.println("public Object get"+s+"()");
		System.out.println("{");
		System.out.println("return this."+s+";");
		System.out.println("}");
	}
	private static void setter(String s)
	{
		System.out.println("public void set"+s+"(Object o)");
		System.out.println("{");
		System.out.println("this."+s+"=o;");
		System.out.println("}");
	}
}
