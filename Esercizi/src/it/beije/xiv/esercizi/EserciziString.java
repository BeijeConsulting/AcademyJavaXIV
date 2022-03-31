package it.beije.xiv.esercizi;

public class EserciziString {

	public static void main(String[] args) {
		EserciziString.esercizio1("Ciao");
		System.out.println();
		EserciziString.esercizio2(new String[] {"Aiuola","cavallo", "Alce"});
		System.out.println();
		new EserciziString().contaLettera('a', "aiuola");
		System.out.println();
		EserciziString.esercizio4("Viva Java!");
		System.out.println();
		EserciziString.esercizio5(null,"cane","topo");
		System.out.println();
		EserciziString.esercizio6("cippo");
		System.out.println();
	}
	
	public static void esercizio1(String s) {
		System.out.println("Esercizio 1");
		for(int i = 0; i < s.length(); i++) {
			if(s.toLowerCase().charAt(i) == 'a' || s.toLowerCase().charAt(i) == 'e' || s.toLowerCase().charAt(i) == 'i' 
					|| s.toLowerCase().charAt(i) == 'o' || s.toLowerCase().charAt(i) == 'u') {
				System.out.print(s.charAt(i));
			}
		}
		System.out.println();
	}
	public static void esercizio2(String[] s) {
		System.out.println("Esercizio 2");
		for(String tmp : s) {
			char c = tmp.charAt(0);
			if(c == tmp.toUpperCase().charAt(0)) {
				System.out.print(tmp + ", ");
			}
		}
		System.out.println();
	}
	public int contaLettera(char c, String str) {
		int ris = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)
				ris++;
		}
		return ris;
	}
	public static void esercizio4(String s) {
		System.out.println("Esercizio 4");
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	}
	public static void esercizio5(String s1, String s2, String s3) {
		System.out.println("Esercizio 5");
		System.out.println(s1+"*"+s2+"*"+s3);
	}
	public static void esercizio6(String s) {
		System.out.println("Esercizio 6 & 7");
		System.out.println("public void set"+s.toUpperCase().charAt(0)+s.substring(1)+"("+s.toUpperCase().charAt(0)+s.substring(1)+ " "+ s.toLowerCase().charAt(0) + "){\n"
				+ "  this."+s.toLowerCase().charAt(0)+"="+s.toLowerCase().charAt(0)+";\n}");
		System.out.println("public " + s.toUpperCase().charAt(0)+s.substring(1) + " get"+s.toUpperCase().charAt(0)+s.substring(1)+"(){\n"
				+ "  return this." + s.toLowerCase().charAt(0) +";\n}");
	}
}
