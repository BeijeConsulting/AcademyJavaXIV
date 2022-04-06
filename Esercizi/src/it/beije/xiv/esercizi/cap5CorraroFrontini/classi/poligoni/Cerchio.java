package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.poligoni;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poligono;

public class Cerchio extends Poligono {
	public final static double PI = 3.14;
	private double r;
	
	public Cerchio() {
		this(0.0);
	}
	public Cerchio(double r) {
		super();
		this.r = r;
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public static double getPi() {
		return PI;
	}

	@Override
	public double getPerimetro() {
		return 2*PI*r;
	}

	@Override
	public double getArea() {
		return PI*r*r;
	}

}
