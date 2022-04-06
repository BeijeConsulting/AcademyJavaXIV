package it.beije.xiv.esercizi;

import it.beije.xiv.esercizi.corpicelesti.*;

public class Test {

	public static void main(String[] args) {
		CorpoCeleste terra =new Terra(100,365,"Tanti anni");
		CorpoCeleste marte =new Marte(201,"Molti più anni");

		Stella sole =new Sole(101, 365,"Molti ma Molti più anni");
		sole.setListaElementi("Elio", "Ossigeno");

		System.out.println(terra);
		System.out.println(marte);
		System.out.println(sole);

	}

}
