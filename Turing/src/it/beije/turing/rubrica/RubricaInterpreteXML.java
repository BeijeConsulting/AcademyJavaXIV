package it.beije.turing.rubrica;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import it.beije.turing.file.xml.XmlTool;

public class RubricaInterpreteXML {
private XmlTool tool;
public RubricaInterpreteXML(XmlTool tool)
{
	this.tool=tool;
}
private List<Element> ReadFile(String fileName)
{
	return tool.readXml(fileName);
}
private Contatto read(Element e)
{
	
	return null;	
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
}
