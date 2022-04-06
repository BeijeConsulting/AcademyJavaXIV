package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.poligoni.Cerchio;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.SolidiRotazione;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;

public class Cono extends SolidiRotazione{
	public Cono(Triangolo figure)
	{
		this.figure=figure;
		this.depth=figure.getAltezza();
		this.base=new Cerchio(figure.getBase());
	}
	@Override
	public double getSurface() {
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
		return "cono";
	}

}
