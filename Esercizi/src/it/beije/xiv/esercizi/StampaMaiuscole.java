package it.beije.xiv.esercizi;

public class StampaMaiuscole {
	public static void main(String[]args) {
		String [] s = {"Alessio","Giorgio","Ilenia","monica"};
		StringBuilder soloVocali = new StringBuilder();
		for(int i=0;i<s.length;i++) {
			
			if(Character.isUpperCase(s[i].charAt(0))){
				soloVocali.append(s[i]+" ");
			
			}
		
		
		}
		System.out.println(soloVocali);
	}
}
