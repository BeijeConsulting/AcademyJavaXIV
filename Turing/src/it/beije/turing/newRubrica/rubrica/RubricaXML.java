package it.beije.turing.newRubrica.rubrica;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.element.Element;

import it.beije.turing.newRubrica.file.RubricaManager;

public class RubricaXML implements Rubrica {
	///////////////////////////////////////////ATTRIBUTI///////////////////////////////////
	private List<Contatto> allContact;
	private Path path;
	private RubricaManager manager;
	
	////////////////////////////////////////COSTRUTTORE////////////////////////////////////
	
	public RubricaXML(Path p) {
		super();
		this.path = p;
		manager = new RubricaManager();
		allContact = manager.loadRubricaFromXML(p.toAbsolutePath().toString());
	}
	
	////////////////////////////////////////GETTER E SETTER////////////////////////////////
	
	public List<Contatto> getAllContact() {
		return allContact;
	}

	public void setAllContact(List<Contatto> allContact) {
		this.allContact = allContact;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	
	/////////////////////////////////////////METODI////////////////////////////////////////
	@Override
	public void caricaFileContatti(Scanner s) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void vediListaContatti() {
		for(Contatto c : allContact) {
			System.out.println(c);
		}

	}

	@Override
	public void cercaContatto(Scanner s) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contatto inserisciNuovoContatto(Scanner s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificaContatto(Scanner s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancellaContatto(Scanner s) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contatto> trovaContattiDuplicati() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unisciContattiDuplicati() {
		// TODO Auto-generated method stub

	}

}
