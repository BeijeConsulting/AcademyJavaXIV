package it.beije.xiv.esercizi;

public class Chimpanzee extends Ape{
	
	static{System.out.println("Chimpanzee static message");}
	{System.out.println("Chimpanzee instance message");}

	public Chimpanzee() {
		System.out.println("Chimpanzee");
	}

	public static void main(String[] args) {
		new Chimpanzee();
		new Chimpanzee();
	}

}
