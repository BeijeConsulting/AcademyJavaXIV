package it.beije.turing.rubrica;

import java.util.List;

import it.beije.turing.rubrica.bean.Contatto;
import it.beije.turing.service.GestoreRubrica;

public interface CommandInterface {
	
	public static CommandInterface getInstance() {
		return GestoreRubrica.getInstance();
		}
	
	//public void importCSV(String fileName, boolean apici);
	
	//public void importXML(String fileName);
	
	public String print();

	public void add(String nome, String cognome, String telefono, String email,String note);

	public void modify(int id, String nome, String cognome, String telefono, String email,String note);

	public List<Contatto> getList();

	public List<Contatto> search(String... command);

	public void printOrdered(String string);

	public void delete(String string);

	public List<Contatto> findDuplicates();

	public void mergeContacts(String...indexes);

	
	
	

}
