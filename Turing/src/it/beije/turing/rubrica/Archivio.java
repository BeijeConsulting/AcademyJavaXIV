package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
	
	public static void main(String[] args) {
		Archivio a = new Archivio();
		//a.eseguiCVS();
		a.eseguiXML();
	}
	
	private void eseguiXML() {
		List<Contatto> lista = new ArrayList<Contatto>();
		LetturaXML l = new LetturaXML();
		l.getLetturaXML("C:\\Users\\aless\\Desktop\\test\\rubrica.xml", lista);
		ScritturaXML s = new ScritturaXML();
		s.getScriviXML("C:\\Users\\aless\\Desktop\\test\\rubricaAlePa.xml", lista);
	}

	public void eseguiCVS() {
		List<Contatto> lista = new ArrayList<Contatto>();
		LetturaCVS l = new LetturaCVS();
		lista = l.getLetturaCVS("C:\\Users\\aless\\Desktop\\test\\rubrica.csv", lista , ";");
		//l.getLetturaCVS("C:\\Users\\aless\\Desktop\\test\\provaScrittura.csv", lista , ";");
//		l.getLetturaCVS("C:\\Users\\aless\\Desktop\\test\\provaAlepa.csv", lista , ";");
//		l.getLetturaCVS("C:\\Users\\aless\\Desktop\\test\\provaAlepaVirgola.csv", lista , ",");
		
		
		ScritturaCVS s = new ScritturaCVS();
		//s.getScrittursCVS("C:\\Users\\aless\\Desktop\\test\\provaScrittura.csv");
//		s.getScrittursCVS(lista , "C:\\Users\\aless\\Desktop\\test\\provaAlepa.csv" , ";");
//		s.getScrittursCVS(lista , "C:\\Users\\aless\\Desktop\\test\\provaAlepaVirgola.csv" , ",");
		s.getScrittursCVS(lista, "C:\\\\Users\\\\aless\\\\Desktop\\\\test\\\\provaAlePa.csv", ";");
	}

}
