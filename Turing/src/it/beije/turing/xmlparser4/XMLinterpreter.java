package it.beije.turing.xmlparser4;

import java.util.ArrayList;
import java.util.List;

public class XMLinterpreter {

	private List<String> list;

	public XMLinterpreter(List<String> list) {
		this.list=list;
	}

	public void RemoveIntest() {
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
	
	public void Test()
	{
		List<Node> stack = new ArrayList<>();
		SeparateElements();
		/*for(String s:list)
		{
			if(!s.startsWith("/"))
		}*/
	}
	
}
