package it.beije.xiv.esercizi.completi;

public class Persistenza {

	public static void main(String[] args) {
		System.out.println(Persistenza.persistenza(39));
		System.out.println(Persistenza.persistenza(999));
		System.out.println(Persistenza.persistenza(4));

	}
	public static int persistenza(int num) {
		int ris = 1;
		int tmp = num;
		int a = 0, i = 0;
		if(num <= 9) return 0;
		do {
			if(tmp != num) {
				tmp = ris;
				ris = 1;
			}
			while(tmp != 0) {
				a = tmp % 10;
				tmp /= 10;
				ris *= a;
			}
			i++;
		}while(ris > 9);
		
		return i;
	}
	
}
