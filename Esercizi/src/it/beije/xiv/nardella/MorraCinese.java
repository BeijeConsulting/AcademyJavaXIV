package it.beije.xiv.nardella;
import java.util.*;

public class MorraCinese {

	public static void main(String[] args) {
		play();

	}
	
	public static void play() {
		Scanner scanner = new Scanner(System.in);
		String playerOne, playerTwo;
		
		do {
			System.out.println("Inserire mossa giocatore 1: ");
			playerOne = scanner.nextLine().trim();
		}while(!isValid(playerOne));
		
		do {
			System.out.println("Inserire mossa giocatore 2: ");
			playerTwo = scanner.nextLine().trim();
		}while(!isValid(playerTwo));
		scanner.close();
		
		if(playerOne.equals(playerTwo)) {
			System.out.println("Patta!");
		}
		else if(playerOne.equals("sasso") && playerTwo.equals("forbici") ||
				playerOne.equals("forbici") && playerTwo.equals("carta") ||
				playerOne.equals("carta") && playerTwo.equals("sasso") ) {
			System.out.println("Vince il giocatore 1");
		}
		else {
			System.out.println("Vince il giocatore 2");
		}
		
	}
	
	public static boolean isValid(String s) {
		if(s.equals("sasso") || s.equals("forbici") || s.equals("carta"))
				return true;
		else 
			return false;
	}

}
