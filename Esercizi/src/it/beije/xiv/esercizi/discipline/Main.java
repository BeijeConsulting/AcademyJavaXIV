package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.OlympicSport;
import it.beije.xiv.esercizi.giochiOlimpici.SummerOlympicGame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		olympic(new SpeedSkating());
	}
	
	public static void olympic(OlympicSport s) {
		System.out.println(s.toString());
	}

}
