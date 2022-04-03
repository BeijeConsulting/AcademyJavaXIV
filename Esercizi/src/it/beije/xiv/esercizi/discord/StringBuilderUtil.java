package it.beije.xiv.esercizi.discord;
import java.lang.StringBuilder;

public class StringBuilderUtil {

	public String substring(StringBuilder sb, int beginIndex){		
		if (beginIndex>=sb.length()) {
			sb.charAt(beginIndex);		//StringIndexOutOfBoundsException
		}
		String result = new String();
		for (int i=beginIndex; i<sb.length(); i++) {
			result += sb.charAt(i);		//add each char until end of string
		}
		return result;
	}

	public String substring(StringBuilder sb, int beginIndex, int endIndex){
		if (beginIndex>=sb.length()|endIndex>sb.length()) {
			sb.charAt(beginIndex);	
			sb.charAt(endIndex);					//StringIndexOutOfBoundsException
		} else if (beginIndex > endIndex) {
			sb.charAt(endIndex-beginIndex);		//StringIndexOutOfBoundsException
		}
		String result = new String();
		for (int i=beginIndex; i<endIndex; i++) {
			result += sb.charAt(i);				//add each char until endIndex
		}
		return result;
		
		
	}
	
	public StringBuilder delete(StringBuilder sb, int start, int end) {
		
		if (start>=sb.length()|end>sb.length()) {					//if illegal indexes
			sb.charAt(start);										//StringIndexOutOfBoundsException
			sb.charAt(end);}
		StringBuilderUtil sbu = new StringBuilderUtil();
		StringBuilder result = new StringBuilder();
		result.append(sbu.substring(sb, 0, start));					//assemble first section of StringBuilder
		if(end!=sb.length()) {										//if not deleting the very end of the StringBuilder
			result.append(sbu.substring(sb, end));					//assemble last section of StringBuilder
		}
		return result;
		}

	public StringBuilder reverse(StringBuilder sb) {
		
		StringBuilder result = new StringBuilder();				
		for (int i = sb.length()-1; i>=0; i--) {					//for each char in main StringBuilder
			result.append(sb.charAt(i));							//append in reverse order
		}
		return result;		
	}
	
	
	public static void main(String[] args) {

		StringBuilderUtil sbu = new StringBuilderUtil();
		StringBuilder sb = new StringBuilder ("abcDEF$$$");
//		System.out.println(sb);
//		System.out.println(sbu.substring(sb, 3));
//		System.out.println(sbu.substring(sb, 3, 6));
//		System.out.println(sbu.delete(sb, 3, 6));
//		System.out.println(sbu.delete(sb, 3, 9));
//		System.out.println(sbu.reverse(sb));
		
	}

}
