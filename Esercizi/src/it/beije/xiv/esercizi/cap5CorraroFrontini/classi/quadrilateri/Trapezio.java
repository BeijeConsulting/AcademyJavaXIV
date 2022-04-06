package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Quadrilatero;

public class Trapezio extends Quadrilatero {
	private double h;
	
	public Trapezio(double bMax, double l2, double bMin, double l4, double h) {
		super(bMax,l2,bMin,l4);
		this.h = h;
	}
	
	public double getBMax() {
		return getL1();
	}
	public double getBMin() {
		return getL3();
	}
	public double getH() {
		return h;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return ((getBMax()+getBMin())*getH())/2;
	}

}
