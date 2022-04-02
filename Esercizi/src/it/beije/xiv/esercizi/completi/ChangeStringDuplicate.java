package it.beije.xiv.esercizi.completi;

public class ChangeStringDuplicate {

	public static void main(String[] args) {
		System.out.println("din");
		System.out.println(ChangeStringDuplicate.changeString("din"));
		System.out.println("recede");
		System.out.println(ChangeStringDuplicate.changeString("recede"));
		System.out.println("Success");
		System.out.println(ChangeStringDuplicate.changeString("Success"));
		System.out.println("(( @");
		System.out.println(ChangeStringDuplicate.changeString("(( @" ));

	}
	public static String changeString(String s) {
		String str = s;
		for(int i = 0; i < s.length(); i++) {
			if(s.substring(i+1).toLowerCase().contains(s.toLowerCase().charAt(i) + "")) {
				str = str.toString().replace(s.charAt(i), ')');
			}else {
				str = str.toString().replace(s.charAt(i), '(');
			}
		}
		
		return str;
	}

}
