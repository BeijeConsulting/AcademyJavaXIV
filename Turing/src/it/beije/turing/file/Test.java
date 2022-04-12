package it.beije.turing.file;

import java.util.List;

import it.beije.turing.file.csv.CSVReader2;
import it.beije.turing.rubrica.Contatto;

public class Test {
public static void main(String...args)
{
	String fileName = "tmp/rubrica.csv";
	
	List<Contatto> list = CSVReader2.readCSV(fileName,false);
	for(Contatto c : list)
	{
		System.out.println(c);
	}
}
}
