package it.beije.xiv.esercizi.eserciziario;

import java.util.Random;

public class Dado {
	private int nFacce;
	private Random gen;
	
	public Dado() {
		nFacce = 6;
		gen = new Random(System.currentTimeMillis());
	}
	public int getnFacce() {
		return nFacce;
	}
	public void setnFacce(int nFacce) {
		this.nFacce = nFacce;
	}
	public int lancia() {
		int result = gen.nextInt(nFacce) + 1;
		return result;
	}
	public static void main(String[] args) {
		Dado d = new Dado();
		System.out.println(d.lancia());
	}
}
