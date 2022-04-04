package it.beije.xiv.esercizi.eserciziario;

public class Ercole {

	public static void main(String[] args) {
		String name = "Ercole";
		System.out.print("+ ");
		for(int i = 0; i < name.length()/2; i++) {
			System.out.print("- ");
		}
		
		System.out.println(" +");
		System.out.println("| "+name+" |");
		System.out.print("+ ");
		for(int i = 0; i < name.length()/2; i++) {
			System.out.print("- ");
		}
		System.out.println(" +");

	}

}
