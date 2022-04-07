package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.OlympicSport;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		olympic(new SpeedSkating());
		olympic(new MountainBike());
		olympic(new BMX());
		olympic(new RoadCycling());
		olympic(new ArtisticGymnastic());
	}
	
	public static void olympic(OlympicSport s) {
		System.out.println(s.toString());
		System.out.println();
	}
}
