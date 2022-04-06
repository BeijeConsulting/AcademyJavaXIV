package it.beije.xiv.esercizi;

import it.beije.xiv.esercizi.corpicelesti.*;

public class Test {

	public static void main(String[] args) {
		CorpoCeleste terra =new Terra(100,24,"Tanti anni");
		CorpoCeleste marte =new Marte(160,27,"Molti più anni");
		Stella sole =new Sole(400, 2_000_000,"Molti ma Molti più anni");
		sole.setListaElementi("Elio", "Ossigeno");

		Luna luna =new Luna(50,27,"Più o meno quanto la terra ",(Terra)terra,24);


		System.out.println(terra);
		System.out.println(marte);
		System.out.println(sole);
		System.out.println(luna);

	}

}
