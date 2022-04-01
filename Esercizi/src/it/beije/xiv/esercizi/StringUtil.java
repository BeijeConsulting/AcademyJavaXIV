package it.beije.xiv.esercizi;

public class StringUtil {

	String substring(String s, int beginIndex) {
		if(beginIndex <= s.length() - 1) {
			
			String subbedString = new String();
			for(int i = beginIndex; i < s.length(); i++) {
				subbedString += s.charAt(i);
			}
			return subbedString;
		}
		return "Index out of range: " + beginIndex;
	}
	
	String substring(String s, int beginIndex, int endIndex) {
		if(((beginIndex <= s.length() - 1) && (endIndex <= s.length())) && beginIndex <= endIndex) {
			
			String subbedString = new String();
			for(int i = beginIndex; i < endIndex; i++) {
				subbedString += s.charAt(i);
			}
			return subbedString;
		}
		return "Index out of range";
	}
	
	String toLowerCase(String s) {
		String str = "";
		 
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				str += (char)(s.charAt(i) + 'a' - 'A');
			} else {
				str += s.charAt(i);
			}
		}
		return str;
	}
	
	String toUpperCase(String s) {
		String str = "";
		 
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				str += (char)(s.charAt(i) + 'A' - 'a');
			} else {
				str += s.charAt(i);
			}
		}
		return str;
	}
	
	boolean equals(String s1, String s2) {
		if (s1.length() == s2.length()) {
			for(int i = 0; i < s1.length(); i++)
				if(s1.charAt(i) != s2.charAt(i)) return false;
		} else return false;
		return true;
	}
	
	boolean equalsIgnoreCase(String s1, String s2) {
		s1 = toLowerCase(s1);
		s2 = toLowerCase(s2);
		return equals(s1, s2);
	}
	
	boolean contains(String s, String str) {
		if(s.length() >= str.length()) {
			for(int i = 0; i < s.length() - (str.length() - 1); i++) {
				for(int j = 0; j < str.length(); j++) {
					if(s.charAt(i + j) != str.charAt(j)) break;
					if(j == str.length() -1) return true;
				}
			}
		}
		return false;
	}
	
	boolean startsWith(String s, String prefix) {
		if(s.length() >= prefix.length()) {
			for(int j = 0; j < prefix.length(); j++) {
				if(s.charAt(j) != prefix.charAt(j)) break;
				if(j == prefix.length() -1) return true;
			}
		}
		return false;
	}
	
	boolean endsWith(String s, String suffix) {
		if(s.length() >= suffix.length()) {
			int beginIndex = s.length() - suffix.length();
			for(int i = beginIndex, j = 0; j < suffix.length(); j++, i++) {
				if(s.charAt(i) != suffix.charAt(j)) break;
				if(j == suffix.length() -1) return true;
			}
		}
		return false;
	}
	
	String replace(String s, char oldChar, char newChar) {
		String str = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != oldChar) str += s.charAt(i);
			else str += newChar;
		}
		return str;
	}
	
	String replace(String s, String oldChar, String newChar) {
		if(s.length() >= oldChar.length()) {
			int replaceIndexBegin = -1;
			String replacedStr = "";
			
			for(int i = 0; i < s.length() - (oldChar.length() - 1); i++) {
				for(int j = 0; j < oldChar.length(); j++) {					
					if(s.charAt(i + j) != oldChar.charAt(j)) break;
					if(j == oldChar.length() -1) {						
//						solo se trovo la parola oldChar, faccio il replace
						replaceIndexBegin = i;
						for(int k = 0, h = 0; k < s.length(); k++) {
							if (k == replaceIndexBegin && h < newChar.length()) {								
								replacedStr += newChar.charAt(h);
								h++;
								replaceIndexBegin++;
							} else {
								replacedStr += s.charAt(k);
							}
						}
						s = replacedStr;
						replacedStr = "";
					}
				}
			}
			return s;
		} else return "ERRORE LUNGHEZZA";
	}
	
	public static void main(String[] args) {
		
		String str = new String("ciaonAOFGOonopippo");
		String str2 = new String("ciaoAOFGOonopippO");
		StringUtil sUtil = new StringUtil();
		
		System.out.println(str.length());
		
		String substr = sUtil.substring(str, 15);
		System.out.println(substr);
		
		String substr2 = sUtil.substring(str, 3, 8);
		System.out.println(substr2);
		
		String lowCase = sUtil.toLowerCase(str);
		System.out.println(lowCase);
		
		String upCase = sUtil.toUpperCase(str);
		System.out.println(upCase);
		
		boolean equals = sUtil.equals(str, str2);
		System.out.println("is equals " + equals);
		
		boolean equalsIC = sUtil.equalsIgnoreCase(str, str2);
		System.out.println("is equalsIgnoreCase " + equalsIC);
		
		boolean contain = sUtil.contains(str, "nopi");
		System.out.println("contains " + contain);

		boolean startsW = sUtil.startsWith(str, "ciao");
		System.out.println("starts with " + startsW);
		
		boolean endsW = sUtil.endsWith(str, "opippo");
		System.out.println("ends with " + endsW);
		
		String replace = sUtil.replace(str, 'a', 'A');
		System.out.println("replaced char " + replace);
		
		String replace2 = sUtil.replace(str, "on", "gg");
		System.out.println("replaced string " + str);
		System.out.println("replaced string " + replace2);

	}

}
