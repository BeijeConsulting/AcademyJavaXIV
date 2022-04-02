package it.beije.xiv.esercizi.completi;

public class ShadesOfGrey {
	static String[] shadesOfGrey(int num) {
		String[] ris = new String[num];
		if(num <= 0 || num >= 255) {
			return null;
		}
		for(int i = 0; i < num; i++) {
			if(i<15) {
				ris[i] = "#" + Integer.toHexString(0) +Integer.toHexString(i+1) + Integer.toHexString(0) + Integer.toHexString(i+1) + Integer.toHexString(0) + Integer.toHexString(i+1);
			}else {
				ris[i] = "#" + Integer.toHexString(i+1) + Integer.toHexString(i+1) + Integer.toHexString(i+1);
			}
		}
		return ris;
	}
	public static void main(String[] args) {
		int i = 1;
		for(String s : ShadesOfGrey.shadesOfGrey(254)) {
			System.out.println(i + ": " + s);
			i++;
		}
	}
}
