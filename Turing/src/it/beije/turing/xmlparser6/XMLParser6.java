package it.beije.turing.xmlparser6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Pagani Mattia, Provezza Matteo
 *
 */

public class XMLParser6
{
	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException
	{
		Scanner kb = new Scanner(System.in);								//creo tastiera
		System.out.print("Inserire path: ");
		XMLDocument document = parse(readFile(kb.next()));					//parsing del file preso da input utente e metto in nuovo xmldocument
		
		
		System.out.println("Root: " + document.getRootElement().getTagName());
		
		for(Elemento a : document.getRootElement().getElementsByTagName("contatto"))
		{
			System.out.println(a.getTagName());
		}
		
		
		System.out.println("TagName: " + document.getListElement().get(0).getTagName());
		System.out.println("TextContent: " + document.getListElement().get(2).getTextContent());
		
		for(Attributo a : document.getListElement().get(2).getAttributes())
		{
			System.out.println("Attributo: " + a.getNome());
		}
		
		System.out.println("Attributo eta': " + document.getListElement().get(2).getAttribute("eta"));
		
		kb.close();															//chiudo tastiera
	}
	
	
	
	public static XMLDocument parse(String file)
	{
		if (file == null || file.length() == 0) throw new IllegalArgumentException("File non valido.");
		
		XMLDocument document = new XMLDocument();
		
		//System.out.println(file);
		
		StringBuilder sb = new StringBuilder(file);
		XMLLexer lexer = new XMLLexer();
		StringBuilder current = new StringBuilder();
		List<String> elementTags = new ArrayList<>();
		List<Elemento> elementList = new ArrayList<>();
		List<Testo> textList = new ArrayList<>();
		String testo = "";
		int i = 0;
		int type = -1;
		
		while(sb.length() != 0)
		{
			char c = sb.charAt(i);
			
			switch(c)
			{
				case '<':											//GESTIORE QUANDO TAG GIA' APERTO (TYPE != -1 ERRORE)
					char next = lexer.peek(sb.toString(), i+1);
					type = lexer.analyzeOpenToken(next);
					current.append(c);
					break;
					
				case '>':
					current.append(c);
					if (type == 0)										//? PROLOG
					{
						if (current.charAt(current.length()-2) == '?')
						{
							Prolog p = new Prolog();
							p.setTagName(null);
							p.setChildNodes(null);
							
							current.delete(0, 2);  //<? ?>
							current.delete(current.length()-2, current.length());
							
							p.setAttributes(lexer.setAttributes(current));
							document.setPrologElement(p);
							sb.delete(0, i);
							current = new StringBuilder();
							type = -1;
							i = 0;
							break;
						}
						
						throw new RuntimeException("PROLOG ERRATO.");
					}
					else if (type == 1) {}								//! NON GESTITO
					else if (type == 2)									//CHIUDO ELEMENTO (/)
					{
						elementTags.add(current.substring(1, current.length()-1));
						sb.delete(0, i+1);
						current = new StringBuilder();
						type = -1;
						i = -1;
					}
					else if (type == 3)									//ELEMENTO NUOVO
					{
						current.delete(0,1);
						current.delete(current.length()-1, current.length());
						
						String tag = lexer.createToken(current);
						Elemento e = new Elemento();
						e.setTagName(tag);
						current.delete(0, tag.length()+1);
						e.setAttributes(lexer.setAttributes(current));
						if (document.getRootElement() == null)
						{
							e.setParent(null);
							document.setRootElement(e);
						}
						else e.setParent(lexer.checkForParent(elementList, elementTags));
						
						elementTags.add(tag);
						elementList.add(e);
						sb.delete(0, i+1);
						current = new StringBuilder();
						type = -1;
						i = -1;
					}
					
					break;
					
				case '\t':
					sb.delete(0, i);
					i = 0;
					type = -1;
					current = new StringBuilder();
					break;
					
				default:
					if (type != -1) current.append(c);
					else
					{
						testo += c;
						if (lexer.peek(sb.toString(), i+1) == '<')
						{
							Testo text = new Testo();
							text.setTesto(testo);
							testo = "";
							textList.add(text);
							elementList.get(elementList.size()-1).setTextContent(text);
							sb.delete(0, i);
							i = 0;
							type = -1;
							current = new StringBuilder();
						}
					}
					break;
			}
			
			
			i++;
		}
		
		if (!lexer.checkClosing(elementTags)) throw new RuntimeException("TAG NOT CLOSED.");
		else System.out.println("PARSING CORRETTO");
		
		
		for(int j = elementList.size()-1; j >= 0; j--)
		{
			if (elementList.get(j).getParent() != null)	elementList.get(j).getParent().setChildElements(elementList.get(j)); 
		}
		
		document.setListElement(elementList);
		return document;
	}
	
	static String readFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		
		if (!file.exists())
		{
			throw new FileNotFoundException("File non trovato.");
		}
		
		FileReader fileReader = new FileReader(file);						//apro reader con file esistente. FileNotFoundException gi� gestita, ma comunque non possibile.
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String fileXml = "";
		
		try
		{
			while (bufferedReader.ready())
			{
				fileXml += (bufferedReader.readLine());						//leggo il file
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bufferedReader.close();										//chiudo il bufferedreader
				fileReader.close();											//chiudo il reader
			}
			catch (IOException e)											//reader exceptions
			{
				e.printStackTrace();
			}
		}
		
		return fileXml;
	}
	
	
}