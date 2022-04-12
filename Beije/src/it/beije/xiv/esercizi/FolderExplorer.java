package it.beije.xiv.esercizi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FolderExplorer {

	public static void main(String[] args)
	{
		FolderExplorer ftf = new FolderExplorer();
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Folder name: ");
		String path = kb.next();
		
		kb.close();
		
		String tree = ftf.explore(path, 0, "");
		String[] strings = tree.split("\n");
		FileWriter fw = null;
		
		try
		{
			fw = new FileWriter(new File("files" + path + ".txt"));
			for(int i = strings.length-1; i >= 0; i--)
			{
				fw.write(strings[i] + "\n");
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
				fw.flush();
				fw.close();
				System.out.println("File written.");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}		
	}
	
	private String explore(String path, int profondita, String text)
	{
		File file = new File(path);
		File[] files = file.listFiles();
		
		if (file == null) return text;
		
		for(File f : files)
		{
			if (f.isDirectory())
			{
				text = explore(f.getAbsolutePath(), profondita+1, text);
				String a = "";
				for(int i = 0; i < profondita; i++) a += " ";
				text += a + f.getName() + " (dir)\n";
			}
			else
			{
				String a = "";
				for(int i = 0; i < profondita; i++) a += " ";
				text += a + f.getName() + "\n";
			}
		}		
		return text;
	}
}