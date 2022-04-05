package it.beije.xiv.eserciziCOM;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Banca {

	ArrayList<Azione> arrayAzioni = new ArrayList<>();
	
	
	public Banca(Scanner scC) throws ParseException {
		
		arrayAzioni = new ArrayList<Azione>();
		
		Azione a = Azione.read(scC);
		arrayAzioni.add(a);
		while(a!=null) {
			arrayAzioni.add(a);
			a = Azione.read(scC);
		}
	
	}



	public ArrayList<Azione> getAzione() {
		return arrayAzioni;
	}

	public void setAzione(ArrayList<Azione> azione) {
		this.arrayAzioni = azione;
	}

	public double totAcquisti(){
		
		double conto = 0;
	
		for(Azione a: arrayAzioni) {
			
			if(a.getOperazione().equalsIgnoreCase("B")) {
				conto += (a.getImporto()*a.getQuanti());
			}
		
		}
		
		return conto;
	}
	
	public double totVendite(){
		
		double conto = 0;
		
		for(Azione a: arrayAzioni) {
			
			if(a.getOperazione().equalsIgnoreCase("S")) {
				conto += (a.getImporto()*a.getQuanti());
			}
		
		}
		
		return conto;
	}
	
	public ArrayList<Azione> riempiArray(Scanner scC) throws ParseException {
		
		ArrayList<Azione> azione = new ArrayList<>();
		
		Azione a = Azione.read(scC);
		azione.add(a);
		while(a!=null) {
			azione.add(a);
			a = Azione.read(scC);
		}
		
		return azione;
	
	}

	
	public void stampaRisultati(int oper, double acquisti, double vendite) {
		System.out.print("OP: "+oper+ " Buy: "+ acquisti + " Sell: "+ vendite);
		
}
}