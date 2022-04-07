package it.beije.xiv.esercizi.Stringhe;

public class StringBuilderUtil {
	public static void main(String[]args) {
		StringBuilderUtil s = new StringBuilderUtil();
		
		System.out.println(s.substring(new StringBuilder("Alessio"), 4));
		System.out.println("  ");
		System.out.println(s.substring(new StringBuilder("Alessio"), 4,5));
		System.out.println("  ");
		System.out.println(s.delete(new StringBuilder("Alessio"), 2,5));
		System.out.println("  ");
		System.out.print(s.reverse(new StringBuilder("Alessio")));
		
	}
	
	String substring(StringBuilder sb, int beginIndex) {
		StringBuilder s = new StringBuilder();
		for(int i=beginIndex; i<sb.length();i++) {
			s.append(sb.charAt(i));
		}
		return s.toString();
	}
	
	String substring(StringBuilder sb, int beginIndex, int endIndex) {
		StringBuilder s = new StringBuilder();
		for(int i=beginIndex; i<endIndex;i++) {
			s.append(sb.charAt(i));
		}
		return s.toString();
	}
	
	StringBuilder delete(StringBuilder sb, int start, int end) {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<sb.length();i++) {
			if(i< start || i>=end) {
				s.append(sb.charAt(i));
			}
		}
		
		return s;
	}
	
	StringBuilder reverse(StringBuilder sb) {
		StringBuilder s = new StringBuilder();
		for(int i=sb.length()-1; i>=0;i--) {
			s.append(sb.charAt(i));
		}
		return s;
	}
}
