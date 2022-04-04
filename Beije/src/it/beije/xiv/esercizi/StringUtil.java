package it.beije.xiv.esercizi;

public class StringUtil
{
	public static void main(String[] args)
	{
		StringUtil stringUtil = new StringUtil();
		
		System.out.println(stringUtil.substring("Ciaone", 2));
		System.out.println(stringUtil.substring("Ciaone", 1, 3));
		System.out.println(stringUtil.toLowerCase("CI4AO&ne"));
		System.out.println(stringUtil.toUpperCase("ci2aoNE1"));
		System.out.println(stringUtil.equals("Ciao", "Ciao"));
		System.out.println(stringUtil.equalsIgnoreCase("CiAo", "CiAO"));
		System.out.println(stringUtil.contains("Ciao", "ia"));
		System.out.println(stringUtil.startsWith("Ciao", "Ci"));
		System.out.println(stringUtil.endsWith("Ciao", "ao"));
		System.out.println(stringUtil.replace("Ciaoaa", 'a','b'));
		//System.out.println(stringUtil.replace("XaoXaoX", "ao", "ZZ"));
		System.out.println(stringUtil.trim("  A  Ciao AA  "));
	}
	
	
	String substring(String s, int beginIndex)
	{
		if (s == null || s.length() == 0 || beginIndex >= s.length()) return "ERROR";
		
		String s1 = "";
		
		for(int i = beginIndex; i < s.length(); i++)
		{
			s1 += s.charAt(i);
		}
		
		return s1;
	}
	
	String substring(String s, int beginIndex, int endIndex)
	{
		if (s == null || s.length() == 0 || beginIndex > endIndex || beginIndex >= s.length() || endIndex > s.length()) return "ERROR";
		
		String s1 = "";
		
		for(int i = beginIndex; i < endIndex; i++)
		{
			s1 += s.charAt(i);
		}
		
		return s1;
	}
	
	String toLowerCase(String s)
	{
		if (s == null || s.length() == 0) return "ERROR";
		
		String s1 = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			s1 += (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ? (char)(s.charAt(i) + 'a' - 'A') : s.charAt(i);
		}
		
		return s1;
	}
	
	String toUpperCase(String s)
	{
		if (s == null || s.length() == 0) return "ERROR";
		
		String s1 = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			s1 += (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ? (char)(s.charAt(i) + 'A' - 'a') : s.charAt(i);
		}
		
		return s1;
	}
	
	boolean equals(String s1, String s2)
	{
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		
		for(int i = 0; i < s1.length(); i++)
		{
			if (s1.charAt(i) != s2.charAt(i)) return false;
		}
		
		return true;
	}
	
	boolean equalsIgnoreCase(String s1, String s2)
	{
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		
		s1 = toLowerCase(s1);
		s2 = toLowerCase(s2);
		
		
		return equals(s1, s2);
	}
	
	boolean contains(String s, String str)
	{
		if (s == null || str == null || s.length() == 0 || str.length() == 0 || s.length() < str.length()) return false;
		
		for(int i = 0, j = 0; i < s.length(); i++, j++)
		{
			if (s.charAt(i) != str.charAt(j)) j = 0;
			
			if (j == str.length()-1) return true;
		}
		
		return false;
	}
	
	boolean startsWith(String s, String prefix)
	{
		if (s == null || prefix == null || s.length() == 0 || prefix.length() == 0 || s.length() < prefix.length()) return false;
		
		for(int i = 0, j = 0; i < s.length(); i++, j++)
		{
			if (s.charAt(i) != prefix.charAt(j)) return false;
			
			if (j == prefix.length()-1) return true;
		}
		
		return false;
	}
	
	boolean endsWith(String s, String suffix)
	{
		if (s == null || suffix == null || s.length() == 0 || suffix.length() == 0 || s.length() < suffix.length()) return false;
		
		for(int i = s.length()-1, j = suffix.length()-1; i >= 0; i--, j--)
		{
			if (s.charAt(i) != suffix.charAt(j)) return false;
			
			if (j == 0) return true;
		}
		
		return false;
	}
	
	String replace(String s, char oldChar, char newChar)
	{
		if (s == null || s.length() == 0) return "ERROR";
		
		String str = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == oldChar) str += newChar;
			else str += s.charAt(i);
		}
		
		return str;
	}
	
	
	//TODO FIXARE
	/*String replace(String s, String oldChar, String newChar)
	{
		if (s == null || oldChar == null || newChar == null || s.length() == 0 || oldChar.length() == 0 || newChar.length() == 0 || s.length() < oldChar.length()) return "ERROR";
		
		String str = "";
		int init = -1;
		int end = -1;
		int lastEnd = 0;
		
		for(int i = 0, j = 0; i < s.length(); i++, j++)
		{
			if(s.charAt(i) == oldChar.charAt(j))	//FOUND
			{
				if (init < 0) init = i;
				if (j == oldChar.length()-1)
				{
					end = i;
					j = 0;
				}
			}
			else	//NOTFOUND
			{
				j = 0;
				init = -1;
				end = -1;
			}
			
			if (init >= 0 && end >= 0)	//trovato  STAMPARE SOLO PREOCCORRENZE
			{
				//if (lastEnd > 0) init--;
				str += substring(s, lastEnd, init);	//da indice dopo della fine dell'ultima occorrenza fino a indice prima dell'inizio della prossima
				str += newChar;
				lastEnd = end+1;
				init = -1;
				end = -1;
				j = 0;
			}
			
			if (i == s.length()-1)	//STAMPARE DOPO ULTIMA OCCORRENZA FINO ALLA FINE
			{
				if (lastEnd < s.length()) str += substring(s, lastEnd, s.length());
			}
		}
		
		return str;
	}*/

	
	String trim(String s)  //TODO optimize?
	{
		if (s == null || s.length() == 0) return "ERROR";
		
		String str = "";
		int begin = -1;
		int end = -1;
		
		for(int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == ' ') continue;
			else
			{
				begin = i;
				break;
			}
		}
		
		for(int i = s.length()-1; i >= 0; i--)
		{
			if (s.charAt(i) == ' ') continue;
			else
			{
				end = i;
				break;
			}
		}
		
		str = s.substring(begin, end+1);
		
		return str;
	}
}