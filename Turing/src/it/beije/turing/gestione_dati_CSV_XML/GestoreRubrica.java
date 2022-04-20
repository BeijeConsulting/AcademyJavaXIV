package it.beije.turing.gestione_dati_CSV_XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.ModificationItem;

import it.beije.turing.db.ClassicDBManager;
import it.beije.turing.db.DbInterface;
import it.beije.turing.db.HibernateManager;
import it.beije.turing.file.Writer;
import it.beije.turing.file.csv.CSVReader2;
import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.RubricaInterpreteCSV;
import it.beije.turing.rubrica.RubricaInterpreteXML;

public class GestoreRubrica {
private static final String BASE_RUBRIC="tmp/Test.txt";
private List<Contatto> newEntries;
private List<Contatto> modifiedEntries;
private static GestoreRubrica self;
private DbInterface db;

private GestoreRubrica()
{
	db=new ClassicDBManager();
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


public void RubricImportCSV(String fileName, boolean apici) {
 List<Contatto> tmp = CSVReader2.readCSV(fileName, apici);
 for(Contatto c : tmp)
 {
	 newEntries.add(c);
 }
	}

public List<Contatto> getList()
{
	List<Contatto> tmp = new ArrayList<>();
	for(Contatto c:db.getContatti())
	{
		tmp.add(c);
	}
	for(Contatto c:newEntries)
	{
		tmp.add(c);
	}
	for(Contatto c:modifiedEntries)
	{
		tmp.add(c);
	}
	return tmp;
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


private void save(String s)
{
	Writer.Write(BASE_RUBRIC, s);
}


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

public void print()
{
	;
	for(Contatto c: getList())
	{
		System.out.println(c.getId()+")  "+c);
	}
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

public void ExportXML(String fileName)
{
	new RubricaInterpreteXML().ExportXML(db.getContatti(), fileName);
}


public void ImportXML(String fileName)
{
	List<Contatto> tmp = new ArrayList<>();
	tmp= new RubricaInterpreteXML().importXML(fileName);
	for(Contatto c : tmp)
	{
		newEntries.add(c);
	}
}

}
