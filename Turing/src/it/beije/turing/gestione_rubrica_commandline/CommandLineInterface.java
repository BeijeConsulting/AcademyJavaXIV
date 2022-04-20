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

	public void search(String[] command);

	public void printOrdered(String string);
	
	

}
