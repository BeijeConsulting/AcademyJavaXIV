package it.beije.turing.web.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RubricaManager {
	private List<Contatto> allContatti = null;

	public List<Contatto> getAllContatti() {
		return allContatti;
	}

	public void setAllContatti(List<Contatto> allContatti) {
		this.allContatti = allContatti;
	}
// TODO: IMPLEMENTA NELLA SERVLET
	public void printAllContatti() {
		for(Contatto c : allContatti) {
			System.out.println(c);
		}
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void AggiungiContatto(Scanner s) {
		List<Contatto> ris = new ArrayList<>(allContatti);
		Contatto c = new Contatto();
		System.out.println("Inserire Nome:");
		String nome = s.nextLine();
		System.out.println("Inserire Cognome:");
		String cognome = s.nextLine();
		System.out.println("Inserire Telefono:");
		String telefono = s.nextLine();
		System.out.println("Inserire Email:");
		String email = s.nextLine();
		System.out.println("Inserire Note:");
		String note = s.nextLine();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		ris.add(c);
		allContatti = new ArrayList<>(ris);
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void ModificaContatto(Scanner s) {
		List<Contatto> ris = new ArrayList<>(allContatti);

		System.out.println("Lista Contatti Disponibili:");
		int i = 0;
		for(Contatto c : ris) {
			System.out.println("idList: "+i+" "+c);
			i++;
		}
		System.out.println("Inserire numero idList da modificare:");
		String nContatto = s.nextLine();
		try {
			i = Integer.parseInt(nContatto);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un numero valido!");
			nfEx.printStackTrace();
			System.out.println("Quitting...");
			return;
		}
		Contatto c = ris.get(i);
		System.out.println("Inserire Nome:");
		String nome = s.nextLine();
		if(nome.length() == 0 || nome.isEmpty())
			nome = c.getNome();
		System.out.println("Inserire Cognome:");
		String cognome = s.nextLine();
		if(cognome.length() == 0 || cognome.isEmpty())
			cognome = c.getCognome();
		System.out.println("Inserire Telefono:");
		String telefono = s.nextLine();
		if(telefono.length() == 0 || telefono.isEmpty())
			telefono = c.getTelefono();
		System.out.println("Inserire Email:");
		String email = s.nextLine();
		if(email.length() == 0 || email.isEmpty())
			email = c.getEmail();
		System.out.println("Inserire Note:");
		String note = s.nextLine();
		if(note.length() == 0 || note.isEmpty())
			note = c.getNote();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		ris.set(i, c);
		allContatti = new ArrayList<>(ris);
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void EliminaContatto(Scanner s) {
		List<Contatto> ris = new ArrayList<>(allContatti);

		System.out.println("Lista Contatti Disponibili:");
		int i = 0;
		for(Contatto c : ris) {
			System.out.println("idList: "+i+" "+c);
			i++;
		}
		System.out.println("Inserire numero idList da eliminare:");
		String nContatto = s.nextLine();
		try {
			i = Integer.parseInt(nContatto);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un numero valido!");
			nfEx.printStackTrace();
		System.out.println("Quitting...");
			return;
		}
		ris.remove(i);
		allContatti = new ArrayList<>(ris);
	}

	public void EliminaTuttiContatti() {
		List<Contatto> ris = new ArrayList<>(allContatti);
		System.out.println("Eliminazione contatti...");
		for(int i = 0; i < ris.size(); i++) {
			ris.remove(i);
		}
		allContatti =  new ArrayList<>();
		System.out.println("Fatto.");
	}

	public List<Contatto> TrovaContattiDuplicati(Scanner s){
		List<Contatto> ris = new ArrayList<>();
		sort(s);
		for(int i = 0; i + 1 < allContatti.size(); i++) {
			if(allContatti.get(i).equals(allContatti.get(i+1))) {
				ris.add(allContatti.get(i));
				i += 1;
			}
		}
		return ris;
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void UnisciContattiDuplicati(Scanner s) {
		List<Contatto> ris = new ArrayList<>();
		sort(s);
		for(int i = 0; i < allContatti.size(); i++) {
			for(int j = i+1; j < allContatti.size();j++) {
				if(allContatti.get(i).getNome().equals(allContatti.get(j).getNome())
						&& allContatti.get(i).getCognome().equals(allContatti.get(j).getCognome())
						&& allContatti.get(i).getTelefono().equals(allContatti.get(j).getTelefono())
						&& allContatti.get(i).getEmail().equals(allContatti.get(j).getEmail())) {
					continue;
				}
				ris.add(allContatti.get(i));
				i = j-1;
				break;
			}
			if(i+1 >=  allContatti.size()) {
				ris.add(allContatti.get(i));
			}
		}
		allContatti = new ArrayList<>(ris);
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void cercaContatto(Scanner s) {
		System.out.println("Inserire tipo ricerca ((N)ome,(C)ognome,(T)elefono,(E)mail o (A)ll[Ricerca per Nome,Cognome,Telefono e Email][exit per uscire]):");
		String type = null;
		while(type == null || type.isEmpty()) {
			type = s.nextLine();
		}
		if(type.equalsIgnoreCase("exit")) {
			System.out.println("Quitting...");
			return;
		}
		String search = "";
		if(!type.equalsIgnoreCase("A")) {
			System.out.println("Inserire dato da ricercare:");
			search = s.nextLine();
		}
		switch(type.toUpperCase()) {
			case "C":
				for(int i = 0; i < allContatti.size(); i++) {
					if(allContatti.get(i).getCognome() != null && allContatti.get(i).getCognome().contains(search)) {
						System.out.println(allContatti.get(i));
					}
				}
				break;
			case "N":
				for(int i = 0; i < allContatti.size(); i++) {
					if(allContatti.get(i).getNome() != null && allContatti.get(i).getNome().contains(search)) {
						System.out.println(allContatti.get(i));
					}
				}
				break;
			case "T":
				for(int i = 0; i < allContatti.size(); i++) {
					if(allContatti.get(i).getTelefono() != null && allContatti.get(i).getTelefono().contains(search)) {
						System.out.println(allContatti.get(i));
					}
				}
				break;
			case "E":
				for(int i = 0; i < allContatti.size(); i++) {
					if(allContatti.get(i).getEmail() != null && allContatti.get(i).getEmail().contains(search)) {
						System.out.println(allContatti.get(i));
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
				for(int i = 0; i < allContatti.size(); i++) {
					if(allContatti.get(i).getEmail() != null && 
							(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getCognome().contains(cognome) 
								&& allContatti.get(i).getTelefono().contains(telefono) && allContatti.get(i).getEmail().contains(email))) {
						System.out.println(allContatti.get(i));
					}
				}
				break;
			default:
				System.out.println("Illegal search type!");
				System.out.println("Quitting...");
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void swap(List<Contatto> contatti, int i) {
		Contatto tmp = contatti.get(i);
		Contatto tmp2 = contatti.get(i+1);
		contatti.remove(i+1);
		contatti.remove(i);
		contatti.add(i,tmp2);
		contatti.add(i+1,tmp);
	}

	public boolean sort(Scanner s) {
		String type = null;
		while(type == null || type.length() == 0) {
			System.out.println("Inserire ordinamento (N)ome,(C)ognome[digitare exit per uscire]:");
			type = s.nextLine();
		}
		if(type.equalsIgnoreCase("exit")) {
			System.out.println("Quitting...");
			return false;
		}
		boolean swapped = true;
		List<Contatto> ris = new ArrayList<>(allContatti);

		switch(type.toUpperCase().charAt(0)) {
		case 'N':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) >= 0) {
						if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		default:
			System.out.println("Tipo invalido, ordinamento per Cognome.");
		case 'C':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) >= 0) {
						if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		}
		setAllContatti(ris);
		return true;
	}


}
