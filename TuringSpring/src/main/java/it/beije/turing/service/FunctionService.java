package it.beije.turing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAcriteriaService;
import it.beije.turing.service.JPAmanagerService;

public class FunctionService {
	public static boolean areEqual(Contatto c, Contatto c1) {
		Contatto contatto = new Contatto();
		
		contatto.setId(c.getId());
		
		if(c.getNome() == null & c1.getNome() == null) {
			contatto.setNome("true");
		} else if(c.getNome() == null | c1.getNome() == null) {
			contatto.setNome("false");
		} else if(c.getNome().equals(c1.getNome())) {
			contatto.setNome("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getCognome() == null & c1.getCognome() == null) {
			contatto.setCognome("true");
		} else if(c.getCognome() == null | c1.getCognome() == null) {
			contatto.setCognome("false");
		} else if(c.getCognome().equals(c1.getCognome())) {
			contatto.setCognome("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getEmail() == null & c1.getEmail() == null) {
			contatto.setEmail("true");
		} else if(c.getEmail() == null | c1.getEmail() == null) {
			contatto.setEmail("false");
		} else if(c.getEmail().equals(c1.getEmail())) {
			contatto.setEmail("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getTelefono() == null & c1.getTelefono() == null) {
			contatto.setTelefono("true");
		} else if(c.getTelefono() == null | c1.getTelefono() == null) {
			contatto.setTelefono("false");
		} else if(c.getTelefono().equals(c1.getTelefono())) {
			contatto.setTelefono("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getDataDiNascita() == null & c1.getDataDiNascita() == null) {
			contatto.setDataDiNascita("true");
		} else if(c.getDataDiNascita() == null | c1.getDataDiNascita() == null) {
			contatto.setDataDiNascita("false");
		} else if(c.getDataDiNascita().equals(c1.getDataDiNascita())) {
			contatto.setDataDiNascita("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getIndirizzo() == null & c1.getIndirizzo() == null) {
			contatto.setIndirizzo("true");
		} else if(c.getIndirizzo() == null | c1.getIndirizzo() == null) {
			contatto.setIndirizzo("false");
		} else if(c.getIndirizzo().equals(c1.getIndirizzo())) {
			contatto.setIndirizzo("true");
		} else {
			contatto.setNome("false");
		}
		
		if(c.getNote() == null & c1.getNote() == null) {
			contatto.setNote("true");
		} else if(c.getNote() == null | c1.getNote() == null) {
			contatto.setNote("false");
		} else if(c.getNote().equals(c1.getNote())) {
			contatto.setNote("true");
		} else {
			contatto.setNome("false");
		}
		return contatto.getNome().equals("true") && contatto.getCognome().equals("true") && contatto.getTelefono().equals("true") && contatto.getEmail().equals("true") && contatto.getDataDiNascita().equals("true") && contatto.getIndirizzo().equals("true") && contatto.getNote().equals("true");
	}
	
	public static List<Contatto> trovaContattiDuplicati() {
		Contatto contattoDup = null;
		List<Contatto> contatti = JPAcriteriaService.getRubrica();
		List<Contatto> contattiDup = new ArrayList<Contatto>();
		
		for(Contatto c : contatti) {
			for(Contatto c1 : contatti) {
				if(c.getId() != c1.getId()) {
					if(areEqual(c, c1)) {
						contattoDup = c1;
						if(contattiDup.size() == 0) {
							contattiDup.add(contattoDup);
						} else if(areEqual(contattoDup, contattiDup.get(0))) {
							contattiDup.add(contattoDup);
						}
					}
				}
			}
		}
		
		return contattiDup;
	}
	
	public static void unisciContattiDuplicati(Scanner s) {
		List<Contatto> contattiDup = trovaContattiDuplicati();
		
		if(contattiDup.size() > 0) {
			int x = 0;
			do {
				System.out.print("\nVuoi unire i contatti duplicati? (Si/No): ");
				String confirm = s.next().toLowerCase();
				
				if(confirm.equals("si")) {
					while(contattiDup.size() > 1) {
						JPAmanagerService.deleteContattoRubrica(contattiDup.get(0).getId());
						contattiDup.remove(0);
					}
					x++;
				} else if(confirm.equals("no")) {
					x++;
				}
			} while(x == 0);
		} else {
			System.out.println("Nessun contatto e' stato duplicato.");
		}
	}

}
