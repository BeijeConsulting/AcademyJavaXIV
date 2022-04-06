package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poliedro;
import it.beije.xiv.esercizi.cap5CorraroFrontini.interfacce.Forma2D;

public class Cubo extends Poliedro {

	public Cubo(Forma2D base,double depth)
	{
		this.base=base;
		this.depth=depth;
	}
	
	@Override
	public double getSurface() {
		// TODO Auto-generated method stub
		return base.getPerimetro()*depth;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return base.getArea()*depth;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
