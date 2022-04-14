package it.beije.turing.xmlparser4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class XMLinterpreter {
	private List<String> list;

	public XMLinterpreter(List<String> list)
	{
		this.list=list;
	}
	public void RemoveIntest()
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
	public void SeparateElements()
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
	public Node ParseRoot() throws Exception
	{
		List<Node> stack = new ArrayList<>();
		int stackCursor=-1;
		RemoveIntest();
		for(int i=0;i<list.size();i++)
		{
			boolean hasContent = false;
			boolean hasArgs=false;
			String name=null;
			String content=null;
			List<Attributes> attributes = new ArrayList<>();
			String s = list.get(i);
			if(s.startsWith("<"))
			{
				if(s.startsWith("</"))
				{
					if(s.substring(2,s.length()-1).equalsIgnoreCase(stack.get(stackCursor).name))
							{
								stackCursor--;
							}
					else
					{
						throw new Exception("Missed node closure" + i);
					}
				}
				else {
				if(s.contains(" "))
				{
					name=s.substring(1,s.indexOf(" "));
					extractAttribute(s,attributes);
					if(!attributes.isEmpty())
					{
						hasArgs=true;
					}
				}
				else
				{
					name=s.substring(1,s.length()-1);
				}
				if(!list.get(i+1).startsWith("<"))
				{
					hasContent=true;
					StringBuilder builder = new StringBuilder();
					int k=i+1;
					while(!list.get(k+1).startsWith("<"))
					{
						builder.append(list.get(k));
						k++;
					}
					String endContent = list.get(k);
					i=k;
					k=endContent.indexOf('<');
					if(k==-1)
					{
						throw new Exception();
					}
					else
					{
						builder.append(endContent.substring(0,k));
					}
					if(endContent.substring(k+2,endContent.length()-1).equals(name))
					{
						content=builder.toString();
						stack.add(new Node(name,hasArgs?attributes:null,hasContent?content:null));
					}
					else 
					{
						stack.add(new Node(name,hasArgs?attributes:null,hasContent?content:null));
						stackCursor++;
					}
				}
				else
				{
					stack.add(new Node(name,hasArgs?attributes:null,hasContent?content:null));
					stackCursor++;
				}
				}
				
			}
			
		}
		return stack.get(0);
	}
	//method for attr.
	private void extractAttribute(String s,List<Attributes> attributes)
	{
		if(s.contains(" "))
		{
		   String name;
		   String value;
		   s=s.substring(s.indexOf(' '));
		   for(int k=0;k<s.length();k++)
		   {
			   if(s.charAt(k)=='=')
			   {
				   name = s.substring(0,k);
				   if(s.charAt(k+1)=='"')
				   {
					  int end = s.indexOf('"',k+2);
					  value = s.substring(k+1,end);
					  k=end;
					  attributes.add(new Attributes(name,value));
				   }
				   else
					   return;
			   }
			   if(k!=s.length()-1)
			   {
				   extractAttribute(s.substring(k+1),attributes);
			   }
		   }
		   
		}
	}
}
