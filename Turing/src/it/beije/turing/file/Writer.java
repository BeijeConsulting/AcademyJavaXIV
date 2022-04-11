package it.beije.turing.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
public static void Write(String fileName,String content)
{
	FileWriter writer = null;
	try
	{
		File file = new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();
		}
		writer= new FileWriter(file);
		writer.write(content);
	}
	catch(Exception e)
	{e.printStackTrace();}
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
