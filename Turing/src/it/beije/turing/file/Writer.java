package it.beije.turing.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
public static void main(String...args)
{
	final String fileName="Test.txt";
	FileWriter writer = null;
	try
	{
		writer= new FileWriter(fileName);
		writer.write("porcodio");
	}
	catch(Exception e)
	{System.out.println("no file");}
	finally
	{
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
