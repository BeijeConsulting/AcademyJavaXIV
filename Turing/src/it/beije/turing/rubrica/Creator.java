package it.beije.turing.rubrica;
import java.util.Scanner;

public class Creator {
	
	public static Contatto insert(){
		
		Contatto contatto = new Contatto();
		System.out.println("Inserire NOME contatto:");
		Scanner s = new Scanner(System.in);
		contatto.setNome(s.next());
		System.out.println("Inserire COGNOME contatto:");
		contatto.setCognome(s.next());
		System.out.println("Inserire TELEFONO contatto:");
		contatto.setTelefono(s.next());
		System.out.println("Inserire EMAIL contatto:");
		contatto.setEmail(s.next());
		
		System.out.println("\n"+"Fatto!");
			s.close();
		
		return contatto;
	}
	
	public static void main(String[] args ) {
		
		// System.out.println(insert());
	}
}
