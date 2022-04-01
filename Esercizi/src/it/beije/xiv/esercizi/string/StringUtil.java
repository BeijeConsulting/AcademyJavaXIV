package it.beije.xiv.esercizi.string;
public class StringUtil {

	public static void main(String[] args) {
		StringUtil s = new StringUtil();
		
		System.out.println(s.substring("Animali", 2));
		System.out.println();
		System.out.println(s.substring("Animali", 2,3));
		System.out.println();
		System.out.println(s.toLowerCase("Animali123"));
		System.out.println();
		System.out.println(s.toUpperCase("Animali123"));
		System.out.println();
		System.out.println(s.equals("Animali123","Animali123"));
		System.out.println();
		System.out.println(s.equalsIgnoreCase("Animali123","AnimalI123"));
		System.out.println();
		System.out.println(s.contains("Animali123","ali"));
		System.out.println();
		System.out.println(s.startsWith("Animali123","A"));
		System.out.println();
		System.out.println(s.endsWith("Animali","i"));
		System.out.println();
		System.out.println(s.replace("AnimAli123",'A','B'));
		System.out.println();
		System.out.println(s.replace("AnimAli123","A","B"));
		System.out.println();
		System.out.println(s.trim("\ta e i o u\t\n  "));
	}
	String substring(String s, int beginIndex) {
		StringBuilder ris = new StringBuilder();
		for(int i = beginIndex; i < s.length(); i++) {
			ris.append(s.charAt(i));
		}
		return ris.toString();
	}
	
	String substring(String s, int beginIndex, int endIndex) {
		StringBuilder ris = new StringBuilder();
		for(int i = beginIndex; i < s.length(); i++) {
			if(i == endIndex) break;
			ris.append(s.charAt(i));
		}
		return ris.toString();
		
	}
	
	String toLowerCase(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append((char)(s.charAt(i) + ('a'-'A')));
			}else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	String toUpperCase(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb.append((char)(s.charAt(i) - ('a'-'A')));
			}else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	boolean equals(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		for(int i = 0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) return false;
		}
		return true;
	}
	boolean equalsIgnoreCase(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		for(int i = 0; i<s1.length(); i++) {
			if(s1.toLowerCase().charAt(i) != s2.toLowerCase().charAt(i)) return false;
		}
		return true;
	}
	boolean contains(String str, String s) {
		int j = 0;
		for(int i = 0; i < str.length(); i++) {
			if(s.charAt(0) == str.charAt(i)) {
				for(j = 0; j < s.length(); j++) {
					if(s.charAt(j) == str.charAt(i)) {
						i++;
						continue;
					}
					break;
				}
			}
		}
		if(j == s.length()) {
			return true;
		}
		return false;
	}
	boolean startsWith(String s, String prefix) {
		if(s.charAt(0) == prefix.charAt(0)) return true;
		return false;
	}
	boolean endsWith(String s, String suffix) {
		if(s.charAt(s.length()-1) == suffix.charAt(0)) return true;
		return false;
	}
	String replace(String s, char oldChar, char newChar) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar) {
				sb.append(newChar);
			}else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	String replace(String s, String oldChar, String newChar) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar.charAt(0)) {
				sb.append(newChar.charAt(0));
			}else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	String trim(String s) {
		StringBuilder sb = new StringBuilder();
		boolean inMiddle = false;
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\t' || s.charAt(i) == '\r') && !inMiddle) {
				continue;
			}else {
				inMiddle = true;
				sb.append(s.charAt(i));
			}
		}
		sb.reverse();
		for(int i = s.length()-1, j = 0; i >= 0; i--) {
			if(s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\t' || s.charAt(i) == '\r') {
				sb.deleteCharAt(j);
				continue;
			}else {
				break;
			}
		}
		sb.reverse();
		return sb.toString();
	}
	
}