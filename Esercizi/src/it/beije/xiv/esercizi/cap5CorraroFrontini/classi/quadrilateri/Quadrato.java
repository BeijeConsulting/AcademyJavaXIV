package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Quadrilatero;

public class Quadrato extends Quadrilatero {
	public Quadrato(double l1) {
		super(l1,l1,l1,l1);
	}
	
	public String getName() {
		return "Quadrato";
	}
	
	public double getArea() {
		return getL1()*getL1();
	}
	@Override
	public double getAltezza() {
		return getL1();
	}
	@Override
	public double getBase() {
		return getL1();
	}

}
