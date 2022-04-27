package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubrica {
	
	ArrayList<Contatto> contatti = new ArrayList<Contatto>(); 

	
	
	
	
	
/////////////////////////////////////////		FILE SORGENTE 			///////////////////////////////////////////////////////////////////	
	
	public static String fileSorgente() {
		
		Scanner in = new Scanner(System.in);
	
		System.out.println("Inserisci la directory del file da importare (File Compreso) : ");
		String dir = in.nextLine();
		if(dir.equals("")) { 
		System.out.print("directory non valida");
		}
		return dir;
	}
	
/////////////////////////////////////////		AGGIUNGI 			///////////////////////////////////////////////////////////////////////
	
	public void Aggiungi() {
		
		//this.contatti.add(Contatto.read());
		
	}
	
/////////////////////////////////////////		read CSV			///////////////////////////////////////////////////////////////////	
	
	
	public static ArrayList<Contatto> readCSV(String csvPath) throws IOException{
		
		ArrayList<Contatto> contattiImportati = new ArrayList<Contatto>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		
		try {
			
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			
			String riga = bufferedReader.readLine();
			// System.out.println(riga);
			
				while (bufferedReader.ready()) {
					
					riga = bufferedReader.readLine();
					Contatto contatto = leggiRiga(riga);
					contattiImportati.add(contatto);
					System.out.println(" "+contatto.getNome()+ " aggiunto in rubrica");
					}
				
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
			
			System.out.println("Contatti: " + contattiImportati.size());
			return contattiImportati;
		
	}
	
/////////////////////////////////////////		Leggi Riga		///////////////////////////////////////////////////////////////////		
	
	
	public ArrayList<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(ArrayList<Contatto> contatti) {
		this.contatti = contatti;
	}

	public static Contatto leggiRiga(String riga) {
		
		String[] columns = riga.split(";");
		String nome, cognome, telefono, email;
		
		try {cognome = (columns[0]);}
		catch(ArrayIndexOutOfBoundsException e) { cognome = ""; }
		
		try { nome = (columns[1]);}
		catch(ArrayIndexOutOfBoundsException e) { nome = ""; }
					
		try {telefono = (columns[2]);}
		catch(ArrayIndexOutOfBoundsException e) { telefono = ""; }
		
		try {email = (columns[0]);}
		catch(ArrayIndexOutOfBoundsException e) { email = ""; }
		
		//return new Contatto(nome, cognome, telefono, email);
		return null;
	}

/////////////////////////////////////////		Cambia Nome Cognome			///////////////////////////////////////////////////////////////////				
	public void cambiaNomeCognome(Contatto i) {
		
		String temp = i.getCognome();
		i.setCognome(i.getNome());
		i.setNome(temp);
		
	}

/////////////////////////////////////////		CERCA 		///////////////////////////////////////////////////////////////////	
	
	public void cerca() {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
		
		System.out.println("Inserisci elemento da cercare: ");
		String elemento = in.nextLine();
		
		
		System.out.println("Inserisci tipo di elemento da cercare: ");
		System.out.println("1. Nome ");
		System.out.println("2. Cognome ");
		System.out.println("3. Numero ");
		System.out.println("4. Email  ");
		
		String scelta = in.nextLine();
		if(scelta.equals("")) { 
		System.out.print("directory non valida");
		}
		
		System.out.println("Bene");
		
		switch(scelta) {
		
			case "1" :
				System.out.println(" I Risutati sono: ");
				contattiTrovati = filtraPerNome(elemento);
				stampa(contattiTrovati);
				break;
				
			case "2" :
				
				System.out.println(" I Risutati sono: ");
				contattiTrovati = filtraPerCognome(elemento);
				stampa(contattiTrovati);
				break;
				
			case "3" :
				System.out.println(" I Risutati sono: ");
				contattiTrovati = filtraPerTelefono(elemento);
				stampa(contattiTrovati);
				break;
			
			case "4" :
				
				System.out.println(" I Risutati sono: ");
				contattiTrovati = filtraPerEmail(elemento);
				stampa(contattiTrovati);
				break;
			default :
				
				System.out.println("Indice sbagliato");
				
		}
		
		
		
		
		
		
		
	}

/////////////////////////////////////////		FILTRA PER  EMAIL 			///////////////////////////////////////////////////////////////////		
	
private ArrayList<Contatto> filtraPerEmail(String elemento) {
	
	ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
	
	for( Contatto c : contatti) {
		
		if(c.getEmail().equals(elemento)) {
			contattiTrovati.add(c);
		}	
	}
	
	return contattiTrovati;
}


//////////////////////////////////////		FILTRA PER TELEFONO	 ///////////////////////////////////////	

private ArrayList<Contatto> filtraPerTelefono(String elemento) {
	
		ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
		
		for( Contatto c : contatti) {
			
			if(c.getTelefono().equals(elemento)) {
				contattiTrovati.add(c);
			}	
		}
		
		return contattiTrovati;
	}
	

////////////////////////////////////// FILTRA PER NOME //////////////////////////////////////////////////////////////////////////

	private ArrayList<Contatto> filtraPerNome(String elemento) {
		
		ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
		
		for( Contatto c : contatti) {
			
			if(c.getNome().equals(elemento)) {
				contattiTrovati.add(c);
			}	
		}
		
		return contattiTrovati;
	}
		
////////////////////////////////////////	 FILTRA PER COGNOME			 ////////////////////////////////////////////////////////////////////////////////
	
	private ArrayList<Contatto> filtraPerCognome(String elemento) {
		
		ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
		
		for( Contatto c : contatti) {
			
			if(c.getCognome().equals(elemento)) {
				contattiTrovati.add(c);
			}	
		}
		
		return contattiTrovati;
	}
	
////////////////////////////////////////		STAMPA RUBRICA		 ////////////////////////////////////////////////////////////////////////////////
	
	public void stampa(ArrayList<Contatto> ciao) {
		
		for(Contatto c : ciao) {
			//c.stampa();
		}
		
	}
	
	public void sostituisci(ArrayList<Contatto> datiImportati) {

		this.contatti = datiImportati; 
		
	}
}
