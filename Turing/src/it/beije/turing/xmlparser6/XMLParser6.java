package it.beije.turing.xmlparser6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Pagani Mattia, Provezza Matteo
 *
 */

public class XMLParser6
{
	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException
	{
		Scanner kb = new Scanner(System.in);								//creo tastiera
		XMLDocument document = parse(readFile(kb.next()));					//parsing del file preso da input utente e metto in nuovo xmldocument
		
		kb.close();															//chiudo tastiera
	}
	
	
	
	public static XMLDocument parse(String file)
	{
		if (file == null || file.length() == 0) throw new IllegalArgumentException("File non valido.");
		
		
		return null;
	}
	
	static String readFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		
		if (!file.exists())
		{
			throw new FileNotFoundException("File non trovato.");
		}
		
		FileReader fileReader = new FileReader(file);						//apro reader con file esistente. FileNotFoundException gi� gestita, ma comunque non possibile.
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String fileXml = null;
		
		try
		{
			while (bufferedReader.ready())
			{
				fileXml += (bufferedReader.readLine());						//leggo il file
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bufferedReader.close();										//chiudo il bufferedreader
				fileReader.close();											//chiudo il reader
			}
			catch (IOException e)											//reader exceptions
			{
				e.printStackTrace();
			}
		}
		
		return fileXml;
	}
}