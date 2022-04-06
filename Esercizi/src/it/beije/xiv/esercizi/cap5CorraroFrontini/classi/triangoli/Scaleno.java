package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.triangoli;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;

public class Scaleno extends Triangolo {
	private double b, h;
	
	public Scaleno(double l1, double l2, double l3, double h) {
		super(l1,l2,l3);
		this.b = l1;
		this.h = h;
	}
	
	
	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}


	public String getName() {
		return "Scaleno";
	}
	@Override
	public double getArea() {
		return (getB()*getH())/2;
	}


	@Override
	public double getAltezza() {
		return getH();
	}


	@Override
	public double getBase() {
		return getB();
	}

}
