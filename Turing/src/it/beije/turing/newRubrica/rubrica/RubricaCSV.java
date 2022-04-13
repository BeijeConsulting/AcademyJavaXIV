package it.beije.turing.newRubrica.rubrica;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.file.CSVManager;
import it.beije.turing.newRubrica.file.RubricaManager;
import it.beije.turing.newRubrica.rubrica.Contatto;

public class RubricaCSV implements Rubrica {
	private List<Contatto> allContact;
	private Path path;
	private RubricaManager manager;
	///////////////////////////////////////////COSTRUTTORE///////////////////////////////////////
	public RubricaCSV(Path path) {
		this.path = path;
		manager = new RubricaManager();
		allContact = manager.loadRubricaFromCSV(path.toAbsolutePath().toString(),";");
	}
	
	///////////////////////////////////////////GETTER E SETTER///////////////////////////////////////
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
	///////////////////////////////////////////METODI///////////////////////////////////////
	@Override
	public void vediListaContatti() {
		for(Contatto c : allContact) {
			System.out.println(c);
		}
	}
	
	@Override
	public void caricaFileContatti(Scanner s) {
		System.out.println("Inserire il nome del file .csv a cui accedere(senza estensione):");
		String tmp = s.nextLine();
		if(!tmp.isBlank() && !tmp.isEmpty()) {
			if(new File(Paths.get("File",tmp.concat(".csv")).toString()).exists()) {
				setPath(Paths.get("File",tmp.concat(".csv")));
				setAllContact(manager.loadRubricaFromCSV(path.toAbsolutePath().toString(),";"));
				System.out.println("Fatto");
			}
		}
		
	}

