package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

public class Document {
	ArrayList<StringBuilder> content = new ArrayList<StringBuilder>();
	
	public Document(StringBuilder fileContent) {
		StringBuilder strSup = new StringBuilder();
		
		for(int i = 0, j = 0, x = 0; i < fileContent.length(); i++) {
			char c = fileContent.charAt(i);
			
			if(c == '<' && fileContent.charAt(i + 1) != '?') {
				j++;
			}
			if(j == 1) {
				if(c != '<' && c != '>' && c != '/') {					
					strSup.append(c);
				}
				if(c == ' ' && strSup.indexOf("(") == -1) {
					strSup.append('(');
					x++;
				}
			}
			
			if(c == '>' && fileContent.charAt(i - 1) != '?') {
				
				if(x == 1) {
					strSup.append(')');
					x--;
				}
				
				j--;
				content.add(strSup);
				strSup = new StringBuilder();
			} 
			
			
		}
	}
	
	public static void main(String... args) throws IOException {
		
		Document elm = new Document(XML_Reader.readText("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"));
		System.out.println(elm.content);
	}
}
