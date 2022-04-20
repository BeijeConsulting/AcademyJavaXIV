package it.beije.turing;

public class Singleton {
	
	private Singleton() {}
	
	private static Singleton singleton;
	
	public static Singleton getIstance() {
		if (singleton == null) {
			System.out.println("creo oggetto Singleton");
			//...
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
}
