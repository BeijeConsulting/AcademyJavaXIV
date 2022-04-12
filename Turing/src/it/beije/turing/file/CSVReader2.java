package it.beije.turing.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.RubricaInterprete;

public class CSVReader2 {
public static List<Contatto> readCSV(String fileName, boolean b)
{
	List<Contatto> list = new ArrayList<>();
	try {
	Reader reader = new Reader(fileName);
	if(reader.canContinue())
	{
		String intestazione = reader.nextLine();
		RubricaInterprete interprete = new RubricaInterprete(intestazione,b);
		int count=0;
		while(reader.canContinue())
		{
			System.out.println(++count);
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
