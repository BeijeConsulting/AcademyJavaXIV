package it.beije.xiv.nardella;

import java.util.ArrayList;

public class StringConversion {

	public static void main(String[] args) {
		String string = "Arrivederci";
		String s = "((@" ;
		System.out.println(convert(string.toLowerCase()));
		System.out.println(convert(s.toLowerCase()));
		System.out.println(convert("MarcoNardo".toLowerCase()));
	}
	
	public static String convert(String string) {
		ArrayList<Character> single = new ArrayList<>();
		ArrayList<Character> doubles = new ArrayList<>();
		Character c;	
		for(int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
			if(single.contains(c) && !doubles.contains(c)) {
				doubles.add(c);
				single.remove(c);
			}
			else if(!doubles.contains(c)) {
				single.add(c);
			}
		}
		
		
		
		for(Character ch : single) {
			string = string.replace(ch.charValue(), '(');
		}
		for(Character ch : doubles) {
			string = string.replace(ch.charValue(), ')');
			
		}
		
		
		System.out.println("Single: " + single);
		System.out.println("Doubles: " + doubles);
		return string;
	}

}
