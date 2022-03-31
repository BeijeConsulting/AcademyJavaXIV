package it.beije.xiv.esercizi;
public class StringUtil {

	public static void main(String[] args) {
		

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
				sb.append(s.charAt(i) - 'A');
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
				sb.append(s.charAt(i) + 'a');
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
		return sb.toString();
	}
	
	//STRING BUILDER
	String substring(StringBuilder sb, int beginIndex) {
		StringBuilder tmp = new StringBuilder();
		for(int i = beginIndex; i < sb.length(); i++) {
			tmp.append(sb.charAt(i));
		}
		return tmp.toString();
	}
	String substring(StringBuilder sb, int beginIndex, int endIndex) {
		StringBuilder tmp = new StringBuilder();
		for(int i = beginIndex; i < sb.length(); i++) {
			if(i == endIndex) break;
			tmp.append(sb.charAt(i));
		}
		return tmp.toString();
	}
	StringBuilder delete(StringBuilder sb, int start, int end) {
		StringBuilder tmp = new StringBuilder();
		for(int i = start; i < sb.length(); i++) {
			if(i == end) break;
			tmp.append("");
		}
		sb = tmp;
		return tmp;
	}
	StringBuilder reverse(StringBuilder sb) {
		StringBuilder tmp = new StringBuilder();
		for(int i = sb.length()-1; i >= 0;i--) {
			tmp.append(sb.charAt(i));
		}
		sb = tmp;
		return tmp;
	}
}