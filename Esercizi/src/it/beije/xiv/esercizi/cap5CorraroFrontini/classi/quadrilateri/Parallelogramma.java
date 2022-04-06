package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Quadrilatero;

public class Parallelogramma extends Quadrilatero {
	private double h;
	public Parallelogramma(double l1, double l2, double h) {
		super(l1,l2,l1,l2);
		this.h = h;
	}
	
	public double getH() {
		return h;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getL1()*h;
	}
	@Override
	public double getAltezza() {
		// TODO Auto-generated method stub
		return getH();
	}
	@Override
	public double getBase() {
		// TODO Auto-generated method stub
		return getL1();
	}

}
