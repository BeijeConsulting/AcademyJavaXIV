package it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte;


public abstract class Quadrilatero extends Poligono{
	private double l1,l2,l3,l4;
	
	public Quadrilatero() {
		this(0.0,0.0,0.0,0.0);
	}
	public Quadrilatero(double l1) {
		this(l1,0.0,0.0,0.0);
	}
	public Quadrilatero(double l1, double l2) {
		this(l1,l2,0.0,0.0);
	}
	public Quadrilatero(double l1, double l2, double l3) {
		this(l1,l2,l3,0.0);
	}
	public Quadrilatero(double l1, double l2, double l3, double l4) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}

	public String getName() {
		return "Quadrilatero";
	}
}
