package it.beije.turing.xmlparser4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class XMLinterpreter {
	private List<String> list; //Le righe del file

	public XMLinterpreter(List<String> list)
	{
		this.list=list;
	}
	public void RemoveIntest() //toglie l'intestazione dal file
	{
		String s = list.get(0);
		
		int end=0;
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
		     if(c=='>')
			{
				end=i;
				break;
			}
		}
		if(end!=s.length()-1) {
		s=s.substring(end);
		list.set(0,s);
		}
		else
		list.remove(0);
	}
	public void SeparateElements()  //sistema la lista di stringhe in un formato prevedibile
	{
		RemoveIntest();
		
		for(int i=0;i<list.size();i++) 
		{
			String split[]=list.get(i).split("><"); 
			if (split.length>1)
			{
				int tmp=i;
				for(String s:split)
				{
				list.add(i+1, s);
				i++;
				}
				list.remove(tmp);
			}
		}
		for(int i=0;i<list.size();i++)
		{
			if(!list.get(i).isEmpty())
			System.out.println(list.get(i));
			else
			{
				list.remove(i);
				i--;
			}
		}
	}
	
	public void print()
	{
		RemoveIntest();
		for(String s:list)
		{
			System.out.println(s);
		}
	}
	public Node ParseRoot() throws Exception //Ritorna il nodo Root con tutti i figli e relativi attributi
	{
		List<Node> stack = new ArrayList<>(); //la lista dei nodi
		Node root=null;
		int stackCursor=-1; //indica l'ultimo nodo aperto e non ancora chiuso
		RemoveIntest();
		for(int i=0;i<list.size();i++)//per ogni riga 
		{
			boolean hasContent = false; 
			boolean hasArgs=false;
			String name=null;
			String content=null;
			List<Attributes> attributes = new ArrayList<>();
			
			String s = list.get(i); //la prima riga
			if(s.startsWith("<")) //se incomincia con un angolare
			{
				if(s.startsWith("</")) //se contiene </ "chiusura di un nodo"
				{
					if(s.substring(2,s.length()-1).equalsIgnoreCase(stack.get(stackCursor).name)) //se la TAG di chiusura corrisponde all'ultimo nodo inserito
							{
								stack.remove(stackCursor);
								stackCursor--; //considero il nodo chiuso correttamente
							}
					else
					{
						throw new Exception("Missed node closure"); //altrimenti mi lamento
					}
				}
				else { //se non si tratta di un tag di chiusura
				if(s.contains(" ")) //ed ha degli spazi
				{
					name=s.substring(1,s.indexOf(" ")); //il tag senza la prima angolare
					extractAttribute(s,attributes);//chiamo il metodo per la lista di attributi
					if(!attributes.isEmpty())//se ha attributi
					{
						hasArgs=true;
					}
				}
				else
				{
					name=s.substring(1,s.length()-1); //il nome del tag è la stringa senza angolari
				}
				if(!list.get(i+1).startsWith("<")) //se la riga dopo non è un tag
				{
					hasContent=true; //si tratta di testo
					StringBuilder builder = new StringBuilder();
					int k=i+1; //k è l'indica della riga seguente
					while(!list.get(k+1).startsWith("<")) //finchè la riga dopo è testo
					{
						builder.append(list.get(k));	//aggiungi al testo
						k++;
					}
					String endContent = list.get(k);  //questa è l'ultima riga del testo
					i=k;							// avanzo il ciclo oltre il testo
					k=endContent.indexOf('<');		//la chiusura del tag rimane, nel formato, attaccata al testo, così dove finisce il testo ed inizia il tag
					if(k==-1)	
					{
						throw new Exception("Errore nella formattazione di input oppure mancata chiusura di un nodo con testo");		//se non viene chiuso il tag c'è un errore
					}
					else
					{
						builder.append(endContent.substring(0,k)); //includo la parte non tag nel testo
					}
					if(endContent.substring(k+2,endContent.length()-1).equals(name))  //se il tag di chiusura corrisponde all'ultimo nodo aperto	
					{
						content=builder.toString(); //fisso il testo
						Node node = new Node(name,hasArgs?attributes:null,hasContent?content:null); //creo nodo
						if(stackCursor!=-1) //se non è il root
						{
							stack.get(stackCursor).addChild(node); //è il figlio di qualcuno
						}
						else
						{
							root=node;
						}
						//stack.add(node);//lo metto in stack anceh lui ma è già stato chiuso perciò non serve modificare il contatore
					}
					else 
					{
						Node node = new Node(name,hasArgs?attributes:null,hasContent?content:null);
						if(stackCursor!=-1)
						{
							stack.get(stackCursor).addChild(node);
						}
						else
						{
							root=node;
						}
						stack.add(node);
						stackCursor++;
					}
				}
				else//se non ha testo
				{
					Node node = new Node(name,hasArgs?attributes:null,hasContent?content:null); //lo metto dentro senza problemi
					if(stackCursor!=-1)
					{
						stack.get(stackCursor).addChild(node);
					}
					else
					{
						root=node;
					}
					stack.add(node);
					if(!s.substring(s.length()-2).equals("/>")) {
					stackCursor++;//mi aspetto una chiusura
					}
				}
				}
				
			}
			
		}
		if(root==null)
		{
			throw new Exception("root nullo");
		}
		return root; //do indietro il root
	}
	//method for attr.
	private void extractAttribute(String s,List<Attributes> attributes)
	{
		if(s.contains(" "))
		{
		   String name;
		   String value;
		   s=s.substring(s.indexOf(' ')+1);
		   int k=0;
		   for(;k<s.length();k++)
		   {
			   if(s.charAt(k)=='=')
			   {
				   name = s.substring(0,k);
				   if(s.charAt(k+1)=='"')
				   {
					  int end = s.indexOf('"',k+2);
					  value = s.substring(k+2,end);
					  k=end;
					  attributes.add(new Attributes(name,value));
					  break;
					  
				   }
				   else
					   return;
			   }
		   }
			   if(k!=s.length()-1)
			   {
				   extractAttribute(s.substring(k+1),attributes);
			   }
		  
		   
		}
	}




}
