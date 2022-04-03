package it.beije.xvi.esercizi;

public class StringBuilderUtil {
	//Di seguito i metodi da implementare in un'ipotetica classe StringBuilderUtil:
	public String substring(StringBuilder sb, int beginIndex) {
		String newS = new String();
		
		if(beginIndex >= sb.length()) {
			return "Error.";
		}
		
		for(int i = beginIndex; i < sb.length(); i++) {
			newS += sb.charAt(i);
		}
		
		return newS;
	}
	
	public String substring(StringBuilder sb, int beginIndex, int endIndex) {
		String newS = new String();
		
		if(beginIndex >= sb.length()) {
			return "Error.";
		}
		
		for(int i = beginIndex; i < endIndex; i++) {
			newS += sb.charAt(i);
		}
		
		return newS;
	}
	
	public StringBuilder delete(StringBuilder sb, int start, int end) {
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < sb.length(); i++) {
			if(i < start || i >= end) {
				s.append(sb.charAt(i));
			}
		}
		
		return s;
	}
	
	public StringBuilder reverse(StringBuilder sb) {
		StringBuilder s = new StringBuilder();
		
		for(int i = sb.length() - 1; i >= 0; i--) {
			s.append(sb.charAt(i));
		}
		
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilderUtil s = new StringBuilderUtil();
		StringBuilder str = new StringBuilder("Lorenzo");
		
		System.out.println("Substring with StringBuilder: " + s.substring(str, 2));
		System.out.println("Substring with StringBuilder and a end: " + s.substring(str, 2, 4));
		System.out.println("Delete: " + s.delete(str, 1, 3));
		System.out.println("Reverse: " + s.reverse(str));
	}

}
