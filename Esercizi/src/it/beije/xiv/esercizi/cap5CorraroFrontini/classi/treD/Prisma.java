package it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD;

import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Poliedro;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.Triangolo;
import it.beije.xiv.esercizi.cap5CorraroFrontini.interfacce.Forma3D;

public class Prisma extends Poliedro implements Forma3D{
	
	public Prisma(Triangolo base,double height) {
		super();
		this.base=base;
		this.height=height;
	}

	@Override
	public double getPerimetro() {
		;
		return base.getPerimetro();
	}

	@Override
	public double getArea() {
		double Area=base.getPerimetro()*height;
		return Area;
	}

	@Override
	public double getVolume() {
		double Volume = base.getArea()*height;
		return Volume;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Prisma";
	}

}
