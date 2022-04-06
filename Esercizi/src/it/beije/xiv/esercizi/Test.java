package it.beije.xiv.esercizi;

import it.beije.xiv.esercizi.cap5CorraroFrontini.interfacce.*;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte.*;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.triangoli.*;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.treD.*;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.quadrilateri.*;
import it.beije.xiv.esercizi.cap5CorraroFrontini.classi.poligoni.*;

public class Test {

	public static void main(String[] args) {
		Forma f1 = new Quadrato(2.0);
		Forma f2 = new Cilindro(new Rettangolo(2.0,1.0));
		
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		
		Quadrato f3 = new Quadrato(1.0);
		Cubo f4 = new Cubo(new Quadrato(1.0));
		
		System.out.println(f3.getName());
		System.out.println(f3.getPerimetro());
		System.out.println(f3.getArea());
		
		System.out.println(f4.getName());
		System.out.println(f4.getSurface());
		System.out.println(f4.getVolume());
		
		Poligono f5 = new Pentagono(1, 1, 1, 1, 1,1);
		SolidiRotazione f6 = new Cono(new Equilatero(3.0));
		Poligono f7 = new Cerchio(1);
		
		System.out.println(f5.getName());
		System.out.println(f5.getPerimetro());
		System.out.println(f5.getArea());
		
		System.out.println(f6.getName());
		System.out.println(f6.getSurface());
		System.out.println(f6.getVolume());
		
		System.out.println(f7.getName());
		System.out.println(f7.getPerimetro());
		System.out.println(f7.getArea());
	}

}
