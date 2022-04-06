package it.beije.xiv.esercizi.cap5CorraroFrontini.classiastratte;


public abstract class Triangolo extends Poligono{
	private double l1,l2,l3;
	public Triangolo() {
		this(0.0,0.0,0.0);
	}
	public Triangolo(double l1) {
		this(l1,0.0,0.0);
	}
	public Triangolo(double l1, double l2) {
		this(l1,l2,0.0);
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
	
	public String getName() {
		return "Triangolo";
	}
}
