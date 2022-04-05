package it.beije.xiv.esercizi;

public class Esercitazione2_3 {
	public static void main(String[] args) {
		// Scrivere il metodo  public int contaLettera(char c, String str)
		String s = "supercalifragilistichespiralidoso";
		int o = contaLettera('i', s);
		System.out.println(o);
		
		
	}
	
	public static int contaLettera(char c, String str) {
		int occ=0; 
		for(int i=0; i<str.length(); i++) {
			if(c == str.charAt(i)) {
				occ++;
			}
		}
		return occ;
	}
	
	
}
