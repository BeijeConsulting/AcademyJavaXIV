
public class Stringhe {
	public static void soloVocali(String str) {
		for (int i = 0; i < str.length(); i++) {
			char lett = str.charAt(i);
			switch(lett) {
			case  'a': case 'e': case 'i': case 'o': case 'u':
				System.out.print(lett + " ");
				break;
			}
		}
		System.out.println();
		
	}
	
	public static void stampaMaiuscole(String[] str) {
		for (int i = 0; i < str.length  ; i++) {
			if((boolean) (str[i].charAt(0) >= 'A' && str[i].charAt(0) <= 'Z' )) {
				System.out.print(str[i] + " ");
			}
		}
		
		System.out.println();
		
	}
	
	public static String reverse(String str) {
		String newStr="";
		for (int i = str.length() - 1 ; i >= 0; i--) {
			newStr += str.charAt(i);
		}
		
		return newStr;
	}

	public static void main(String[] args) {
		String str = "hello World";
		String[] str2 = {"Ciao", "come", "Stai", "?", "Bene"};
		
		System.out.print("solo vocali -> ");
		soloVocali(str);
		
		System.out.print("Stampa maiuscole -> ");
		stampaMaiuscole(str2);
		
		System.out.println("reverse -> " + reverse(str));
		
		
		
		
		
		

	}

}
