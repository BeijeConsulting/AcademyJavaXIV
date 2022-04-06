package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.poligoni;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poligono;

public class Pentagono extends Poligono {
	private double l1, l2, l3, l4, l5, apotema;
	
	public Pentagono(double l1, double l2, double l3, double l4, double l5) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}
	
	public double getL1() {
		return l1;
	}

	public void setL1(double l1) {
		this.l1 = l1;
	}

	public double getL2() {
		return l2;
	}

	public void setL2(double l2) {
		this.l2 = l2;
	}

	public double getL3() {
		return l3;
	}

	public void setL3(double l3) {
		this.l3 = l3;
	}

	public double getL4() {
		return l4;
	}

	public void setL4(double l4) {
		this.l4 = l4;
	}

	public double getL5() {
		return l5;
	}

	public void setL5(double l5) {
		this.l5 = l5;
	}

	public double getApotema() {
		return apotema;
	}

	public void setApotema(double apotema) {
		this.apotema = apotema;
	}

	
	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return getL1()+getL2()+getL3()+getL4()+getL5();
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (2*getPerimetro()*getApotema())/2;
	}

	@Override
	public double getAltezza() {
		// TODO Auto-generated method stub
		return getApotema();
	}

	@Override
	public double getBase() {
		// TODO Auto-generated method stub
		return getPerimetro();
	}

}
