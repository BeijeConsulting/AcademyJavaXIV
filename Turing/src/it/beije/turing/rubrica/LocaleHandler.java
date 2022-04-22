package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocaleHandler
{
	public void visualizzaContatti(String filtro, List<Contatto> contatti)
	{
		if (filtro != "") ordinaRubrica(filtro, contatti);
		
		int counter = 1;
		
		for(Contatto contatto : contatti)
		{
			System.out.println(counter++ + " " + contatto.toString());
		}
	}
	
	public void ordinaRubrica(String filtro, List<Contatto> contatti)
	{
		switch(filtro)
		{
			case "nome":
				contatti.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
				break;
				
			case "cognome":
				contatti.sort((o1, o2) -> o1.getCognome().compareTo(o2.getCognome()));
				break;
				
			case "email":
				contatti.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
				break;
				
			case "telefono":
				contatti.sort((o1, o2) -> o1.getTelefono().compareTo(o2.getTelefono()));
				break;
				
			case "note":
				contatti.sort((o1, o2) -> o1.getNote().compareTo(o2.getNote()));
				break;
				
			default:
				return;
		}		
	}
	
	public List<Contatto> cercaContatto(String filtro, List<Contatto> contatti)
	{
		List<Contatto> cont = new ArrayList<>();
		
		for(Contatto contatto : contatti)
		{
			if (contatto.getNome().equals(filtro)) cont.add(contatto);
			else if (contatto.getCognome().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getNote().equals(filtro)) cont.add(contatto);
		}
		
		return cont;
	}
	
	public void modificaContatto(int posizione, List<Contatto> contatti)
	{
		if (posizione >= contatti.size())
		{
			System.out.println("Contatto non presente in rubrica.");
			return;
		}
		
		Contatto contatto = contatti.get(posizione-1);
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Nome: ");
		contatto.setNome(kb.nextLine());
		System.out.println();
		System.out.print("Cognome: ");
		contatto.setCognome(kb.nextLine());
		System.out.println();
		System.out.print("Email: ");
		contatto.setEmail(kb.nextLine());
		System.out.println();
		System.out.print("Telefono: ");
		contatto.setTelefono(kb.nextLine());
		System.out.println();
		System.out.print("Note: ");
		contatto.setNote(kb.nextLine());
		System.out.println();
		
		contatti.set(posizione-1, contatto);
	}
	
	public void cancellaContatto(int posizione, List<Contatto> contatti)
	{
		if (posizione >= contatti.size())
		{
			System.out.println("Contatto non presente in rubrica.");
			return;
		}
		
		contatti.remove(posizione-1);
	}
	
	public List<Contatto> cercaDuplicati(boolean unisci, List<Contatto> contatti)
	{
		List<Contatto> contacts = new ArrayList<>();
		contacts.add(new Contatto("","","","",""));
		
		Contatto contatto = contacts.get(0);
		
		for(int i = 0; i < contatti.size(); i++)
		{
			for(int j = 0; j < contatti.size(); j++)
			{
				if (!unisci)											//TROVA DUPLICATI
				{
					if (i == j) continue;
					if (contatti.get(i).equals(contatti.get(j)))
					{
						contatto.setNome(i+1 + "," + contatto.getNome());
						contacts.add(contatti.get(i));
						break;					
					}
				}
				else													//UNISCI DUPLICATI
				{
					if (i != j && contatti.get(i).equals(contatti.get(j)))
					{
						contatti.remove(j);
						j--;
					}
				}
			}
			
			if (unisci) contacts.add(contatti.get(i));
		}
		
		if (unisci) contacts.remove(0);
		
		return contacts;
	}
}