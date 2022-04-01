package it.beije.xiv.esercizi.completi;

public class Caffeina {

	public static void main(String[] args) {
			Caffeina.caffeina(2);
	}
	public static void caffeina(int n) {
		boolean div3 = false, div4 = false;
		if(n%3 == 0) {
			System.out.println("Java");
			div3 = true;
		}
		if(n%3 == 0 && n%4 == 0) {
			System.out.println("Coffee");
			div3 = true;
			div4 = true;
		}
		if(n % 2 == 0 && n%3 == 0 && n%4 == 0) {
			System.out.println("Script");
			div3 = true;
			div4 = true;
		}
		if(!div3 && !div4) {
			System.out.println("match_missed!");
		}
	}

}
