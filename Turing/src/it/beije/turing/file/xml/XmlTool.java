package it.beije.turing.file.xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlTool {
public List<Element> readXml(String fileName)
{
	
	Document doc = null;
	try {
		doc=db.parse(fileName);
		Element root = doc.getDocumentElement();
		return getChildElements(root);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	catch(SAXException sae) {
		sae.printStackTrace();
	} 
	catch (ParserConfigurationException e) {
		e.printStackTrace();
	}
	return null;
}
public static List<Element> getChildElements(Element element) {
	List<Element> childElements = new ArrayList<Element>();
	NodeList nodeList = element.getChildNodes();
	for (int n = 0; n < nodeList.getLength(); n++) {
		if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
	}
	return childElements;
}
private DocumentBuilder makeDocBuilder()
{
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db=null;
	try {
		db = dbf.newDocumentBuilder();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return db;
}
public  void createElements()
{
	
}
}
