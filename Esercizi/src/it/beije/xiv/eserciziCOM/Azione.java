package it.beije.xiv.eserciziCOM;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;

public class Azione {
	
	private String azione;
	private double importo;
	private double quanti;
	private String operazione;
	
	
	public Azione(String azione, double importo, double quanti, String operazione) {
	
		this.azione = azione;
		this.importo = importo;
		this.quanti = quanti;
		this.operazione = operazione;
		
	}
	
	public String getAzione() {
		return azione;
	}
	public void setAzione(String azione) {
		this.azione = azione;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public double getQuanti() {
		return quanti;
	}
	public void setQuanti(double quanti) {
		this.quanti = quanti;
	}
	public String getOperazione() {
		return operazione;
	}
	public void setOperazione(String operazione) {
		this.operazione = operazione;
	}
	
	public static Azione read(Scanner scC) throws ParseException {

		if(!scC.hasNext()) {return null;}
		String azione = scC.next();
		//System.out.print(" " + azione);
		if(!scC.hasNext()) {return null;}
		String i= scC.next();
		double importo = Double.parseDouble(i);
		//System.out.print(" "+ i);
		if(!scC.hasNext()) {return null;}
		String q = scC.next();
		double quanti = Double.parseDouble(q);
		//System.out.print(" "+ q);
		if(!scC.hasNext()) {return null;}
		String operazione = scC.next();
		//System.out.print("  " + azione + " "+  importo + " "+  quanti + " "+ operazione + " ");
		return new Azione(azione, importo, quanti, operazione);
		
	}

		public void print(PrintStream ps){
			ps.println(azione);
			ps.println(importo);
			ps.println(quanti);
			ps.println(operazione);
}
		
		
}
