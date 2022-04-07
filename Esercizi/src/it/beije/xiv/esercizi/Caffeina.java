package it.beije.xiv.esercizi;

public class Caffeina {
	public static void main(String[]args) {
		Caffeina c = new Caffeina();
		System.out.print(c.caffeina(12));
	}
	String caffeina(int n) {
		String res = "";
		if(n<0) {
			res = "Numero negativo";
		} 
		else if(n%3==0) {
			if(n%4==0) {
				res = "Coffee";
				if(n%2==0) {
					res+= " Script";
				}
			}
			else{
				res = "Java";
				if(n%2==0) {
					res+= " Script";
				}
			}
		}
		else {
			res = "match_missed";
		}
		return res;
	}
}
