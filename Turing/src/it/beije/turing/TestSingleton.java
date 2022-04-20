package it.beije.turing;

public class TestSingleton {

	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getIstance();
		System.out.println(singleton);
		singleton = Singleton.getIstance();
		System.out.println(singleton);
		singleton = Singleton.getIstance();
		System.out.println(singleton);
		singleton = Singleton.getIstance();
		System.out.println(singleton);
		singleton = Singleton.getIstance();
		System.out.println(singleton);

	}

}
