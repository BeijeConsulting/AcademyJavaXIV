package it.beije.turing.xmlparser6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLLexer
{
	public char peek(String s, int pos)
	{
		return s.charAt(pos);
	}
	
	public int analyzeOpenToken(char next)			//0 = prolog, 1 = !, 2 = chiusura tag, 3 = string
	{
		switch(next)
		{
			case '?':
				return 0;
				
			case '!':
				throw new RuntimeException("TYPE NOT HANDLED -> " + next);
				
			case '/':
				return 2;
				
			default:
				return 3;
		}
	}

	public String createToken(StringBuilder current)
	{
		String tag = "";
		
		for(int i = 0; i < current.length(); i++)
		{
			if (current.charAt(i) == ' ') return tag;
			tag += current.charAt(i);
		}
		
		return tag;
	}

	public List<Attributo> setAttributes(StringBuilder current)					//<?     ?>				< 			>
	{
		List<Attributo> attributes = new ArrayList<>();
		String token = "";  //version
		String value = ""; //null
		
		
		while(current.length() != 0)
		{
			for(int i = 0; i < current.length(); i++)
			{
				char c = current.charAt(i);
								
				if (c == ' ')
				{
					current.delete(0, i+1);
					break;
				}
				
				if (c == '=')
				{
					current.delete(0, i+1);
					i = -1;
				}
				
				if (c == '"')
				{
					while(peek(current.toString(), i+1) != '"')
					{
						value += peek(current.toString(), i+1);
						i++;
					}
					
					current.delete(0, i+2);
					break;
				}
				
				if (c != '=') token += c;
			}
			
			
			if (!token.equals("")) attributes.add(new Attributo(token, value));
			token = "";
			value = "";
		}
		
		
		for(int i = 0; i < attributes.size()-1; i++)
		{
			for(int j = i+1; j < attributes.size(); j++)
			{
				if (attributes.get(i).getNome().equals(attributes.get(j).getNome())) throw new RuntimeException("DUPLICATE ATTRIBUTE." + attributes.get(i).getNome());
			}
		}
		
		return attributes;
	}

	public Elemento checkForParent(List<Elemento> elementList, List<String> elementTags)
	{
		List<String> elementTemp = new ArrayList<>();
		
		for(String s : elementTags)
		{
			elementTemp.add(s);
		}
		
		
		for(int i = elementTemp.size()-1; i >= 0; i--)
		{
			if (elementTemp.get(i).charAt(0) == '/') continue;
			
			if (i+1 <= elementTemp.size()-1 && elementTemp.get(i).equals(elementTemp.get(i+1).substring(1)))
			{
				elementTemp.remove(i+1);
				elementTemp.remove(i);
				continue;
			}
			
			for(int j = elementList.size()-1; j >= 0; j--)
			{
				if (elementList.get(j).getTagName().equals(elementTemp.get(i))) return elementList.get(j);
			}
		}
		
		return null;
	}

	public boolean checkClosing(List<String> elementTags)
	{
		for(int i = 0; i < elementTags.size(); i++)
		{
			if (elementTags.get(i).charAt(0) == '/')
			{
				if (elementTags.get(i).substring(1).equals(elementTags.get(i-1)))
				{
					elementTags.remove(i);
					elementTags.remove(i-1);
					i--;
				}
				else return false;
			}
			else
			{
				if (i+1 < elementTags.size() && elementTags.get(i+1).charAt(0) == '/')
				{
					if (elementTags.get(i).equals(elementTags.get(i+1).substring(1)))
					{
						elementTags.remove(i+1);
						elementTags.remove(i);
						i--;
						continue;
					}
					else return false;
				}
				else if (i+1 >= elementTags.size()) return false;
				else continue;
			}
			
			if (i >= elementTags.size()) i = 0;
		}
		
		return true;
	}
}