package it.beije.xiv.esercizi;

import java.util.Scanner;

public class MorraCinese {
	public static void main(String[] n) {
		morraCinese();
	}
	
	private static void morraCinese() {
		System.out.println("Turno primo giocatore.");
		String str = inserisciMorraCinese();
		System.out.println("Turno secondo giocatore.");
		String str1 = inserisciMorraCinese();
		System.out.println("Il risultato della partita è: " + verificaVincitore(str, str1));
	}

	private static String inserisciMorraCinese() {
		Scanner scan = new Scanner(System.in);
		String str;
		boolean finito = false;
		
		do {
			System.out.println("Inserisci carta, forbice o sasso: ");
			str = scan.nextLine();
			if(str.equalsIgnoreCase("carta") || str.equalsIgnoreCase("forbice") || str.equalsIgnoreCase("sasso")) {
				finito = true;
			} else {
				System.out.println("Puoi inserire solo carta, forbice o sasso.");
			}
		}while(!finito);
		return str;
	}
	
	private static String verificaVincitore(String str, String str1) {
		String str2;
		boolean vinceGiocatore1 = false;
		if(str.equalsIgnoreCase(str1)) {
			return str2 = "Pareggio";
		} else if (str.equalsIgnoreCase("carta")) {
			if(str1.equalsIgnoreCase("sasso")) {
				vinceGiocatore1 = true;
			}
		} else if (str.equalsIgnoreCase("sasso") ) {
			if(str1.equalsIgnoreCase("forbice")) {
				vinceGiocatore1 = true;
			}
		} else {
			if(str1.equalsIgnoreCase("carta")) {
				vinceGiocatore1 = true;
			}
		}
		if(vinceGiocatore1) {
			return str2 = "Vince giocatore 1";
		} else {
			return str2 = "Vince giocatore 2";
		}
	}
}

