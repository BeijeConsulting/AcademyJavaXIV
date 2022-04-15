package it.beije.turing.xmlparser2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

public class XML_Reader {

	public static StringBuilder readText(String path) throws IOException, SAXException {
		StringBuilder stringBuilder = new StringBuilder();

		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.ready()) {
				stringBuilder.append(bufferedReader.readLine());
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
				throw fEx;
			}
		}
		
		isFileValid(stringBuilder);
		
		return stringBuilder;
	}

	public static StringBuilder removeVersion(StringBuilder stringBuilder) {
		
		if(stringBuilder.toString().startsWith("<?")) {
			for(int i = 0; i < stringBuilder.length(); i++) {
				if(stringBuilder.charAt(i) == '>' && stringBuilder.charAt(i - 1) == '?') {
					String str = stringBuilder.substring(i + 1, stringBuilder.length());
					return new StringBuilder(str);
				}
			}
		}  
		
		return new StringBuilder(stringBuilder);

	}

	public static boolean isFileValid(StringBuilder stringBuilder) throws SAXException {
		ArrayList<String> content = new ArrayList<>();

		StringBuilder sb = new StringBuilder(removeVersion(stringBuilder));

		if (!isBracketsValid(sb)) {
			throw new SAXException("Parentesi del file non valide");
		}

		return true;
	}

	public static boolean isBracketsValid(StringBuilder stringBuilder) {
		ArrayList<String> brackets = new ArrayList<>();
		boolean open = false;
		boolean attribute = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stringBuilder.length(); i++) {
			char c = stringBuilder.charAt(i);
			if (open && c == '<')
				return false;
			else if (c == '<') {
				open = true;
				sb.append(c);
			} else if (c == '>') {
				attribute = false;
				open = false;
				sb.append(c);
				if (sb.charAt(1) != '/' && sb.charAt(sb.length() - 2) == '/') {
					sb = new StringBuilder();
				} else if (sb.charAt(1) == '/') {
					if (sb.charAt(sb.length() - 2) == '/')
						return false;
					if (brackets.get(brackets.size() - 1).equals(sb.toString())) {
						brackets.remove(brackets.size() - 1);
						sb = new StringBuilder();
					} else {
						return false;
					}
				} else {
					sb.insert(1, "/");
					brackets.add(sb.toString());
					sb = new StringBuilder();
				}
			} else if (c != '<' && c != '>' && open && !attribute) {
				if (c == ' ') {
					attribute = true;
				} else {
					sb.append(c);
				}

			}
		}
		if (brackets.isEmpty())
			return true;
		else
			return false;
	}
}
