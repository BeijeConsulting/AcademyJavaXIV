package it.beije.turing.xmlparser2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XML_Reader {
	
	public StringBuilder readText(String path) {
		StringBuilder stringBuilder = new StringBuilder();
		
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null; 
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			while(bufferedReader.ready()) {
				stringBuilder.append(bufferedReader.readLine());
			}
		}catch(IOException e) {e.printStackTrace();}
		
		return stringBuilder;
	}

}
