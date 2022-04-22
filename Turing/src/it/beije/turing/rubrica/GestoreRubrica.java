package it.beije.turing.rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.ModificationItem;

import it.beije.turing.db.DbInterface;
import it.beije.turing.db.JPA_Manager_Criteria;
import it.beije.turing.file.Writer;
import it.beije.turing.file.csv.CSVReader;
import it.beije.turing.gestione_rubrica_commandline.CommandLineInterface;

public class GestoreRubrica implements CommandLineInterface {
private static final String BASE_RUBRIC="tmp/Test.txt";
private static GestoreRubrica self;
private DbInterface db;

private GestoreRubrica()
{
	db=new JPA_Manager_Criteria();
	
}


public static GestoreRubrica getInstance()
{
	if(self==null)
	{
		self=new GestoreRubrica();
	}
	return self;
}


public void importCSV(String fileName, boolean apici) {
 List<Contatto> tmp = CSVReader.readCSV(fileName, apici);
 for(Contatto c : tmp)
 {
	db.insertContatti(c);
 }
	}
public void ExportCSV(String fileName)
{
	File file = new File(fileName);
	if(!file.exists())
	{
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("error in creating file");
			e.printStackTrace();
		}
	}
	StringBuilder content= new StringBuilder();
	RubricaInterpreteCSV CSV = new RubricaInterpreteCSV();
	for(Contatto c: db.getContatti())
	{
		content.append(CSV.toCSV(c));
		content.append("\n");
	}
	Writer.Write(fileName, content.toString());
}

public void print()
{
	for(Contatto c : db.getContatti())
	{
		System.out.println(c.getId()+")  "+c);
	}
}



public void add(String nome, String cognome, String telefono, String email,String note)
{
	Contatto c = new Contatto();
	if(!nome.equalsIgnoreCase("X"))
	{
		c.setNome(nome);
	}
	if(!cognome.equalsIgnoreCase("X"))
	{
		c.setCognome(cognome);
	}
	if(!telefono.equalsIgnoreCase("X"))
	{
		c.setTelefono(telefono);
	}
	if(!email.equalsIgnoreCase("X"))
	{
		c.setEmail(email);
	}
	if(!note.equalsIgnoreCase("X"))
	{
		c.setNote(note);
	}
	
	db.insertContatti(c);
	
}

public void modify(int x,String nome, String cognome, String telefono, String email,String note) {
	Contatto c = db.getContatto(x);
	if(c!=null) {
	if(!nome.equalsIgnoreCase("X"))
	{
		c.setNome(nome);
	}
	if(!cognome.equalsIgnoreCase("X"))
	{
		c.setCognome(cognome);
	}
	if(!telefono.equalsIgnoreCase("X"))
	{
		c.setTelefono(telefono);
	}
	if(!email.equalsIgnoreCase("X"))
	{
		c.setEmail(email);
	}
	if(!note.equalsIgnoreCase("X"))
	{
		c.setNote(note);
	}
	db.updateContatti(c);
	}
}


public void ExportXML(String fileName)
{
	new RubricaInterpreteXML().ExportXML(db.getContatti(), fileName);
}


public void importXML(String fileName)
{
	List<Contatto> tmp = new ArrayList<>();
	tmp= new RubricaInterpreteXML().importXML(fileName);
	for(Contatto c : tmp)
	{
		db.insertContatti(c);
	}
}


@Override
public List<Contatto> search(String... command) {
	StringBuilder query = new StringBuilder(" ");
	for(int i=0;i<command.length;i+=2)
	{
		int end = query.length()-1;
		query.append(command[i]+"='"+command[i+1]+"' ");	
		if(i!=0)
		{
			query.insert(end, ",");
		}
	}
	try {
	return db.search(query.toString());
	}
	catch(IllegalArgumentException e){
		System.out.println("si è verificato un errore nei parametri, verifica che siano inseriti correttamente.");
		return new ArrayList<Contatto>();
	}
}


@Override
public void printOrdered(String string) {
	int lineCounter=0;
	for(Contatto c : db.getOrdered(string))
	{
		System.out.println(++lineCounter+") "+c);
	}
	
}


@Override
public void delete(String string) {
	db.delete(Integer.parseInt(string));
	
}


@Override
public void findDuplicates() {
	List<Contatto> dupes = new ArrayList<>();
	List<Contatto> list = db.getContatti();
	for(Contatto c : list)
	{
		int index=list.indexOf(c)+1;
		for(;index<list.size();index++)
		{
			Contatto dupe = list.get(index);
			if(c.equals(dupe))
			{
				if(!dupes.contains(dupe))
				dupes.add(dupe);
				if(!dupes.contains(c))
					dupes.add(c);
			}
		}
		
	}
	
	if(dupes.isEmpty())
	{
		System.out.println("no duplicates found.");
	}
	else
		for(Contatto d : dupes)
	 {
		 System.out.println(d);
	 }
}


@Override
public void mergeContacts(String... ids) {
	List<Contatto> dupes = new ArrayList<Contatto>();
	for(String i : ids)
	{
		if(i.equalsIgnoreCase("merge"))
		{
			continue;
		}
		dupes.add(search("x","id",i).get(0));
	}
	Contatto c=dupes.get(0);
	for(Contatto d: dupes)
	{
		if(!c.equals(d))
		{
			System.out.println("contatti non duplicati");
			return;
		}
	}
	if(c.getNome()==null)
	{
		for(Contatto d : dupes)
		{
			if(d.getNome()!=null)
			{
				c.setNome(d.getNome());
			}
		}
	}
	
	if(c.getCognome()==null)
	{
		for(Contatto d : dupes)
		{
			if(d.getCognome()!=null)
			{
				c.setCognome(d.getCognome());
			}
		}
	}
	
	if(c.getTelefono()==null)
	{
		for(Contatto d : dupes)
		{
			if(d.getTelefono()!=null)
			{
				c.setTelefono(d.getTelefono());
			}
		}
	}
	
	if(c.getEmail()==null)
	{
		for(Contatto d : dupes)
		{
			if(d.getEmail()!=null)
			{
				c.setEmail(d.getEmail());
			}
		}
	}
	
	if(c.getNote()==null)
	{
		for(Contatto d : dupes)
		{
			if(d.getNote()!=null)
			{
				c.setNote(d.getNote());
			}
		}
	}
	
	db.updateContatti(c);
	dupes.remove(c);
	for(Contatto d:dupes)
	{
		db.delete(d.getId());
	}
}





}
