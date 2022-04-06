package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poliedro;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;
import it.beije.xiv.esercizi.cap5CorraroFrontini.interfacce.Forma3D;

public class Prisma extends Poliedro implements Forma3D{
	
	public Prisma(Triangolo base,double height) {
		super();
		this.base=base;
		this.depth=height;
	}

	
	@Override
	public double getSurface() {
		double Area=base.getPerimetro()*depth;
		return Area;
	}

	@Override
	public double getVolume() {
		double Volume = base.getArea()*depth;
		return Volume;
	}

	@Override
	public String getName() {
		return "Prisma";
	}

}
