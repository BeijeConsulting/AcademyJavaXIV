package it.beije.turing.xmlparser4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.file.Reader;

public class FileParser {

	
public List<String> parseFile(String fileName)
{
	/*List<String> list = new ArrayList<>();
	File file = new File(fileName);
	if(!file.exists()&&file.isDirectory())
	{
		throw new IllegalArgumentException("File non valido");
	}
	try {
		Reader reader = new Reader(fileName);
	
		while(reader.hasNext())
		{
			list.add(reader.nextLine().trim());
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	try {
		return read(fileName);
	} catch (IOException e) {
		e.printStackTrace();
		return null;
	}
}
public List<String> read(String path) throws IOException
{
	File file = new File(path);
	String s = Files.readString(file.toPath());
	return format(s);
}
private static StringBuilder addReturns(String s,int c)
{
	StringBuilder builder = new StringBuilder(s);
	int index = builder.indexOf(">",c);
	if(index==-1)
	{
		return builder;
	}
	else
	{
		builder=addReturns(builder.toString(),index+1);
	}
	if(builder.length()>=index+2&&builder.charAt(index+1)!='\n')
	{
		builder.insert(index+1, "\n");
	}
	return builder;
}
private List<String> format(String s)
{
	String[] tmp=addReturns(s,0).toString().split("\n");
	List<String> list = new ArrayList<>();
	for(String a:tmp)
	{
		if(!a.equalsIgnoreCase("\r"))
		list.add(a.trim());
	}
	return list;
}

}
