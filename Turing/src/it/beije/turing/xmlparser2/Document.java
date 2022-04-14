package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

public class Document {
	ArrayList<StringBuilder> content = new ArrayList<StringBuilder>();
	Element root = new Element();
	
	public Document(StringBuilder fileContent) {
		StringBuilder strSup = new StringBuilder();
		StringBuilder strC = new StringBuilder();
		
		for(int i = 0, j = 0, x = 0, y = 0; i < fileContent.length(); i++) {
			char c = fileContent.charAt(i);
			
			//System.out.println(strSup);
			
			if(i > 2 && fileContent.charAt(i - 1) == '>' && c != '<' && c != '>') {
				y++;
			}
			if(y == 1 && c != '<') {
				strC.append(c);
			}
			
			if(y == 1 && c == '<') {
				y--;
				content.add(strC);
				strC = new StringBuilder();
			}
			
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
