package it.beije.turing.newRubrica.rubrica;

import java.nio.file.Path;
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
	public abstract List<Contatto> getAllContact();
	public abstract void setAllContact(List<Contatto> l);
	public abstract Path getPath();
	public abstract void setPath(Path p);
}
