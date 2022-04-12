package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Es1 {
	/* implementate metodi analoghi a questi:
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {...}
	public List<Contatto> loadRubricaFromXML(String pathFile) {...}
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {...}
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) {...}
	naturalmente lascio a voi la gestione di eventuali eccezioni.
	Dopo i metodi base per la scrittura, fate in modo che se indicate un file xml o 
	csv già esistente, i nuovi contatti non vadano a sovrascrivere quelli già presenti, bensì vengano aggiunti 
	in coda*/
	
	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		
		Contatto contatto = null;
		try {
			fileReader = new FileReader(pathFile);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<Contatto>();
			
			while(bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				
				String[] columns = row.split(separator);
				
				contatto = new Contatto();
				
				contatto = new Contatto();
				contatto.setNome(columns[0]);
				contatto.setCognome(columns[1]);
				contatto.setTelefono(columns[2]);
				contatto.setEmail(columns[3]);
				contatto.setNote(columns[4]);
			}
			
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
		}
		
		return contatti;

		
	}
	
	public static void main(String[] args) {
		loadRubricaFromCSV("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/dir/Turing/src/File/temp/rubrica.csv", ";");
		
	}
	

}
