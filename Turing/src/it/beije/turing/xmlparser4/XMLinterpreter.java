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
		if(list.get(0).startsWith("<?"))
			{
				list.remove(0);
			}
	}
	
	
	/*public void SeparateElements()  //non più usato
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
	}*/
	
	public void print() //metodo per testing
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
		RemoveIntest(); //toglie l'intestazione
		
		
		for(int i=0;i<list.size();i++)//per ogni riga 
		{
			boolean hasContent = false; 
			boolean hasArgs=false;
			String name=null;
			String content=null;
			List<Attributes> attributes = new ArrayList<>();
			
			String s = list.get(i); //la prima riga
			
			
			if(s.startsWith("<!--")) 		//per ignorare i commenti
			{
				do {
				i++;
				}while(!list.get(i).contains("--"));
			}			
			else if(s.startsWith("<!"))
			{
				break;
			}
			
//				SE LA RIGA E' UN TAG			
			else if(s.startsWith("<")) 
			{
				
				 //se contiene </ "chiusura di un nodo"
				if(s.startsWith("</"))
				{
					if(s.substring(2,s.length()-1).equalsIgnoreCase(stack.get(stackCursor).getTagName())) //se la TAG di chiusura corrisponde all'ultimo nodo inserito
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
					
					
					//CONTROLLO SE HA ATTRIBUTI
				if(s.contains(" ")) 
				{
					name=s.substring(1,s.indexOf(" ")); //il tag senza la prima angolare
					extractAttribute(s,attributes);//chiamo il metodo che popola la lista di attributi
					if(!attributes.isEmpty())//se ha attributi
					{
						hasArgs=true;
					}
				}
				
					//ALTRIMENTI PROCEDO A STABILIRNE IL NOME
				else
				{
					name=s.substring(1,s.length()-1); //il nome del tag è la stringa senza angolari
				}
				
				
					//CONTROLLO SE HA UN TESTO ASSOCIATO
				if(!list.get(i+1).startsWith("<")) //se la riga dopo non è un tag
				{
					hasContent=true; //si tratta di testo
					StringBuilder builder = new StringBuilder();
					int k=i+1; //k è l'indica della riga seguente
					while(!list.get(k+1).contains("<")) //finchè la riga dopo è testo
					{
						builder.append(list.get(k));	//aggiungi al testo
						k++;
					}
					String endContent = list.get(k);  //questa è l'ultima riga del testo
					i=k;							// avanzo il ciclo for oltre il testo
					k=endContent.indexOf('<');		//la chiusura del tag rimane, nel formato, attaccata all' ultima riga di testo, questo mi da l'indice dove finisce il testo ed inizia il tag
					if(k==-1)	
					{
						//Se per qualche motivo manca la chiusura inline del testo
						throw new Exception("Errore nella formattazione di input oppure mancata chiusura di un nodo con testo");		//se non viene chiuso il tag c'è un errore
					}
					else
					{
						builder.append(endContent.substring(0,k)); //includo la parte non tag nel testo
					}
					
					
					//CONTROLLO CHE IL NODO SIA CHIUSO PRIMA DI METTERLO COME FIGLIO O COME ROOT
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
						
					}
					else //SE NON VIENE CHIUSO IN RIGA POTREBBE AVERE FIGLI
					{
						Node node = new Node(name,hasArgs?attributes:null,hasContent?content:"");
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
				}//FINE CONTROLLO SUL TESTO
				
				
				else//se non ha testo
				{
					Node node = new Node(name,hasArgs?attributes:null,hasContent?content:""); //lo metto dentro senza problemi
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
					stackCursor++;// SE NON VIENE CHIUSO IMMEDIATAMENTE POTREBBE AVERE FIGLI
					}
				}
				}
				
			}
			else if(s.contains("<"))
			{
				list.set(i,s.substring(s.indexOf('<')));
				i--;
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
		   
		 //TOLGO LA PARTE DEL TAG
		   s=s.substring(s.indexOf(' ')+1);
		   
		   //SCORRO LA RIGA
		   int k=0;
		   for(;k<s.length();k++)
		   {
			   if(s.charAt(k)=='=')  //QUANDO TROVO L'UGUALE
			   {
				   name = s.substring(0,k); //LA PARTE A SINISTRA DIVENTA IL NOME
				   if(s.charAt(k+1)=='"') // SE CI SONO LE VIRGOLETTE
				   {
					  int end = s.indexOf('"',k+2);
					  value = s.substring(k+2,end);  //IL VALORE DELL'ATTRIBUTO E' LA PARTE TRA APICI
					  k=end;
					  attributes.add(new Attributes(name,value));
					  break;
					  
				   }
				   else
					   return;
			   }
		   }
		   
		   
			   if(k!=s.length()-1) //SE NON HO RAGGIUNTO LA FINE DELLA STRINGA POTREBBERO ESSERCENE DI PIU'
			   {
				   extractAttribute(s.substring(k+1),attributes);//LA STRINGA PARTE DA DOPO LA CHIUSURA DEGLI APICI
			   }
		  
		   
		}
	}




}
