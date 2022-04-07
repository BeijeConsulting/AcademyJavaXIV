package it.beije.xiv.esercizi;

public class Persistenza {
	public static void main(String []args) {
		Persistenza p = new Persistenza();
		int n = 39;
		
		System.out.print(p.persistenza(n));
	}
	int persistenza(int n) {
		int count = 0;
		
		while((n/10)>0) {
			int cifre = contaCifre(n);
			int incremento = pow(10,cifre);
			int prodotto = 1;
			for(int i=0;i<cifre;i++) {
				prodotto*=(n%incremento)/((incremento/10));
				incremento=incremento/10;
			}
			n = prodotto;
			count++;
		}
		
		return count;
	}
	private int pow(int a, int cifre) {
		int incremento = 1;
		if(cifre == 0) return a;
		else {
			for(int i=0;i<cifre;i++) {
				incremento*=a;
		}
		
		}
		return incremento;
	}
	int contaCifre(int n) {
		int cifre = 1;
		int incremento = 10;
		while(n%incremento != n) {
			cifre+=1;
			incremento*=10;
		}
		
		return cifre;
	}
}
