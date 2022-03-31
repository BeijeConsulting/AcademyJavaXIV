package it.beije.xiv.esercizi;

//Scrivere il metodo: “public String [] addString(String s, String[] a)”, che accetta come parametri una stringa ed un array di stringhe. Restituisce un nuovo array, identico ad array, aggiungendo però, come ultimo elemento, la stringa s.
public class AddString {

	public String[] addString(String s, String[] a) {
		String[] newA = new String[a.length + 1];
		for(int i = 0; i < a.length; i++) {
			newA[i] = a[i];
		}
		newA[newA.length - 1] = s;
		return newA;
	}
	public static void main(String[] args) {
		
		String[] strings = {"ciao", "come", "stai", "bello", "mio"};
		String s = "eheh";
		AddString a = new AddString();
		
		String[] newStrings = a.addString(s, strings);
		
		for(String str : newStrings) {
			System.out.println(str);
		}
	
	}

}
