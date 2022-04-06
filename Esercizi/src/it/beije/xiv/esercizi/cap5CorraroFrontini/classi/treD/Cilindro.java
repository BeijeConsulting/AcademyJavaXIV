package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.poligoni.Cerchio;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri.Rettangolo;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.SolidiRotazione;

public class Cilindro extends SolidiRotazione{

	public Cilindro(Rettangolo figure)
	{
		this.figure=figure;
		this.depth=figure.getAltezza();
		this.base = new Cerchio();
	}
	@Override
	public double getSurface() {
		return base.getPerimetro()*depth;
	}

	@Override
	public double getVolume() {
		return base.getArea()*depth;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cilindro";
	}

}
