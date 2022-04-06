package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri.Quadrato;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poliedro;

public class Cubo extends Poliedro {

	public Cubo(Quadrato base)
	{
		this.base=base;
		this.depth=base.getAltezza();
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
		return "Cubo";
	}

}
