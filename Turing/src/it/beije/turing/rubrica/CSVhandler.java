package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVhandler
{
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator)			//Load csv
	{
		List<Contatto> contatti = new ArrayList<>();
		File file = new File(pathFile);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try
		{
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while(bufferedReader.ready())
			{
				String contatto = bufferedReader.readLine();
				String[] campi = null;
				
				if (contatto.charAt(0) == '"')
				{
					contatto = contatto.substring(1, contatto.length()-1);
					if (contatto.charAt(contatto.length()-1) == '"') contatto += " ";
					campi = contatto.split("\"" + separator +"\"");
				}
				else
				{
					if (contatto.charAt(contatto.length()-1) == separator.charAt(0)) contatto += " ";				//WORKS ONLY IF SEPARATOR IS SINGLE CHAR
					campi = contatto.split(separator);
				}
				
				Contatto nuovoContatto = new Contatto(campi[0], campi[1], campi[2], campi[3], campi[4]);			//HARDCODED for 4 fields being NOME;COGNOME;TELEFONO;EMAIL;NOTE
				
				contatti.add(nuovoContatto);
			}
		}
		catch (FileNotFoundException e)		//FILE DOESN'T EXIST
		{
			e.printStackTrace();
		}
		catch (IOException e)				//READING EXCEPTION (WHILE)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bufferedReader.close();
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
		return contatti;
	}

	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator)
	{
		File file = new File(pathFile);
		if (!file.exists())																//file exists?  so we can append anyway
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		FileWriter fileWriter = null;
		
		try
		{
			fileWriter = new FileWriter(file, true);
			
			for(Contatto contatto : contatti)
			{
				fileWriter.append(contatto.toFile(separator));
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
				fileWriter.flush();
				fileWriter.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}			
		}
	}
}