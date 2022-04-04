package it.beije.xiv.esercizi;

import java.util.ArrayList;

public class ConvertParenthesis
{
	ArrayList<Character> charList = new ArrayList<>();
	ArrayList<Character> charListRepeated = new ArrayList<>();
	
	public static void main(String[] args)
	{
		ConvertParenthesis cp = new ConvertParenthesis();
		String s = "ABCDEF";
		System.out.println(cp.convert(s));
	}
	
	String convert(String s)
	{
		if (s == null || s.length() == 0) return "ERROR";
		
		s = s.toLowerCase();
		initializeList(s);
		
		String str = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			if (isRepeated(charListRepeated, s.charAt(i))) str += ")";
			else str += "(";
		}
		
		return str;
	}
	
	boolean isRepeated(ArrayList<Character> ls, char c)
	{
		return (ls.contains(c)) ? true : false;
	}
	
	void initializeList(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if (!isRepeated(charList, s.charAt(i)) && !isRepeated(charListRepeated, s.charAt(i))) charList.add(s.charAt(i));
			else
			{
				charList.remove((Character)s.charAt(i));
				charListRepeated.add(s.charAt(i));
			}
		}
	}
}
