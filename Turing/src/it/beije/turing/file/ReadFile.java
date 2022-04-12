package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class ReadFile {	
	
	public static void main(String[] args) {
		List<Contatto> contatti = loadRubricaFromCSV("/Users/simonepitossi/File/newContatti.csv", ";");
		for (Contatto c: contatti) {
			System.out.println(c.toString());
		}
		
	}

	public static void readFileList(File[] fL) {
		
		for(File f : fL) {
			if(f.isFile() && !f.getName().equalsIgnoreCase(".DS_Store")) {
				System.out.println(f.getName() + "\n");
				readFile(f);
			} else if(f.isDirectory()) {
				readFileList(f.listFiles());
			}
		}
	}
	
	public static void readFile(File file) {
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			while(bufferReader.ready()) {
				System.out.println(bufferReader.readLine() + "\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferReader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
		List<Contatto> contatti = new ArrayList<>();
		ArrayList<String> s = new ArrayList<>();
		File file = new File(pathFile);
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		boolean primaLinea = true;
		
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			while(bufferReader.ready()) {
				String riga = bufferReader.readLine();
				String[] campiStringa = riga.split(separator);
				
				if(primaLinea) {
					primaLinea = false;
					individuaColonneCSV(s, campiStringa);
					separator = csvContieneVirgolette(riga, separator); 
				} else {
					contatti.add(Contatto.creaContatto(s, campiStringa));
				}	
			}
	
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return contatti;
	}

	

	public static void individuaColonneCSV(ArrayList<String> s, String[] individuaCampi) {
		for(String stringa :individuaCampi) {
			switch(stringa.toLowerCase()) {
				case "nome":
					s.add("nome");
					break;
				case "cognome":
					s.add("cognome");
					break;
				case "telefono":
					s.add("telefono");
					break;
				case "email":
					s.add("email");
					break;
				case "note":
					s.add("note");
					break;
				default:
					break;
			}
		}
	}

	public static String csvContieneVirgolette(String campi, String separator) {
		boolean campiTraVirgolette = false;
		String[] individuaCampi = campi.split(";");
		
		switch(individuaCampi[0].toLowerCase()) {
		case "\"nome\"":
			campiTraVirgolette = true;
		case "\"cognome\"":
			campiTraVirgolette = true;
		case "\"telefono\"":
			campiTraVirgolette = true;
		case "\"email\"":
			campiTraVirgolette = true;
		case "\"note\"":
			campiTraVirgolette = true;
		default:
			break;
		}
		
		if(campiTraVirgolette) {
			return "\"" + separator + "\"";
		} else {
			return separator;
		}
	}

}
