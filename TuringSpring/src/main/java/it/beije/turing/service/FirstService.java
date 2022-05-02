package it.beije.turing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.turing.Contatto;


@Service
public class FirstService {
	
	public List<Contatto> leggiRubrica() {
		
		System.out.println("leggiRubrica..." + this.toString());
		
		Contatto c1 = new Contatto();
		c1.setCognome("Rossi");
		c1.setNome("Mario");
		c1.setTelefono("1234566");
		
		Contatto c2 = new Contatto();
		c2.setCognome("Bianchi");
		c2.setNome("Marco");
		c2.setTelefono("1234568");
		
		List<Contatto> list = new ArrayList<Contatto>();
		list.add(c1);
		list.add(c2);

		return list;
	}

}
