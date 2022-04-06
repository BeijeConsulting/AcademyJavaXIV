package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.triangoli;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;

public class Equilatero extends Triangolo {
	public Equilatero(double l1) {
		super(l1,l1,l1);
	}
	
	public String getName() {
		return "Equilatero";
	}
	
	@Override
	public double getArea() {
		double b = getL1();
		double h = Math.sqrt((Math.pow(getL2(), 2)-Math.pow(b/2, 2)));
		return (b*h)/2;
	}

	@Override
	public double getAltezza() {
		return Math.sqrt((Math.pow(getL2(), 2)-Math.pow(getL1()/2, 2)));
	}

	@Override
	public double getBase() {
		return getL1();
	}

}
