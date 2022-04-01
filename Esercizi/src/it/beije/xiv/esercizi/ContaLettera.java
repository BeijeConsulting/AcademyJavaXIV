package it.beije.xiv.esercizi;

public class ContaLettera {
	public static int contaLettera(char c, String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(c==str.charAt(i)) count++;
		}
		return count;
	}
	public static void main(String[]args) {
		String str = "ciaoccc";
		char c = 'c';
		int occorrenze = contaLettera(c,str);
		System.out.println(occorrenze);
	}
}
