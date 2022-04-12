package it.beije.turing.newRubrica.rubrica;

import java.util.List;
import java.util.Scanner;

import it.beije.turing.newRubrica.rubrica.Contatto;


public interface Rubrica {
	public abstract void caricaFileContatti(Scanner s);
	public abstract void vediListaContatti();
	public abstract void cercaContatto(Scanner s);
	public abstract Contatto inserisciNuovoContatto(Scanner s);
	public abstract void modificaContatto(Scanner s);
	public abstract void cancellaContatto(Scanner s);
	public abstract List<Contatto> trovaContattiDuplicati();
	public abstract void unisciContattiDuplicati();
}
