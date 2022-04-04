package it.beije.xiv.esercizi;

public class StringBuilderUtil {

	public static void main(String[] args)
	{
		StringBuilderUtil sbu = new StringBuilderUtil();
		StringBuilder sb = new StringBuilder("Ciao1234");
		
		System.out.println(sbu.substring(sb, 0));
		System.out.println(sbu.substring(sb, 2, 5));
		System.out.println(sbu.delete(sb, 2, 4));
		System.out.println(sbu.reverse(sb));
	}
	
	String substring(StringBuilder sb, int beginIndex)
	{
		if (sb == null || sb.length() == 0 || beginIndex > sb.length()) return "ERROR";
		
		StringBuilder newSb = new StringBuilder();
		
		for(int i = beginIndex; i < sb.length(); i++)
		{
			newSb.append(sb.charAt(i));
		}
		
		return newSb.toString();
	}
	
	String substring(StringBuilder sb, int beginIndex, int endIndex)
	{
		if (sb == null || sb.length() == 0 || beginIndex > sb.length() || endIndex > sb.length() || endIndex < beginIndex) return "ERROR";
		
		StringBuilder newSb = new StringBuilder();
		
		for(int i = beginIndex; i < endIndex; i++)
		{
			newSb.append(sb.charAt(i));
		}
		
		return newSb.toString();
	}
	
	StringBuilder delete(StringBuilder sb, int start, int end)
	{
		if (sb == null || sb.length() == 0 || start >= sb.length() || end > sb.length() || end < start) return null;
		
		StringBuilder newSb = new StringBuilder();
		
		newSb.append(substring(sb, 0, start));
		newSb.append(substring(sb, end));
		
		return newSb;
	}
	
	StringBuilder reverse(StringBuilder sb)
	{
		if (sb == null || sb.length() == 0) return null;
		
		StringBuilder newSb = new StringBuilder();
		
		for(int i = sb.length()-1; i >= 0; i--)
		{
			newSb.append(sb.charAt(i));
		}
		
		return newSb;
	}
}
