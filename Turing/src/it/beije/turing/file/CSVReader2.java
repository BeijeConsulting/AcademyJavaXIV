package it.beije.turing.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class CSVReader2 {
public static List<Contatto> readCSV(String fileName)
{
	List<Contatto> list = new ArrayList<>();
	try {
	Reader reader = new Reader(fileName);
	}
	catch(IOException e)
	{
		System.out.println("Something went wrong");
		e.printStackTrace();
	}
	return list;
}
	
}
