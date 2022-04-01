package it.beije.xiv.esercizi;

public class SoloVocali {
	public static void main(String[]args) {
		String s = "RTaiOYuGoO";
		String vocali = "AaEeIiOoUu";
		StringBuilder soloVocali = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<vocali.length();j++) {
				if(s.charAt(i) == vocali.charAt(j)) {
					soloVocali.append(s.charAt(i));
				}
			}
		}
		System.out.println(soloVocali);
		
	}
}