	@Override
	public void cercaContatto(Scanner s) {
		System.out.println("Inserire tipo ricerca ((N)ome,(C)ognome,(T)elefono,(E)mail o (A)ll[Ricerca per Nome,Cognome,Telefono e Email]):");
		String type = s.nextLine();
		String search = "";
		if(!type.equals("A")) {
			System.out.println("Inserire dato da ricercare:");
			 search = s.nextLine();
		}
		switch(type.toUpperCase()) {
			case "C":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getCognome() != null && allContact.get(i).getCognome().contains(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "N":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getNome() != null && allContact.get(i).getNome().contains(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "T":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getTelefono() != null && allContact.get(i).getTelefono().contains(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "E":
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getEmail() != null && allContact.get(i).getEmail().contains(search)) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			case "A":
				System.out.println("Inserire nome da ricercare:");
				String nome = s.nextLine();
				System.out.println("Inserire cognome da ricercare:");
				String cognome = s.nextLine();
				System.out.println("Inserire telefono da ricercare:");
				String telefono = s.nextLine();
				System.out.println("Inserire email da ricercare:");
				String email = s.nextLine();
				for(int i = 0; i < allContact.size(); i++) {
					if(allContact.get(i).getEmail() != null && 
							(allContact.get(i).getNome().contains(nome) && allContact.get(i).getCognome().contains(cognome) 
								&& allContact.get(i).getTelefono().contains(telefono) && allContact.get(i).getEmail().contains(email))) {
						System.out.println(allContact.get(i));
					}
				}
				break;
			default:
				System.out.println("Illegal search type!");
		}
		
	}

	@Override
	public Contatto inserisciNuovoContatto(Scanner s) {
		String tmp;
		Contatto c = new Contatto();
		
		System.out.println("Inserire Nome:");
		tmp = s.nextLine();
		if(tmp.isEmpty())
			tmp = "";
		c.setNome(tmp);
		System.out.println("Inserire Cognome:");
		tmp = s.nextLine();
		if(tmp.isEmpty())
			tmp = "";
		c.setCognome(tmp);
		System.out.println("Inserire Telefono:");
		tmp = s.nextLine();
		if(tmp.isEmpty())
			tmp = "";
		c.setTelefono(tmp);
		System.out.println("Inserire Email:");
		tmp = s.nextLine();
		if(tmp.isEmpty())
			tmp = "";
		c.setEmail(tmp);
		System.out.println("Inserire Note:");
		tmp = s.nextLine();
		if(tmp.isEmpty())
			tmp = "";
		c.setNote(tmp);
		if(c.getNome() == "" && c.getCognome() == "" && c.getTelefono() == "" && c.getEmail() == "" && c.getNote() == "") {
			return null;
		}
		return c;
		
	}

	@Override
	public void modificaContatto(Scanner s) {
		Contatto c = cercaContattoModifica(s);
		if(c == null) {
			System.out.println("Contatto non trovato!");
			return;
		}
		System.out.println("Inserire nome modificato:");
		String nome = s.nextLine();
		System.out.println("Inserire cognome modificato:");
		String cognome = s.nextLine();
		System.out.println("Inserire telefono modificato:");
		String telefono = s.nextLine();
		System.out.println("Inserire email modificata:");
		String email = s.nextLine();
		System.out.println("Inserire note modificate:");
		String note = s.nextLine();
		if(!nome.isBlank() && !nome.isEmpty()) {
			c.setNome(nome);
		}
		if(!cognome.isBlank() && !cognome.isEmpty()) {
			c.setCognome(cognome);
		}
		if(!telefono.isBlank() && !telefono.isEmpty()) {
			c.setTelefono(telefono);
		}
		if(!email.isBlank() && !email.isEmpty()) {
			c.setEmail(email);
		}
		if(!note.isBlank() && !note.isEmpty()) {
			c.setNote(note);
		}
		System.out.println(c);
		manager.writeRubricaCSV(allContact, path.toAbsolutePath().toString(), ";");
	}

	@Override
	public void cancellaContatto(Scanner s) {
		Contatto c = cercaContattoModifica(s);
		if(c == null) {
			System.out.println("Contatto non trovato!");
			return;
		}
		
		System.out.println("Contatto eliminato: " + allContact.remove(c));
		manager.writeRubricaCSV(allContact, path.toAbsolutePath().toString(), ";");
		
	}

	@Override
	public List<Contatto> trovaContattiDuplicati() {
		List<Contatto> ris = new ArrayList<Contatto>();
		for(int i = 0; i < allContact.size(); i++) {
			Contatto c = allContact.get(i);
			if(ris.contains(c)) {
				continue;
			}
			CICLE:for(int j = i+1; j < allContact.size(); j++) {
				Contatto k = allContact.get(j);
				if(c.getNome().equals(k.getNome()) && c.getCognome().equals(k.getCognome())) {
					if(!ris.contains(c)) {
						ris.add(c);
					}
					ris.add(k);
				}
				
			}
		}
		
		System.out.println("Contatti duplicati");
		for(Contatto c : ris) {
			System.out.println(c);
		}
		return ris;
	}

	@Override
	public void unisciContattiDuplicati() {
		List<Contatto> source = trovaContattiDuplicati();
		List<Contatto> ris = new ArrayList<>();
		for(int i = 0; i < source.size(); i++) {
			Contatto c = source.get(i);
			for(int j = i+1; j < source.size(); j++) {
				if(c.getTelefono().isEmpty() || c.getTelefono().isBlank()) {
					if(!source.get(j).getTelefono().isEmpty() && !source.get(j).getTelefono().isBlank()) {
						c.setTelefono(source.get(j).getTelefono());
						
						source.remove(j);
					}
				}
				if(c.getEmail().isEmpty() || c.getEmail().isBlank()) {
					if(!source.get(j).getEmail().isEmpty() && !source.get(j).getEmail().isBlank()) {
						c.setEmail(source.get(j).getEmail());
						if(!ris.contains(c)) {
							ris.add(c);
						}
						source.remove(j);
					}
				}
			}
		}
		int i = 1;
		System.out.println("Contatti duplicati uniti: ");
		for(Contatto c : ris) {
			System.out.println(i++ + ": " + c);
		}
		manager.writeRubricaCSV(ris, Paths.get("File","rubricaNoDuplicati.csv").toAbsolutePath().toString(), ";");
		
	}
	
	////////////////////////////////////////Metodi non richiesti//////////////////////////////////
	public Contatto cercaContattoModifica(Scanner s) {
		System.out.println("Inserire nome da ricercare:");
		String nome = s.nextLine();
		System.out.println("Inserire cognome da ricercare:");
		String cognome = s.nextLine();
		System.out.println("Inserire telefono da ricercare:");
		String telefono = s.nextLine();
		System.out.println("Inserire email da ricercare:");
		String email = s.nextLine();
		for(int i = 0; i < allContact.size(); i++) {
			if(allContact.get(i).getEmail() != null && 
					(allContact.get(i).getNome().contains(nome) && allContact.get(i).getCognome().contains(cognome) 
						&& allContact.get(i).getTelefono().contains(telefono) && allContact.get(i).getEmail().contains(email))) {
				System.out.println(allContact.get(i));
				return allContact.get(i);
			}
		}
		return null;
	}
	
}
