package it.beije.xiv.esercizi;

public class StringBuilderUtil {

	public static void main(String[] args) {
			StringBuilderUtil sb = new StringBuilderUtil();
			
			System.out.println(sb.substring(new StringBuilder("Animali"), 2));
			System.out.println();
			System.out.println(sb.substring(new StringBuilder("Animali"), 2,3));
			System.out.println();
			System.out.println(sb.delete(new StringBuilder("Animali"),1,3));
			System.out.println();
			System.out.println(sb.reverse(new StringBuilder("Animali")));
			System.out.println();
	}
	
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
		for(int i = 0; i < sb.length(); i++) {
			if(i >= start && i < end) {
				tmp.append("");
				continue;
			}
			tmp.append(sb.charAt(i));
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
