package it.beije.turing.rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLhandler
{
	public List<Contatto> loadRubricaFromXML(String pathFile)					//TODO MANAGE FILE NOT EXISTING
	{
		List<Contatto> contatti = new ArrayList<>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(pathFile);
			
			Element root = document.getDocumentElement();
			
			List<Element> children = getChildElements(root);
						
			for (Element el : children)
			{
				Contatto nuovoContatto = new Contatto();							//HARDCODED for 4 fields being NOME;COGNOME;TELEFONO;EMAIL;NOTE
				
				if (el.getTagName().equalsIgnoreCase("contatto"))
				{
					List<Element> contatto = getChildElements(el);
					for (Element value : contatto)
					{
						switch (value.getTagName().toLowerCase())
						{
							case "nome":
								nuovoContatto.setNome(value.getTextContent());
								break;
								
							case "cognome":
								nuovoContatto.setCognome(value.getTextContent());				
								break;
								
							case "telefono":
								nuovoContatto.setTelefono(value.getTextContent());					
								break;
								
							case "email":
								nuovoContatto.setEmail(value.getTextContent());						
								break;
								
							case "note":
								nuovoContatto.setNote(value.getTextContent());				
								break;
	
							default:
								break;
						}
						
					}
				}
				
				contatti.add(nuovoContatto);
			}
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)									//FILE NOT FOUND
		{
			e.printStackTrace();
		}
		
		return contatti;
	}
		
	private List<Element> getChildElements(Element element)
	{
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			if (nodeList.item(i) instanceof Element) childElements.add((Element)nodeList.item(i));
		}
		
		return childElements;
	}
	
	public void writeRubricaXML(List<Contatto> contatti, String pathFile)
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			File file = new File(pathFile);
			Document doc = null;
			Element root = null;
			if (!file.exists())
			{
				doc = documentBuilder.newDocument();
				doc = documentBuilder.newDocument();
				root = doc.createElement("rubrica");
				doc.appendChild(root);
			}
			else
			{
				doc = documentBuilder.parse(file);
				root = doc.getDocumentElement();
			}
			 
			for(Contatto cont : contatti)
			{
				Element contatto = doc.createElement("contatto");
				
				Element nome = doc.createElement("nome");
				nome.setTextContent(cont.getNome());
				contatto.appendChild(nome);
				
				Element cognome = doc.createElement("cognome");
				cognome.setTextContent(cont.getCognome());
				contatto.appendChild(cognome);

				Element telefono = doc.createElement("telefono");
				telefono.setTextContent(cont.getTelefono());
				contatto.appendChild(telefono);

				Element email = doc.createElement("email");
				email.setTextContent(cont.getEmail());
				contatto.appendChild(email);

				Element note = doc.createElement("note");
				note.setTextContent(cont.getNote());
				contatto.appendChild(note);
				
				root.appendChild(contatto);
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(pathFile));

			transformer.transform(source, result);
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (TransformerException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}