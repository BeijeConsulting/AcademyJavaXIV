package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.OlympicSport;
import it.beije.xiv.esercizi.giochiOlimpici.SummerOlympicGame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		olympic(new SpeedSkating());
		olympic(new MountainBike());
		olympic(new BMX());
		olympic(new RoadCycling());
	}
	
	public static void olympic(OlympicSport s) {
		System.out.println(s.toString());
		System.out.println();
	}

}
