package it.beije.turing.file.xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlTool {
private Document document;
private Element root;
private boolean isDocReady=false;
	
public static List<Element> getChildElements(Element element) {
	List<Element> childElements = new ArrayList<Element>();
	NodeList nodeList = element.getChildNodes();
	for (int n = 0; n < nodeList.getLength(); n++) {
		if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
	}
	return childElements;
}

public List<Element> readXml(String fileName)
{
	Document doc = makeDoc(fileName);
	if(doc!=null) {
	Element root = doc.getDocumentElement();
	return getChildElements(root);
	}
	else
	return null;
}

private Document makeDoc(String fileName)
{
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db=null;
	try {
		db = dbf.newDocumentBuilder();
		if(fileName.isEmpty())
		{
			return db.newDocument();
		}
		return db.parse(fileName);
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

private void newDocument()
{
	document=makeDoc("");
	root=document.createElement("ROOT");
	document.appendChild(root);
	isDocReady=true;
}


public void resetDoc()
{
	isDocReady=false;
}


public Element createElements(String name)
{
	if(!isDocReady)
	{
		newDocument();
	}
	Element e = document.createElement(name);
	root.appendChild(e);
	return e;
}

public void PrintToFile(String fileName)
{
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	try {
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult output = new StreamResult(new File(fileName));
		transformer.transform(source,output);
	} catch (TransformerConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
