package it.beije.turing.gestione_dati_CSV_XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.file.Writer;
import it.beije.turing.file.csv.CSVReader2;
import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.RubricaInterpreteCSV;

public class GestoreRubrica {
private static final String BASE_RUBRIC="tmp/Test.txt";
private List<Contatto> list;
private static GestoreRubrica self;

private GestoreRubrica()
{
	list = new ArrayList<Contatto>();
	File file = new File(BASE_RUBRIC);
	if(file.exists()&&file.isFile())
	{
		RubricImportCSV(BASE_RUBRIC,true);
		AggiornaLista();
	}
}
public static GestoreRubrica getInstance()
{
	if(self==null)
	{
		self=new GestoreRubrica();
	}
	return self;
}


private void AggiornaLista() {
	// TODO Auto-generated method stub
	
}

public void RubricImportCSV(String fileName, boolean apici) {
 List<Contatto> tmp = CSVReader2.readCSV(fileName, apici);
 for(Contatto c : tmp)
 {
	 list.add(c);
 }
	}

public List<Contatto> getList()
{
	return list;
}
public void save() {
	StringBuilder builder = new StringBuilder();
	RubricaInterpreteCSV interprete = new RubricaInterpreteCSV();
	builder.append(interprete.getHeader()+"\n");
	for(Contatto c : list)
	{
		builder.append(interprete.toCSV(c)+"\n");
	}
	save(builder.toString());
}
private void save(String s)
{
	Writer.Write(BASE_RUBRIC, s);
}
public void print(String mode) {
	switch(mode.toLowerCase())
	{
	case "byname" :
		printOrdinaPerNome();
		break;
	case "default" :
		print();
	}
	
}
private void printOrdinaPerNome() {
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
public void print()
{
	int count=0;
	for(Contatto c: list)
	{
		System.out.println(++count+")  "+c);
	}
}
public void search(String nome, String cognome, String telefono, String email) {
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
public void add(String nome, String cognome, String telefono, String email,String note)
{
	Contatto c = new Contatto();
	list.add(c);
	modify(list.size()-1,nome,cognome,telefono,email,note);
}
public void modify(int x,String nome, String cognome, String telefono, String email,String note) {
	Contatto c = list.get(x);
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
	
}
public void delete(int i) {
	list.remove(i);
}
}
