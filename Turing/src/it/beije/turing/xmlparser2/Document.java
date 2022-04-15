package it.beije.turing.xmlparser2;

import java.util.ArrayList;

public class Document {
	ArrayList<StringBuilder> content = new ArrayList<StringBuilder>();
	Element root = null;

	public Document(StringBuilder fileContent) {
		StringBuilder strSup = new StringBuilder();
		StringBuilder strC = new StringBuilder();

		for (int i = 0, j = 0, x = 0, y = 0; i < fileContent.length(); i++) {
			char c = fileContent.charAt(i);

			if (i > 2 && fileContent.charAt(i - 1) == '>' && c != '<' && c != '>') {
				y++;
				strC.append("t-");
			}
			if (y == 1 && c != '<') {
				strC.append(c);
			}

			if (y == 1 && c == '<') {
				y--;
				content.add(strC);
				strC = new StringBuilder();
			}

			if (c == '<' && fileContent.charAt(i + 1) != '?') {
				j++;
			}
			if (j == 1) {
				if (c != '<' && c != '>' && c != '/') {
					strSup.append(c);
				}
				if (c == ' ' && strSup.indexOf("(") == -1) {
					strSup.append('(');
					x++;
				}
			}

			if (c == '>' && fileContent.charAt(i - 1) != '?') {

				if (x == 1) {
					strSup.append(')');
					x--;
				}

				if (fileContent.charAt(i - 1) == '/') {
					strSup.append("**");
				}

				j--;
				content.add(strSup);
				strSup = new StringBuilder();
			}

		}
	}
	
	public Element getRootElement(Node node) {
		Element rootElm = new Element(node);
		
		rootElm.setAttributes(node);
		
		return rootElm;
	}

}
