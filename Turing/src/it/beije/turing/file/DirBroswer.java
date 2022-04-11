package it.beije.turing.file;

import java.io.File;

public class DirBroswer {

	private static String Broswe(String fileName, int indent)
{
	StringBuilder output = new StringBuilder();
	for(int i = 0;i<indent;i++)
	{
		output.append(" ");
	}
	try {
		File file = new File(fileName);
		if(!file.exists())
		{
			System.out.println("file not found");
			return "Error";
		}
		if(file.isFile())
		{
			output.append(file.getName()+"\n");
		}
		else if(file.isDirectory())
		{
			output.append("DIR: "+file.getName()+"\n");
			File[] dir = file.listFiles();
			for(File f : dir)
			{
				output.append(Broswe(fileName+"/"+f.getName(),indent+1));
			}
		}
	}
	catch(Exception ioE)
	{
		ioE.printStackTrace();
	}
	if(indent==0)
	{
		System.out.print(output.toString());
	}
	return output.toString();
}
	public static String Broswe(String fileName)
	{
		return Broswe(fileName,0);	
	}
}
