package it.beije.turing.file.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.file.Reader;
import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.RubricaInterpreteCSV;

public class CSVReader {
public static List<Contatto> readCSV(String fileName, boolean b)
{
	List<Contatto> list = new ArrayList<>();
	try {
	Reader reader = new Reader(fileName);
	if(reader.canContinue())
	{
		String intestazione = reader.nextLine();
		RubricaInterpreteCSV interprete = new RubricaInterpreteCSV(intestazione,b);
		
		while(reader.canContinue())
		{
			list.add(interprete.interpreta(reader.nextLine()));
		}
	}
	}
	catch(IOException e)
	{
		System.out.println("Something went wrong");
		e.printStackTrace();
	}
	return list;
}
	
}
