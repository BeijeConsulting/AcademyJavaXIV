package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

public class Element {
	ArrayList<StringBuilder> tags = new ArrayList<StringBuilder>();
	
	public Element(StringBuilder fileContent) {
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
				tags.add(strSup);
				strSup = new StringBuilder();
			}
		}
	}
	
	public static void main(String... args) throws IOException {
		XML_Reader reader = new XML_Reader();
		StringBuilder fileStr = reader.readText("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml");
		
		Element elm = new Element(fileStr);
		System.out.println(elm.tags);
	}
}
