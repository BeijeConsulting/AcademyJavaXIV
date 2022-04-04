package it.beije.xiv.nardella;

public class PersistenzaMoltiplicativa {

	public static void main(String[] args) {
		System.out.println(persistenza(999));
		System.out.println(persistenza(39));
		System.out.println(persistenza(4932));
		System.out.println(persistenza(1));
		System.out.println(persistenza(84421));
	}

	public static int persistenza(int x) {
		String s = "" + x;
		char[] c = s.toCharArray();
		int z = 1;
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			z *= Character.getNumericValue(c[i]);
		}
		s = "" + z;
		if (s.length() == 1)
			return count;
		else
			count += persistenza(z);
		
		return count;
	}
}
