package it.beije.xiv.esercizi;
import java.util.Scanner;

public class MorraCinese {
	public static String[] scan() {
		String[] array = new String[2];
		Scanner input = new Scanner(System.in);
		System.out.println("Giocatore 1: ");
		String s1 = input.nextLine();
		while(!s1.equals("sasso") && !s1.equals("carta") && !s1.equals("forbice")) {
	       	System.out.println("Mi serve una parola tra: 'sasso','carta' e 'forbice'");
	       	s1 = input.nextLine();
		}
		array[0] = s1;
		
		System.out.println("Giocatore 2: ");
		String s2 = input.nextLine();
		while(!s2.equals("sasso") && !s2.equals("carta") && !s2.equals("forbice")) {
	       	System.out.println("Mi serve una parola tra: 'sasso','carta' e 'forbice'");
	       	s2 = input.nextLine();
		}
		array[1] = s2;	
	
		return array;
	}
	public static void main(String[]args) {
		String []s = scan();
		String v1 = s[0];
		String v2 = s[1];
		
		if((v1.equals("carta")&& v2.equals("sasso"))||(v1.equals("forbice")&& v2.equals("carta"))|| (v1.equals("sasso")&& v2.equals("forbice"))) {
			System.out.println("vince il giocatore 1: "+v1+" batte "+v2);
		}
		else if((v1.equals("carta")&& v2.equals("forbice"))||(v1.equals("forbice")&& v2.equals("sasso"))|| (v1.equals("sasso")&& v2.equals("carta"))) {
			System.out.println("vince il giocatore 2: "+v2+" batte "+v1);
		}
		else System.out.println("pareggio: "+v1+" uguale a "+v2);
	}
		
}


