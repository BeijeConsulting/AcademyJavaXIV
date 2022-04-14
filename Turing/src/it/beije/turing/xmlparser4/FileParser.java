package it.beije.turing.xmlparser4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.file.Reader;

public class FileParser {

	
public List<String> parseFile(String fileName)
{
	List<String> list = new ArrayList<>();
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
	}
	return list;
}
}
