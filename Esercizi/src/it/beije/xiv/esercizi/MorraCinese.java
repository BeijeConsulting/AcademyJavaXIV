package it.beije.xiv.esercizi;

import java.util.Scanner;

public class MorraCinese {
	public static void main(String[] n) {
		morraCinese();
	}
	
	private static void morraCinese() {
		String str = inserisciMorraCinese("Turno primo giocatore.");
		String str1 = inserisciMorraCinese("Turno secondo giocatore.");
		System.out.println("Il risultato della partita è: " + verificaVincitore(str, str1));
	}

	private static String inserisciMorraCinese(String playerTurn) {
		Scanner scan = new Scanner(System.in);
		String str;
		boolean finito = false;
		
		do {
			System.out.println(playerTurn);
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
		
		if(str.equalsIgnoreCase(str1)) {
			return str2 = "Pareggio";
		} else if (str.equalsIgnoreCase("carta") && str1.equalsIgnoreCase("sasso")) {
			return str2 = "Vince giocatore 1";
		} else if (str.equalsIgnoreCase("sasso") && str1.equalsIgnoreCase("forbice")) {
			return str2 = "Vince giocatore 1";
		} else if(str.equalsIgnoreCase("forbice") && str1.equalsIgnoreCase("carta")) {
			return str2 = "Vince giocatore 1";
		} else {
			return str2 = "Vince giocatore 2";
		}
	}
}

