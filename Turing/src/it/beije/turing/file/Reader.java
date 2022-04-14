package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	String fileName;
	private BufferedReader reader;
	public Reader(String fileName) throws IOException {
		this.fileName=fileName;
		File file = new File(fileName);
		if(!file.exists())
		{
			throw new IOException();
		}
		else
		{
			reader = new BufferedReader(new FileReader(file));
			
		}
	}
	public String nextLine() throws IOException
	{
		return reader.readLine();
	}
	public boolean hasNext() throws IOException
	{
		return reader.ready();
	}
}
