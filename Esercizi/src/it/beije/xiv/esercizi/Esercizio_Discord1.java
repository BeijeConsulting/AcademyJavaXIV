package it.beije.xiv.esercizi;

import java.util.Scanner;

public class Esercizio_Discord1 {

	public static void main(String[] args) {
		// Scrivere un programma che chieda agli utenti due stringhe in ingresso, 
		//le stringhe possono valere solo: “carta”, “forbice” o “sasso”.
		//Il programma dovrà quindi effettuare i dovuti controlli e 
		//dichiarare il vincitore secondo 
		//le note regole della “morra cinese” (forbice vince su carta, carta vince su sasso, sasso vince su forbice):

	
		System.out.print("Giocatore 1 :");
		String eleme1 = salvaElemento();
		System.out.print("Giocatore 2 :");
		String eleme2 = salvaElemento();
		
		morracinese(eleme1, eleme2);
		
	
	
	}


		public static String salvaElemento() {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.print(" Sasso, Carta o Forbice ?  ");
			String parola = in.nextLine();
			if(parola.equals("")) { 
				System.out.println("Operazione da ripetere");
				salvaElemento();
			}
			return parola;
		}
		public static void morracinese(String uno, String due) {
			
			if(uno.equals("Sasso")|| uno.equals("sasso")){
			
				if(due.equals("Carta")|| due.equals("carta")) {
					System.out.println("Vince Giocatore due con Carta");
					}
				if(due.equals("Sasso")|| due.equals("sasso")) {
					System.out.println("Pareggio");
					}
				if(due.equals("Forbice")|| due.equals("forbice")) {
					System.out.println("Vince Giocatore uno con Sasso");
					}
			}
			if( uno.equals("Carta")|| uno.equals("carta")) {
				
				if(due.equals("Carta")|| due.equals("carta")) {
					System.out.println("Pareggio");
					}
				if(due.equals("Sasso")|| due.equals("sasso")) {
					System.out.println("Vince Giocatore uno con Carta");
					}
				if(due.equals("Forbice")|| due.equals("forbice")) {
					System.out.println("Vince Giocatore due con Forbice");
					}
				
				
			}
			
			if (uno.equals("Forbice")||uno.equals("forbice")) {
				if(due.equals("Carta")|| due.equals("carta")) {
					System.out.println("Vince Giocatore uno con Forbice");
					}
				if(due.equals("Sasso")|| due.equals("sasso")) {
					System.out.println("Vince Giocatore 2 con Sasso");
					}
				if(due.equals("Forbice")|| due.equals("forbice")) {
					System.out.println("Pareggio");
					}
			}
		
			
		}
		
}

