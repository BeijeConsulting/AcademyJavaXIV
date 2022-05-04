package it.beije.turing.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.ModificationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.repository.ContattoRepository;
import it.beije.turing.rubrica.CommandInterface;
import it.beije.turing.rubrica.bean.Contatto;
import it.beije.turing.rubrica.db.DbInterface;
import it.beije.turing.rubrica.db.JPA_Manager;

@Service
public class GestoreRubrica implements CommandInterface {
private static final String BASE_RUBRIC="tmp/Test.txt";
private List<Contatto> newEntries;
private List<Contatto> modifiedEntries;
private static GestoreRubrica self;
private DbInterface db;
@Autowired
private ContattoRepository cr;
private GestoreRubrica()
{
	db=new JPA_Manager();
	newEntries=new ArrayList<Contatto>();
	modifiedEntries=new ArrayList<>();
	
	/*File file = new File(BASE_RUBRIC);
	if(file.exists()&&file.isFile())
	{
		RubricImportCSV(BASE_RUBRIC,true);
	}*/
}


public static GestoreRubrica getInstance()
{
	if(self==null)
	{
		self=new GestoreRubrica();
	}
	return self;
}


//public void importCSV(String fileName, boolean apici) {
// List<Contatto> tmp = CSVReader2.readCSV(fileName, apici);
// for(Contatto c : tmp)
// {
//	 newEntries.add(c);
// }
//	}

public List<Contatto> getList()
{
//	List<Contatto> tmp = new ArrayList<>();
//	for(Contatto c:db.getContatti())
//	{
//		tmp.add(c);
//	}
//	return tmp;
	return cr.findAll();
}


/*public void save() {
	/*StringBuilder builder = new StringBuilder();
	RubricaInterpreteCSV interprete = new RubricaInterpreteCSV();
	builder.append(interprete.getHeader()+"\n");
	for(Contatto c : list)
	{
		builder.append(interprete.toCSV(c)+"\n");
	}
	save(builder.toString());
	db.insertContatti(newEntries);
	db.updateContatti(modifiedEntries);
	modifiedEntries=new ArrayList<>(); 
} 
*/


//private void save(String s)
//{
//	Writer.Write(BASE_RUBRIC, s);
//}


public void print(String mode) {
	switch(mode.toLowerCase())
	{
	case "byname" :
		//printOrdinaPerNome();
		break;
	case "default" :
		print();
	}
	
}


/*private void printOrdinaPerNome() {
	List<Contatto> tmp = new ArrayList<>();
	List<Integer> indexes = new ArrayList<>();
	tmp.add(list.get(0));
	indexes.add(list.indexOf(tmp.get(0)));
	for(int i = 1;i<list.size();i++)
	{
		int counter=tmp.size();
		Contatto tested = list.get(i); 
		for(int k=counter-1;k>=0;k--) {
			if(tested.getNome().compareToIgnoreCase(tmp.get(k).getNome())<0) //tested viene prima dell'elemento di temp
			{
				counter--;
				if(counter==0)
				{
					tmp.add(0,tested);
					indexes.add(0,list.indexOf(tested));
				}
			}
			else
			{
				if(counter==tmp.size())
				{
					tmp.add(tested);
					indexes.add(list.indexOf(tested));
				}
				else
				{
					tmp.add(counter, tested);
					indexes.add(counter,list.indexOf(tested));
					break;
				}
			}
				
		}
		
	}
	for(int i=0;i<tmp.size();i++)
	{
		System.out.println(indexes.get(i)+1+")  "+tmp.get(i));
	}
	
}
*/

public String print()
{
	StringBuilder builder = new StringBuilder();
	for(Contatto c : db.getContatti())
	{
		builder.append("<p>").append(c).append("<br>").append("</p>");
	}
	return builder.toString();
}


/*public void search(String nome, String cognome, String telefono, String email) {
	List<Contatto> tmp = new ArrayList<>();
	List<Integer> indexes  = new ArrayList<>();
	for(Contatto c : list)
	{
		if((c.getNome().equalsIgnoreCase(nome)||(nome.equalsIgnoreCase("X")))&&(c.getCognome().equalsIgnoreCase(cognome)||(cognome.equalsIgnoreCase("X")))&&(c.getTelefono().equalsIgnoreCase(telefono)||(telefono.equalsIgnoreCase("X")))&&(c.getEmail().equalsIgnoreCase(email)||(email.equalsIgnoreCase("X"))))
		{
			tmp.add(c);
			indexes.add(tmp.indexOf(c));
		}
	}
	for(int i = 0;i<tmp.size();i++)
	{
		System.out.println(indexes.get(i)+1+")  "+tmp.get(i));
	}
	
}

*/
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


/*public void delete(int i) {
	list.remove(i);
}*/

//public void ExportXML(String fileName)
//{
//	new RubricaInterpreteXML().ExportXML(db.getContatti(), fileName);
//}


//public void importXML(String fileName)
//{
//	List<Contatto> tmp = new ArrayList<>();
//	tmp= new RubricaInterpreteXML().importXML(fileName);
//	for(Contatto c : tmp)
//	{
//		newEntries.add(c);
//	}
//}


@Override
public List<Contatto> search(String... command) {
	StringBuilder query = new StringBuilder();
	for(int i=0;i<command.length;i+=2)
	{
		query.append(command[i]+"='"+command[i+1]+"' ");
		if(i+1!=command.length-1)
		{
			query.append(" AND ");
		}
	}
	return db.search(query.toString());
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
public List<Contatto> findDuplicates() {
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
	

	return dupes;
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
