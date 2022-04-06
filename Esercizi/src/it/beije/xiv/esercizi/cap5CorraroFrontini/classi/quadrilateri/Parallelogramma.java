package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Quadrilatero;

public class Parallelogramma extends Quadrilatero {
	private double h;
	public Parallelogramma(double l1, double l2, double l3, double l4, double h) {
		super(l1,l2,l3,l4);
		this.h = h;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getL1()*h;
	}

}
