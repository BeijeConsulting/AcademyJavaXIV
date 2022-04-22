package it.beije.turing.gestione_rubrica_commandline;

import java.util.List;

import it.beije.turing.rubrica.Contatto;

public interface CommandLineInterface {
	
	public void importCSV(String fileName, boolean apici);
	
	public void importXML(String fileName);
	
	public void print();

	public void add(String nome, String cognome, String telefono, String email,String note);

	public void modify(int id, String nome, String cognome, String telefono, String email,String note);

	public void ExportXML(String fileName);

	public List<Contatto> search(String... command);

	public void printOrdered(String string);

	public void delete(String string);

	public void findDuplicates();

	public void mergeContacts(String...indexes);

	public void ExportCSV(String fileName);

	
	
	

}
