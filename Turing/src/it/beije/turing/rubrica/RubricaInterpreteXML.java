package it.beije.turing.rubrica;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import it.beije.turing.file.xml.XmlTool;

public class RubricaInterpreteXML {
	
//Nome campi
	private final String ELEMENT = "Contatto";
	private final String NAME = "nome";
	private final String SURNAME = "cognome";
	private final String PHONE = "telefono";
	private final String MAIL = "email";
	private final String NOTES = "notes";
	
	
private XmlTool tool;


public RubricaInterpreteXML()
{
	this.tool=new XmlTool();
}


//READING

private List<Element> ReadFile(String fileName)
{
	return tool.readXml(fileName);
}


private Contatto read(Element e)
{
	Contatto c = new Contatto();
	c.setNome(e.getAttribute(NAME));
	c.setCognome(e.getAttribute(SURNAME));
	c.setTelefono(e.getAttribute(PHONE));
	c.setEmail(e.getAttribute(MAIL));
	c.setNote(e.getAttribute(NOTES));
	return c;	
}


public List<Contatto> importXML(String fileName)
{
	List<Contatto> list = new ArrayList<Contatto>();
	for(Element e:ReadFile(fileName))
	{
		list.add(read(e));
	}
	return list;
}

//WRITING

private Element convert(Contatto c)
{
	Element e = tool.createElements(ELEMENT);
	e.setAttribute(NAME, c.getNome());
	e.setAttribute(SURNAME,c.getCognome());
	e.setAttribute(PHONE, c.getTelefono());
	e.setAttribute(MAIL, c.getEmail());
	e.setAttribute(NOTES, c.getNote());
	return e;
}


private void convertList(List<Contatto> list)
{
	for(Contatto c : list)
	{
		convert(c);
	}
}

public void ExportXML(List<Contatto> list,String fileName)
{
	tool.resetDoc();
	convertList(list);
	tool.PrintToFile(fileName);
}

}

 