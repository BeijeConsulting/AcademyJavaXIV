package it.beije.xiv.esercizi.Stringhe;

public class EsString {
	public static void main(String[]args) {
		EsString e = new EsString();
		
		String[] a = {"Cane", "gatto", "Topo", "Elefante"};
		String s = "orso";
		
		e.addString(s, a);
		System.out.println();
		System.out.println(" ");
		
		e.contaLettera('o', s);
		System.out.println();
		System.out.println(" ");
		
		e.soloVocali("AbcdEfghilmnO");
		System.out.println();
		System.out.println(" ");
		
		e.stampaMaiuscole(a);
		System.out.println();
		System.out.println(" ");
	}
	
	public static void addString(String s, String[]a) {
		String[]b = new String[a.length+1];
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
			System.out.print(b[i]+" ");
		}
		for(int i=a.length;i<b.length;i++) {
			b[i]=s;
			System.out.print(b[i]+" ");
		}	
	}
	
	public static void contaLettera(char c, String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(c==str.charAt(i)) count++;
		}
		System.out.println(count+" occorrenze");
	}
	
	public static void soloVocali(String s) {
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
	
	public static void stampaMaiuscole(String[] s) {
		StringBuilder soloVocali = new StringBuilder();
		for(int i=0;i<s.length;i++) {
			if(Character.isUpperCase(s[i].charAt(0))){
				soloVocali.append(s[i]+" ");
			}
		}
		System.out.println(soloVocali);
	}
	
}
