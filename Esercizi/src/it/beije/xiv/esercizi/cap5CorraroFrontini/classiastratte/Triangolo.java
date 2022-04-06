package it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte;


public abstract class Triangolo extends Poligono{
	double l1,l2,l3;
	public Triangolo() {
		this(0.0,0.0,0.0);
	}
	public Triangolo(double l1, double l2, double l3) {
		if((l1+l2 >= l3) && (l1+l3 >= l2) && (l2+l3>=l1)) {
			this.l1 = l1;
			this.l2 = l2;
			this.l3 = l3;
		}else {
			this.l1 = 0.0;
			this.l2 = 0.0;
			this.l3 = 0.0;
		}
		
	}
	public String getName() {
		return "Triangolo";
	}
}
