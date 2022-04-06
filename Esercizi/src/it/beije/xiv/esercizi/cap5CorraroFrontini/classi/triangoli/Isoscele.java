package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.triangoli;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;

public class Isoscele extends Triangolo {
	public Isoscele(double l1, double l2) {
		super(l1,l2,l2);
	}
	public String getName() {
		return "Isoscele";
	}

	@Override
	public double getArea() {
		double b = getL1();
		double h = Math.sqrt((Math.pow(getL2(), 2)-Math.pow(b/2, 2)));
		return (b*h)/2;
	}

}
