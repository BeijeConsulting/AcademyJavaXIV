package it.beije.xiv.esercizi;

public class StringUtil {
	
	public static void main(String arg[]) {
		System.out.println(subString("0123456789", 1));
		System.out.println(subString("0123456789", 2, 5));
		System.out.println(toUpperCase("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(toLowerCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		System.out.println(equals("Ciao", "Ciao"));
		System.out.println(equalsIgnoreCase("ciao", "CIAO"));
		System.out.println(contains("abababaabc", "abc"));
		System.out.println(startsWith("abababaabc", "aba"));
		System.out.println(endsWith("abababaabc", "aabc"));
		System.out.println(replace("ababababaababaccccc", 'a', 'b'));
		System.out.println(replace("DbabaDbabaDbabaDcccDbaba9866è+d", "baba", "og"));
		System.out.println(trim("\t    \n       DbabaDbabaDbabaDcccDbaba9866è+d\t    cs   \n       "));
	}
	
	static String subString(String s, int beginIndex) {
		String a = "";
		
		for(int i = beginIndex; i < s.length(); i++) {
			a += s.charAt(i);
		}
		
		return a;
	}
	
	static String subString(String s, int beginIndex, int endIndex) {
		String a = "";
		
		if(endIndex <= s.length()) {
			for(int i = beginIndex; i < endIndex; i++) {
				a += s.charAt(i);
			}
		}
		
		return a;
	}
	
	static String toLowerCase(String s) {
		String b = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > 64 && s.charAt(i) < 91) {
				b += (char)(s.charAt(i) + ('a' - 'A')); 
			} else {
				b += s.charAt(i);
			}
		}
		
		return b;
	}
	
	static String toUpperCase(String s) {
		String b = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > 96 && s.charAt(i) < 123) {
				b += (char)(s.charAt(i) - ('a' - 'A')); 
			} else {
				b += s.charAt(i);
			}
		}
		
		return b;
	}
	
	static boolean equals(String s1, String s2) {
		int i = 0; 
		if(s1.length() == s2.length()) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) != s2.charAt(j)) {
					return false;
				} else {
					i++;
				}
			}
			
		return true;
			
		} else {
			return false;
		}
	}
	
	static boolean equalsIgnoreCase(String s1, String s2) {
		
		String b1 = toLowerCase(s1);
		String b2 = toLowerCase(s2);
		return equals(b1, b2);
	}
	
	static boolean contains(String s1, String s2) {
		
		for(int i = 0; i <= s1.length() - s2.length(); i++) {
			if(subString(s1, i, i + s2.length()).equals(s2)) {
				return true;
			}
		}
			
		return false;
	}
	
	static boolean startsWith(String s, String prefix) {
		
		if(s.length() >= prefix.length() && subString(s, 0, prefix.length()).equals(prefix)) {
			return true;
		}
		
		return false;
	}
	
	static boolean endsWith(String s, String prefix) {
		
		if(s.length() >= prefix.length() && subString(s, s.length() - prefix.length(), s.length()).equals(prefix)) {
			return true;
		}
		
		return false;
	}
	
	static String replace(String s, char oldChar, char newChar) {
		String sReplace = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar) {
				sReplace += newChar;
			} else {
				sReplace+= s.charAt(i);
			}
		}
		
		return sReplace;
	}
	
	static String replace(String s, String oldChar, String newChar) {
		String sReplace = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(subString(s, i, i + oldChar.length()).equals(oldChar)) {
				sReplace += newChar;
				i += oldChar.length() - 1;
			} else {
				sReplace += s.charAt(i);
			}
		}
		
		return sReplace;
	}
	
	static String trim(String s) {
		String sReplace = "";
		boolean primoCarattereValido = false;
		int j = 0;
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) >= '\u0020') {
				j = i;
				break;
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(!primoCarattereValido && s.charAt(i) <= '\u0020') {
				sReplace += "";
			} else if(i > j) {
				break;
			} else {
				if(!primoCarattereValido) {
					primoCarattereValido = true;
				}
				sReplace += s.charAt(i);
			}
		}
		
		return sReplace;
	}


}
