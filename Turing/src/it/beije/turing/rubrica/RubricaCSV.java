package it.beije.turing.rubrica;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.file.CSVManager;

public class RubricaCSV {
	private List<Contatto> allContact;
	private Path path;
	public RubricaCSV(Path path) {
		this.path = path;
		allContact = CSVManager.readCSV(path.toAbsolutePath().toString());
	}
	
	
	public Contatto creaContatto(Scanner s) {
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
	public void showRubrica() {
		for(Contatto c : allContact) {
			System.out.println(c);
		}
	}
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
			c.setNome(cognome);
		}
		if(!telefono.isBlank() && !telefono.isEmpty()) {
			c.setNome(telefono);
		}
		if(!email.isBlank() && !email.isEmpty()) {
			c.setNome(email);
		}
		if(!note.isBlank() && !note.isEmpty()) {
			c.setNome(note);
		}
		System.out.println(c);
		CSVManager.writeCSV(path.toAbsolutePath().toString(), allContact);
	}
	public void eliminaContatto(Scanner s) {
		Contatto c = cercaContattoModifica(s);
		if(c == null) {
			System.out.println("Contatto non trovato!");
			return;
		}
		
		System.out.println("Contatto eliminato: " + allContact.remove(c));
		CSVManager.writeCSV(path.toAbsolutePath().toString(), allContact);
	}
	private void unisciContattiDuplicati() {
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
		for(Contatto c : ris) {
			System.out.println(c);
		}
		CSVManager.writeCSV(Paths.get("File","rubricaNoDuplicati.csv").toAbsolutePath().toString(), ris);
	}


	private List<Contatto> trovaContattiDuplicati() {
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
		/*
		System.out.println("Contatti duplicati");
		for(Contatto c : ris) {
			System.out.println(c);
		}*/
		return ris;
		
	}

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
	
	public static void main(String[] args) {
		RubricaCSV r = new RubricaCSV(Paths.get("File","rubrica.csv"));
		
		
		Scanner s = new Scanner(System.in);
		String st = "";
		while (!st.equalsIgnoreCase("esci") && !st.equals("8")) {
			System.out.println("Selezionare programma da eseguire:\n"
					+ "1: Mostra tutta la rubrica\n"
					+ "2: Cerca un contatto\n"
					+ "3: Aggiungi un contatto\n"
					+ "4: Modifica contatto\n"
					+ "5: Elimina contatto\n"
					+ "6: Trova contatti duplicati\n"
					+ "7: Unisci contatti duplicati\n"
					+ "8: Esci");
			st = s.nextLine();
			switch(st) {
				case "1":
					r.showRubrica();
					break;
				case "2":
					r.cercaContatto(s);
					break;
				case "3":
					Contatto c = r.creaContatto(s);
					if(c == null)continue;
					List<Contatto> ris = r.getAllContact();
					ris.add(c);
					r.setAllContact(ris);
					CSVManager.writeCSV(r.getPath().toAbsolutePath().toString(), r.getAllContact());
					break;
				case "4":
					r.modificaContatto(s);
					break;
				case "5":
					r.eliminaContatto(s);
					break;
				case "6":
					r.trovaContattiDuplicati();
					break;
				case "7":
					r.unisciContattiDuplicati();
					break;
				case "8":
					continue;
				default:
					break;
			}
			
		}
		
		System.out.println("BYE!!");
		s.close();
	}


	

	
}
