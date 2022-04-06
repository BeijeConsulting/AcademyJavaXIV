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
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return getL1()*3;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getL1()*getL2();
	}

}
