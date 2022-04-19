package it.beije.turing.newRubrica.rubrica;

import java.util.List;

import it.beije.turing.newRubrica.file.RubricaManager;

public class TestAppHibernate {
	
	public static void main(String[] args) {
		RubricaManager rm = new RubricaManager();
		List<Contatto> allContact = rm.loadRubricaFromHibernate();
		for(Contatto c: allContact) {
			System.out.println(c);
		}
		rm.insertRubricaOnHibernate();
		allContact = rm.loadRubricaFromHibernate();
		for(Contatto c: allContact) {
			System.out.println(c);
		}
		rm.updateRubricaOnHibernate(0);
		allContact = rm.loadRubricaFromHibernate();
		for(Contatto c: allContact) {
			System.out.println(c);
		}
		rm.deleteRubricaOnHibernate(5);
		allContact = rm.loadRubricaFromHibernate();
		for(Contatto c: allContact) {
			System.out.println(c);
		}
		
	}

}
