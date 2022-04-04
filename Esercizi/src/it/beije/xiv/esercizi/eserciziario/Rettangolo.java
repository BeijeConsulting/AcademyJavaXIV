package it.beije.xiv.esercizi.eserciziario;

public class Rettangolo {
	private double b, h;
	private double x, y;
	
	public Rettangolo() {
		this(1.0,1.0,0.0,0.0);
	}
	public Rettangolo(double b) {
		this(b,1.0,0.0,0.0);
	}
	public Rettangolo(double b, double h) {
		this(b,h,0.0,0.0);
	}
	public Rettangolo(double b, double h, double x) {
		this(b,h,x,0.0);
	}
	public Rettangolo(double b, double h, double x, double y) {
		this.b = b;
		this.h = h;
		this.x = x;
		this.y = y;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void traslazione(double x, double y) {
		this.x += x;
		this.y += y;
	}
	public double getPerimetro() {
		return (b+h)*2;
	}
	public double getArea() {
		return (b*h);
	}
	public static void main(String[] args) {
		Rettangolo r = new Rettangolo(2,3,0,0);
		System.out.println("Perimetro: " + r.getPerimetro());
		System.out.println("Area: " + r.getArea());
		System.out.println("Expected perimetro: 10.0");
		System.out.println("Expected area: 6.0");
	}

}
