package it.beije.xvi.esercizi;

import java.util.Arrays;

public class StringUtil {
	//Di seguito i metodi da implementare in un'ipotetica classe StringUtil:
	public String substring(String s, int beginIndex) {
		String newS = new String();
		
		if(beginIndex >= s.length()) {
			return "Error.";
		}
		
		for(int i = beginIndex; i < s.length(); i++) {
			newS += s.charAt(i);
		}
		
		return newS;
	}
	
	public String substring(String s, int beginIndex, int endIndex) {
		String newS = new String();
		
		if(beginIndex >= s.length()) {
			return "Error.";
		}
		
		for(int i = beginIndex; i < endIndex; i++) {
			newS += s.charAt(i);
		}
		
		return newS;
	}
	
	public String toLowerCase(String s) {
		String newS = new String();
		
		for(int i = 0; i < s.length(); i++) {
			int xC = s.charAt(i);
			if(65 <= xC & xC <= 90) {
				int x = xC + 32;
				char c = (char) x;
				newS += c;
			} else {
				newS += s.charAt(i);
			}
		}
		
		return newS;
	}
	
	public String toUpperCase(String s) {
		String newS = new String();
		
		for(int i = 0; i < s.length(); i++) {
			int xC = s.charAt(i);
			if(97 <= xC & xC <= 122) {
				int x = xC - 32;
				char c = (char) x;
				newS += c;
			} else {
				newS += s.charAt(i);
			}
		}
		
		return newS;
	}
	
	public boolean equals(String s1, String s2) {
		if(s1.length() < s2.length() || s1.length() > s2.length()) {
			return false;
		} else {
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean equalsIgnoreCase(String s1, String s2) {
		StringUtil s = new StringUtil();
		s1 = s.toLowerCase(s1);
		s2 = s.toLowerCase(s2);
		
		if(s1.length() < s2.length() || s1.length() > s2.length()) {
			return false;
		} else {
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean contains(String s, String str) {
		boolean value = false;
		
		if (s.length() < str.length()) {
			value = false;
		} else {
			for (int i = 0; i < s.length() - str.length(); i++) {
				if(value == true) {
					return value;
				}
				if(s.charAt(i) == str.charAt(0)) {
					for (int j = 0, x = i; j < str.length(); j++, x++) {
						if(s.charAt(x) != str.charAt(j)) {
							value = false;
						} else {
							value = true;
						}
					}
				}
			}
		}
		
		return value;
	}
	
	public boolean startsWith(String s, String prefix) {
		if(prefix.length() == 1) {
			if(s.charAt(0) == prefix.charAt(0)) {
				return true;
			} else {
				return false;
			}
		} else if(prefix.length() > s.length()) {
			return false;
		} else {
			for(int i = 0; i < prefix.length(); i++) {
				if(s.charAt(i) != prefix.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean endsWith(String s, String suffix) {
		if(suffix.length() == 1) {
			if(s.charAt(s.length() - 1) == suffix.charAt(suffix.length() - 1)) {
				return true;
			} else {
				return false;
			}
		} else if(suffix.length() > s.length()) {
			return false;
		} else {
			for(int i = s.length() - 1, j = suffix.length() - 1; i >= s.length() - suffix.length(); i--, j--) {
				if(s.charAt(i) != suffix.charAt(j)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String replace(String s, char oldChar, char newChar) {
		String str = new String();
		String strT = new String();
		strT += oldChar;
		StringUtil sU = new StringUtil();
		
		if(!sU.contains(s, strT)) {
			return "Error!";
		}
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar) {
				str += newChar;
			} else {
				str += s.charAt(i);
			}
		}
		
		return str;
	}
	
	public String replace(String s, String oldChar, String newChar) {
		String str = new String();
		
		StringUtil sU = new StringUtil();
		
		if(!sU.contains(s, oldChar)) {
			return "Error!";
		}
		if(oldChar.length() != newChar.length() || s.length() < oldChar.length() || s.length() < newChar.length() ) {
			return "Error!";
		}
		
		for(int i = 0; i < s.length(); i++) { 
			if(s.charAt(i) == oldChar.charAt(0)) {
				String strS = new String();
				for(int j = 0, x = i; j < oldChar.length(); j++, x++) {
					strS += s.charAt(x);
				}
				if(sU.equals(strS, oldChar)) {
					str += newChar;
					i += oldChar.length() - 1;
				}
			} else {
				str += s.charAt(i);
			}
		}
		
		return str;
	}
	
	public String trim(String s) {
		String str = new String();
		String strS = new String();
		int x = 0, y = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > 32) {
				x = 1;
			}
			if(x == 1) {
				str += s.charAt(i);
			}
		}
		for(int i = str.length() - 1; i > 0; i--) {
			if(str.charAt(i) > 32) {
				break;
			}
			y++;
		}
		for(int i = 0; i < str.length() - y; i++) {
			strS += str.charAt(i);
		}
		return strS;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringUtil s = new StringUtil();
		String str = "  Lorenzo  ";
		String str1 = "LoreNzo";
		
		System.out.println("Substring: " + s.substring(str, 6));
		System.out.println("Substring between: " + s.substring(str, 2, 6));
		System.out.println("To lower case: " + s.toLowerCase(str));
		System.out.println("To upper case: " + s.toUpperCase(str));
		System.out.println("Equals: " + s.equals(str, str1));
		System.out.println("Equals ignore case: " + s.equalsIgnoreCase(str, str1));
		System.out.println("Contains: " + s.contains(str, "lor"));
		System.out.println("Start with: " + s.startsWith(str, "Loe"));
		System.out.println("End with: " + s.endsWith(str, "no"));
		System.out.println("Replace with char: " + s.replace(str, 'o', 'a'));
		System.out.println("Replace with string: " + s.replace(str, "enz", "ale"));
		System.out.println("Trim:" + s.trim(str) + ":");
	}

}
