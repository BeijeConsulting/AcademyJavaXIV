package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Quadrilatero;

public class Rettangolo extends Quadrilatero {

	public Rettangolo(double l1, double l2) {
		super(l1,l2,l1,l2);
	}
	public double getArea() {
		return getL1()*getL2();
	}
	@Override
	public double getAltezza() {
		return getL2();
	}
	@Override
	public double getBase() {
		return getL1();
	}

}
